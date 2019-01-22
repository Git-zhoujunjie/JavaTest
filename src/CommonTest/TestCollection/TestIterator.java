package CommonTest.TestCollection;


import java.util.*;

public class TestIterator {
    List list = new LinkedList();
    Set set = new TreeSet();
    Map<Integer,String> map = new HashMap();

    public static void main(String[] args){
        TestIterator test = new TestIterator();
        for(int i=0;i<5;i++){
            test.list.add("list"+i);
            test.set.add("Set"+i);
            test.map.put(i,"Map"+i);
        }

        for(Iterator it = test.list.iterator();((Iterator) it).hasNext();){
            System.out.println(it.next());
        }
        System.out.println("*****************");

        Iterator it2 = test.set.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        System.out.println("*****************");

        Set<Integer> s = test.map.keySet();
        for(Iterator it = s.iterator();((Iterator) it).hasNext();){
            Object key = it.next();
            System.out.println(key + test.map.get(key));
        }
    }
}
