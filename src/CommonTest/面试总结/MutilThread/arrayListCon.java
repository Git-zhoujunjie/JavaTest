package CommonTest.面试总结.MutilThread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList线程不安全的case
 */
public class arrayListCon {

    public static void main(String[] args) {
//        List<String> list = Arrays.asList("1","2","3","4");
//        list.stream().forEach(System.out::println);
        //List<String> list = Collections.synchronizedList(new ArrayList<>());

        List<String> list = new CopyOnWriteArrayList<>();

        //Map<String,Object> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

        /**
         * 1.问题
         *      java.util.ConcurrentModificationException
         * 2.原因
         *
         * 3.解决方案
         *      3.1. 使用Vector
         *      3.2. 使用Collections.synchronizedList(new ArrayList<>())，synchronizedSet，synchronizedMap;
         *      3.3  使用CopyOnWriteArrayList，CopyOnWriteArraySet，ConcurrentHashMap
         *              注意：CopyOnWriteArraySet底层实际就是一个CopyOnWriteArrayList
         *                   HashSet底层是一个HashMap
         *
         *
         *
         *
         * 4.总结与优化
         *
         */
    }

}
