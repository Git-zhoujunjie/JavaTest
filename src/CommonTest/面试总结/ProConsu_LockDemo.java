package CommonTest.面试总结;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  一个初始值为0的变量，两个线程对其交替操作，一个加1，一个减一，交替执行5次
 */

class ShareData {
    private int number;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition(); //条件

    //新增元素
    public void increment() throws Exception {
        lock.lock();
        try{
            //判断 ，注意这里用if会产生虚假唤醒，只能用循环
            while(number!=0){
                //表示有元素，等待生产通知
                //相当于this.wait();
                condition.await();
            }
            //生产
            number++;
            System.out.println(Thread.currentThread().getName()+"\t 生产了"+number);
            //相当于this.notifyAll()
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    //消费元素
    public void decrement() throws Exception{
        lock.lock();
        try{
            while(number==0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t 消费了"+number);
            //相当于this.notifyAll()
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ProConsu_LockDemo {
    public static void main(String[] args){
        ShareData shareData = new ShareData();
        //AA线程执行5次新增
        new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();
        //BB线程执行5次消费
        new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}
