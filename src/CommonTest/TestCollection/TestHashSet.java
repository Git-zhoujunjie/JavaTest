package CommonTest.TestCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 手动实现一个hashSet
 * hashSet本质是一个HashMap
 * @param <T>
 */
public class TestHashSet<T> {
    private static final Object PRESENT = new Object();

    Map<T,Object> map ;

    TestHashSet(){
        map = new HashMap<>();
    }

    public void add(T key){
        map.put(key,PRESENT);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(T key:map.keySet()){
            sb.append(key+",");
        }
        sb.setCharAt(sb.lastIndexOf(","),']');

        return sb.toString();
    }

    public static void main(String [] args){
        TestHashSet<Integer> test = new TestHashSet<>();

        test.add(11);
        test.add(22);
        test.add(25);

        test.add(43);
        test.add(22);


        System.out.println(test);
    }
}
