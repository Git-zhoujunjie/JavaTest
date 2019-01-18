package ThinkingInJava.The21chapter.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Fibonacci implements Runnable{
    private static int count = 0;
    private final int id = count++;
    private int n=1;
    public Fibonacci(int n){
        this.n = n;
    }
    public String arr(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        for(int i=2;i<=n;i++){
            list.add(list.get(i-2)+list.get(i-1));
        }
        return list.toString();
    }
    public void run(){
        System.out.println(id + " "+arr());
        Thread.yield();
    }
}
public class test2 {
    public static void main(String[] args){
        Random random = new Random();
        for(int i=0;i<5;i++) {
//            Thread ts = new Thread(new Fibonacci(random.nextInt(15)));
//            ts.start();
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new Fibonacci(random.nextInt(15)));
            exec.shutdown();
        }
    }
}
