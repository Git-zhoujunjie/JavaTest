package CommonTest.面试总结;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 手写一个自旋锁，即循环+CAS
 */
public class SpinLockDemo {
    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"----try get lock()");
        /*
        当atomicReference为空时，获取锁，将atomicReference设置为线程1
         */
        while(!atomicReference.compareAndSet(null,thread)){}
        System.out.println(thread.getName()+"----have got lock()");
    }

    public void myUnlock(){

        Thread thread = Thread.currentThread();
        /*
        当atomicReference为线程1时，释放锁
         */
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+"----invoke unlock()");
    }

    public static void main(String[] args) {
        SpinLockDemo lockDemo = new SpinLockDemo();
        new Thread(()->{
            lockDemo.myLock();
            //表示占用3秒锁
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            lockDemo.myUnlock();
        },"t1").start();
        new Thread(()->{
            lockDemo.myLock();
            //表示占用3秒锁
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            lockDemo.myUnlock();
        },"t2").start();
    }
}
