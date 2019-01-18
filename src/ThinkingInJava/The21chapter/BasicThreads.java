package ThinkingInJava.The21chapter;

public class BasicThreads {
    public static void main (String[] args) throws InterruptedException{
        for(int i=0;i<5;i++) {
            Thread t = new Thread(new LiftOff());
            t.start();
            //Thread.sleep(44);
            System.out.println("Waiting for LiftOff!");
        }
    }
}
