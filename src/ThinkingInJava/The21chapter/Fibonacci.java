package ThinkingInJava.The21chapter;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci implements Runnable{
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
