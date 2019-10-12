package CommonTest.面试总结.MutilThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  volatile/CAS/atomicInteger/BlockingQueue/线程交互/原子引用
 *  综合练习：实现生产者/消费者
 *
 *  总结：使用阻塞队列实现生产者/消费者模式时，不需要向synchronized或lock那样需要手动阻塞和唤醒
 */
class MyShare{  //资源类
    //用来表示是否进行生产或消费，为true表示工作，false表示停止
    private volatile boolean FLAG = true;

    private AtomicInteger atomicInteger = new AtomicInteger();
    //为了代码的复用性，这里阻塞队列通过构造方法传入
    private BlockingQueue<String> queue;

    public MyShare(BlockingQueue<String> queue){
        this.queue = queue;
        //打印日志，打印日志时需要打印细节
        System.out.println("当前实例化一个阻塞队列为："+this.queue.getClass().getName());
    }

    public void produce() throws Exception{
        //生产
        String data;
        boolean resValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
            resValue = this.queue.offer(data,1L, TimeUnit.SECONDS);
            if(resValue){
                System.out.println(Thread.currentThread().getName()+"\t  生产元素"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t  生产元素"+data+"失败");
            }
            //暂停一会线程
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        //生产失败 flag=false
        System.out.println(Thread.currentThread().getName()+"\t  结束生产");
    }

    public void consume() throws Exception{
        String result = null;
        while (FLAG){
            result = this.queue.poll(3L,TimeUnit.SECONDS);
            if(result==null || result.equalsIgnoreCase("")){
                //3秒没有获取到元素，表示消费失败
                FLAG = false;
                System.out.println();
                System.out.println(Thread.currentThread().getName()+"\t  消费元素失败");
                //退出
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t  消费元素成功"+result);
        }
    }

    public void exit(){
        FLAG = false;
    }
}

public class ProConsu_BlockingQueueDemo {
    public static void main(String[] args) {
        MyShare myShare = new MyShare(new ArrayBlockingQueue<>(5));

        new Thread(()->{
            try {
                myShare.produce();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Producer").start();
        new Thread(()->{
            try {
                myShare.consume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        //暂停一会线程
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        //5秒后main线程强制关闭生产和消费
        myShare.exit();
    }
}
