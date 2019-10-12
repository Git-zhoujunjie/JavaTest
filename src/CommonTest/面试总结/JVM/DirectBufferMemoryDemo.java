package CommonTest.面试总结.JVM;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class DirectBufferMemoryDemo {

    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory:"+ (sun.misc.VM.maxDirectMemory() / (double)1024 /1024)+"MB");
        //暂停一会线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        //-XX:MaxDirectMemorySize=5m   我们手动分配直接内存为5m，而这里需要6mm空间
        ByteBuffer bb = ByteBuffer.allocateDirect(6*1024*1024);
    }
}
