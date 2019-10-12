package CommonTest.面试总结.MutilThread;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * 手写一个死锁，并进行排查
 */

class MyResource implements Runnable{

    private String lock1;  //表示当前线程持有的资源
    private String lock2;  //表示当前线程请求的资源

    public MyResource(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "\t 持有资源" + lock1+"\t 尝试获得资源"+lock2);
            //暂停一会线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + "\t 持有资源" + lock2+"\t 尝试获得资源"+lock1);

            }
        }
    }
}
public class DeadLockDemo {

    public static void main(String[] args) {
//        String lock1 = "lock1";
//        String lock2 = "lock2";
//
//        new Thread(new MyResource(lock1,lock2),"ThreadAAA").start();
//        new Thread(new MyResource(lock2,lock1),"ThreadBBB").start();

        /**
         * Linux  ps -ef|grep xxxx  查看进程命令
         * window中
         */

        int[][] a = {{10,16}, {2,8}, {1,6}, {7,12}};
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<a.length;i++){
            map.put(a[i][0],a[i][1]);
        }
        for(int i=0;i<a.length;i++){
            a[i][0] = map.firstKey();
            a[i][1] = map.get(a[i][0]);
            map.remove(a[i][0]);
        }
        System.out.println(Arrays.toString(a));
    }

}


