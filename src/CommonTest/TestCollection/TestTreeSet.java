package CommonTest.TestCollection;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试TreeSet
 * TreeSet本质是一个TreeMap
 * @param <T>
 */
public class TestTreeSet<T> {
    private static final Object PRESENT = new Object();

    Map<T,Object> map ;

    TestTreeSet(){
        map = new TreeMap<>();
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

    public static void main(String[] args){
//        TestTreeSet<String> test = new TestTreeSet<>();
//        test.add("211");
//        test.add("141");
//        test.add("133");
//        test.add("167");
//        System.out.println(test);
        TestTreeSet<Emp> test = new TestTreeSet<>();
        test.add(new Emp(1001,"张三",20000));
        test.add(new Emp(1002,"李四",6000));
        test.add(new Emp(1003,"王五",4000));
        test.add(new Emp(1004,"赵柳",10000));
        test.add(new Emp(1005,"周期",8000));
        test.add(new Emp(1006,"刘八",4000));

        for(Emp emp:test.map.keySet()) {
            System.out.println(emp);
        }
    }

    static class Emp implements Comparable<Emp>{
        int id;
        String name;
        double salary;

        public Emp(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "id:"+id+",name:"+name+",salary:"+salary;
        }

        @Override
        public int compareTo(Emp o) {
            if(this.salary > o.salary){
                return 1;
            }else if(this.salary < o.salary){
                return -1;
            }else{
                if(this.id > o.id) return 1;
                else if(this.id > o.id) return -1;
                else return 0;
            }
        }
    }
}
