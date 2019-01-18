package ThinkingInJava.The21chapter.test6;

import java.util.Random;
import java.util.concurrent.*;

public class test6 implements Runnable{
    Random random = new Random();
    public void run(){
        try {
            int t = 1000 * random.nextInt(10);
            TimeUnit.MILLISECONDS.sleep(t);
            System.out.println("Slept " + t/1000 + " seconds");
            return;
        }catch (InterruptedException e){
            System.out.println(e);
            return;
        }
    }
    public static void main(String[] args){
        int n = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < n; i++)
            exec.execute(new test6());
        exec.shutdown();

    }

}
