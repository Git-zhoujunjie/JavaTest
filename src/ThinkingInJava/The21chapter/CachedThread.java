package ThinkingInJava.The21chapter;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThread {
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            exec.execute(new Fibonacci(5));
        }
        exec.shutdown();
    }
}
