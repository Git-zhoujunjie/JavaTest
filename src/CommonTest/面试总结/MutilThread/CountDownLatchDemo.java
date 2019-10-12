package CommonTest.面试总结.MutilThread;

import java.util.concurrent.CountDownLatch;
/**
 * CountDownLatch 门闩
 */

public class CountDownLatchDemo {

    private static CountDownLatch ctl = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {

//        for (int i = 1; i <= 7; i++) {
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName()+"----离开教室");
//                ctl.countDown();
//            }, String.valueOf(i)).start();
//        }
//
//        ctl.await();
//        System.out.println("班长----离开教室");

        //枚举测试
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"----被灭掉了");
                ctl.countDown();
            }, EnmuDemo.getEnmu(i).getValue()).start();
        }

        ctl.await();
        System.out.println("秦国实现统一！！！");

        //枚举类似于一个表
        System.out.println(EnmuDemo.One);  //表名
        System.out.println(EnmuDemo.One.getKey());  //列名
        System.out.println(EnmuDemo.One.getValue());  //值
    }
}
