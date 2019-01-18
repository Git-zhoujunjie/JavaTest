package ThinkingInJava.The21chapter.test5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Fibonacci implements Callable {
    private static int count = 0;
    private final int id = count++;
    private int n=1;
    public Fibonacci(int n){
        this.n = n;
    }
    List<Integer> list = new ArrayList<Integer>();
    int sum =0;
    public String arr(){
        list.add(1);
        list.add(1);
        for(int i=2;i<=n;i++){
            list.add(list.get(i-2)+list.get(i-1));
        }
        return list.toString();
    }
    public int sum(){
        for(int i:list){
            sum += i;
        }
        return sum;
    }
    public String call(){
        //System.out.println(id + " "+arr() + " sum: " + sum());
        return id + " "+arr() + " sum: " + sum();
    }
}
