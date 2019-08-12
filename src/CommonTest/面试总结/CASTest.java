package CommonTest.面试总结;

import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.compareAndSet(5,2019)+"---"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,2020)+"---"+atomicInteger.get());
    }
}
