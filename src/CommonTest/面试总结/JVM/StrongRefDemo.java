package CommonTest.面试总结.JVM;

public class StrongRefDemo {

    public static void main(String[] args) {
        //默认是强引用
        Object o1 = new Object();
        Object o2 = o1;
        //o1被强制GC
        o1 = null;
        System.gc();

        System.out.println(o2);
    }
}
