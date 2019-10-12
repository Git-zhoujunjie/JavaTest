package CommonTest.面试总结.JVM;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class PhantomRefDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1,queue);
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());

        o1 = null;
        //只要有gc，弱引用一定会被回收
        System.gc();
        System.out.println();

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());
    }
}
