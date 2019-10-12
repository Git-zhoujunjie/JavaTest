package CommonTest.面试总结.JDK8;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试StreamAPI
 *
 * 1. 创建流
 *
 * 2. 中间操作
 *
 * 3. 终止操作
 */
public class TestStream01 {

    @Test
    public void test01(){
        //1.
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream01 = list.stream();

        //2.
        Employee[] es = new Employee[10];
        Stream<Employee> stream02 = Arrays.stream(es);

        //3.
        Stream<String> stream3 = Stream.of("a","b");

        //4.
        //Function<Integer,Integer> sup = (x) -> x+2 ;
        Stream<Integer> stream4 = Stream.iterate(0,(x)->x+2);
        stream4.limit(6)
                .forEach(System.out::println);
    }

    List<Employee> list = Arrays.asList(
            new Employee("张三",25),
            new Employee("李四",16),
            new Employee("王五",23),
            new Employee("赵六",25),
            new Employee("a四",16)
    );
    @Test
    public void test2(){
        list.stream()
                .filter((e) -> {
                    System.out.println("中间操作");
                    return e.getAge()>16;})
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test3(){
        list.stream()
                .filter((e) -> {
                    System.out.println("中间操作");
                    return e.getAge()>16;})
                .skip(2)
                .forEach(System.out::println);
    }
    @Test
    public void test4(){
        list.stream()
                .filter((e) -> {
                    System.out.println("中间操作");
                    return e.getAge()>15;})
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test5(){
        Function<Employee,String> fun = Employee::getName;
        list.stream()
                .map(fun)
                .forEach(System.out::println);
    }

    /**
     * sorted() Comparable 自然排序
     *          Comparator 定制排序
     */
    @Test
    public void test6(){
        Function<Employee,String> fun = Employee::getName;
        list.stream()
                .sorted((e1,e2) -> e1.getAge()>e2.getAge()?1
                        :(e1.getAge()==e2.getAge()?e1.getName().compareTo(e2.getName())
                            :-1)
                )
                .forEach(System.out::println);
    }

    @Test
    public void test7(){
        System.out.println("\uD83D\uDC7F");
    }

    /**
     * 测试map，reduce 映射和归约
     */
    @Test
    public void test8(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Integer a =list.stream()
                .map((x) -> x+10)
                .reduce(0,Integer::sum);
                //.reduce(0,(x,y) -> x+y);
        System.out.println(a);

        Optional<Integer> ops = list.stream().map(x -> x+9).reduce(Integer::sum);

        System.out.println(ops.get());
    }

    //collector 收集器
    @Test
    public void test9(){
        list.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("------------------------");
        //求年龄平均值
        list.stream()
                .collect(Collectors.averagingDouble(Employee::getAge));
        //分组求
        Map<Integer,List<Employee>> map = list.stream()
                .collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(map);
    }
    //多级分组
    @Test
    public void test10(){
        Map<Integer,Map<String,List<Employee>>> map = list.stream()
                .collect(Collectors.groupingBy(Employee::getAge,
                        Collectors.groupingBy((e) -> {
                            if (((Employee)e).getName().equals("张三")) return "A1";
                            if (((Employee)e).getName().equals("李四")) return "A2";
                            else return "A3";
                        })));
        System.out.println(map);
    }
}
