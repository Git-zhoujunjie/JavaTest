package CommonTest.面试总结.JVM;

import java.lang.ref.SoftReference;

public class SoftRefDemo {

    public static void EnoughSpace(){
        //空间充足情况下，观察软引用
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1+"\n"+softReference.get());

        o1 = null;
        System.gc();

        System.out.println(softReference.get());  //没有被gc，因为当前默认堆空间内存充足
    }

    /**
     * JVM手动配置，故意产生大对象并配置小内存，导致OOM，看软引用回收情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void NotEnoughSpace(){

        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1+"\n"+softReference.get());

        o1 = null;
        //System.gc();

        try {
             byte[] b = new byte[10*1024*1024];
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println();
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }


    public static void main(String[] args) {

        //EnoughSpace();

        NotEnoughSpace();
    }
}
