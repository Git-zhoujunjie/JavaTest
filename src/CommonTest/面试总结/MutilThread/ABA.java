package CommonTest.面试总结.MutilThread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题解决方案
 */
public class ABA {


    public static void main(String[] args) {
        System.out.println("----------------ABA问题-------------------");
        AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace(); }
            atomicReference.compareAndSet(101, 100);
        }).start();
        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "===" + atomicReference.get());
        }).start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------------ABA问题解决-------------");
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);
        
        new Thread(()->{
            atomicStampedReference.compareAndSet(100,101,1, atomicStampedReference.getStamp()+1);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.getStamp()+"---"+atomicStampedReference.getReference());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(100,2019,1,atomicStampedReference.getStamp()+1));
            System.out.println(atomicStampedReference.getStamp()+"---"+atomicStampedReference.getReference());

        }).start();
    }
}
