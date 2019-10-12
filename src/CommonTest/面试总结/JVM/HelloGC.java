package CommonTest.面试总结.JVM;

public class HelloGC {

    public static void main(String[] args) throws Exception {
        /*//返回Java虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        //返回Java虚拟机中试图使用的最大内存总量
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("Total_Memory(-Xms) = "+totalMemory+" (字节)、"+(totalMemory/(double)1024/1024)+"MB");
        System.out.println("Max_Memory(-Xmx) = "+maxMemory+" (字节)、"+(maxMemory/(double)1024/1024)+"MB");*/

        byte[] bytes = new byte[20*1024*1024];
        System.out.println("**********HelloGC!");

        //Thread.sleep(Integer.MAX_VALUE);

    }
}
