package CommonTest.面试总结.MutilThread;

import java.util.concurrent.*;

/**
 * 第4种获得/使用Java多线程的方法：线程池
 */
public class MyThreadPool {

    public static void main(String[] args) {
        //查看底层CPU核数
        //System.out.println(Runtime.getRuntime().availableProcessors());


        //通过线程池操作线程
        //ExecutorService service = Executors.newCachedThreadPool();  //一个线程池中有N个工作线程
        //ExecutorService service =Executors.newSingleThreadExecutor(); //一个线程池中有1个工作线程
        //ExecutorService pool =Executors.newFixedThreadPool(5); //一个线程池中有5个工作线程

        //自定义线程池
        ExecutorService pool = new ThreadPoolExecutor(
                2,  //常规核心线程数
                5,   //最大核心线程数
                3L,   //空闲线程存活时间
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),  //阻塞队列，容量为5
                Executors.defaultThreadFactory(),   //线程池工厂
                //拒绝策略
                //new ThreadPoolExecutor.AbortPolicy()  //当maximumPoolSize+queue<线程数时，会抛出异常
                new ThreadPoolExecutor.CallerRunsPolicy()  //当maximumPoolSize+queue<线程数时,会将处理不了的线程返回到发送来的线程
        );

        //模拟10个业务处理
        try {
            for(int i=0;i<=10;i++){
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t  处理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭线程池
            pool.shutdown();
        }

    }
}
