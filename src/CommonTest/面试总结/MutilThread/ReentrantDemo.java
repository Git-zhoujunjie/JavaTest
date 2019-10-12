package CommonTest.面试总结;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁测试
 *
 * case1：测试synchronized是可重入锁
 *
 *
 * case2：测试ReentrantLock是可重入锁
 */
public class ReentrantDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendSMS();
        },"t1").start();
        new Thread(()->{
            phone.sendSMS();
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("---------------------");
        System.out.println();


        Thread t3 = new Thread(phone,"t3");
        Thread t4 = new Thread(phone,"t4");
        t3.start();
        t4.start();
    }

}

class Phone implements Runnable{

    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName()+"----invoke sendSMS()");
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"---------invoke sendEmail()");
    }

    //锁只要配对，加多少都行
    Lock lock = new ReentrantLock();
    public void get(){
        lock.lock();
        //lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"----invoke sendget()");
            set();
        }finally {
            lock.unlock();
            //lock.unlock();
        }

    }
    public void set(){
        lock.lock();
        try {

            System.out.println(Thread.currentThread().getName()+"--------------invoke sendset()");

        }finally {
            lock.unlock();
        }
    }
    @Override
    public void run() {
        get();
    }
}
