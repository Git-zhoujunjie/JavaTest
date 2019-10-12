package CommonTest.面试总结.JVM;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("--------------");
        myWeakHashMap();
    }

    private static void myHashMap() {
        HashMap<Integer,String> map = new HashMap<>();
        Integer i = new Integer(1);
        String str = "myHashMap";
        map.put(i,str);
        System.out.println(map);

        i=null;
        System.out.println(map);
    }


    private static void myWeakHashMap() {
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer i = new Integer(2);
        String str = "myWeakHashMap";
        map.put(i,str);
        System.out.println(map);

        i=null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }
}
