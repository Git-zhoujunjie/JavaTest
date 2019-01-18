package ThinkingInJava.The21chapter.test1;

public class test1 implements Runnable{
    protected int count = 3;
    private static int taskcount = 0;
    private final int id = taskcount++;
    public test1(){}
    public test1(int count){
        this.count = count;
    }
    public String status(){
        return id + " (" + taskcount + " )";
    }
    public void run(){
        for(int i=0;i<3;i++){
            System.out.println(status());
            Thread.yield();
        }
        System.out.println("End " + id);
        return;
    }
}
