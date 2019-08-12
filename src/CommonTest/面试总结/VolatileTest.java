package CommonTest.面试总结;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 测试volatile的可见性
 */
public class VolatileTest {
    @Test
    public void testVolatile(){
        ModifyVal test = new ModifyVal();

        new Thread(()->{
            System.out.println(Thread.currentThread()+"-----"+test.val);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.add();
            System.out.println(Thread.currentThread()+"-----"+test.val);
        }).start();

        while(test.val==0){}

        System.out.println(Thread.currentThread()+"-----"+test.val);

    }

    @Test
    public void testVolatileAtomic() {

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {

            }, String.valueOf(i)).start();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class ModifyVal{
    //int val = 0;
    volatile int val=0;

    void add(){
        val = 6;
    }
}
