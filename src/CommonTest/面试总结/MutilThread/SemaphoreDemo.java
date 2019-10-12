package CommonTest.面试总结.MutilThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); //模拟3个车位

        for (int i = 1; i <= 6; i++) {  //模拟6辆车抢3个车位
            new Thread(() -> {

                try {
                    semaphore.acquire();  //获取车位
                    System.out.println(Thread.currentThread().getName()+"------抢到了车位");
                    //停3秒
                    try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"---离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); //释放车位
                }

            }, String.valueOf(i)).start();
        }
    }
}
