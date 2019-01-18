package ThinkingInJava.The21chapter.test5;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class test5 {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> arrayList = new ArrayList<>();
        for(int i=0;i<10;i++){
            arrayList.add(exec.submit(new Fibonacci(15)));
        }
        for(Future<String> fs : arrayList){
            try {
                System.out.println(fs.get());
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
                return;
            }finally {
                exec.shutdown();
            }
        }
    }
}
