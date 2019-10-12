package CommonTest.面试总结.JVM;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeakRefDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        //只要有gc，弱引用一定会被回收
        System.gc();
        System.out.println();

        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
