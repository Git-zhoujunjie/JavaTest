package CommonTest.面试总结;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    //只有达到指定线程数时，执行指定线程
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()-> System.out.println("******召唤神龙！"));

    public static void main(String[] args) {

        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+" 获得了第"+tempInt+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
