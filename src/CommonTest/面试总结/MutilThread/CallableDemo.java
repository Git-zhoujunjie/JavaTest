package CommonTest.面试总结;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread01 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread02 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        //暂停一会线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return 100;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws Exception{
        //new Thread(new MyThread01(),"AA").start();
        //FutureTask实现自Runnable接口，而构造方法可传入Callable接口，适配器模式
        FutureTask<Integer> task = new FutureTask<>(new MyThread02());
        new Thread(task,"BB").start();
        int m = 1;

        int get = 0;
        while(!task.isDone()){
            get = task.get();
        }

        System.out.println(m+get);

    }
}
