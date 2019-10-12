package CommonTest.面试总结;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：多线程之间顺序调用，实现A->B->C三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 循环上述过程10轮
 *
 * 分析：synchronized中的wait和notify方法只能随机唤醒，要实现该题很困难
 *      而lock可以实现精确唤醒
 */

/**
 * 线程操作资源类
 */
class OrderThread{
    private int num=1; //默认从A线程开始，1表示A，2表示B，3表示C
    private Lock lock = new ReentrantLock();
    //表示锁的3把钥匙
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void printA(){
        lock.lock();
        try{
            //判断
            while(num!=1) c1.await();
            //执行
            for(int i=0;i<1;i++)
                System.out.println(Thread.currentThread().getName()+"      "+i);
            //唤醒
            num=2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try{
            //判断
            while(num!=2) c2.await();
            //执行
            for(int i=0;i<2;i++)
                System.out.println(Thread.currentThread().getName()+"      "+i);
            //唤醒
            num=3;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try{
            //判断
            while(num!=3) c3.await();
            //执行
            for(int i=0;i<3;i++)
                System.out.println(Thread.currentThread().getName()+"      "+i);
            System.out.println("------------------");
            //唤醒
            num=1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class SynchronizedAndLockDemo {

    public static void main(String[] args) {
        OrderThread orderThread = new OrderThread();

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                orderThread.printA();
            }, "AA").start();
            new Thread(() -> {
                orderThread.printB();
            }, "BB").start();
            new Thread(() -> {
                orderThread.printC();
            }, "CC").start();
        }
    }
}
