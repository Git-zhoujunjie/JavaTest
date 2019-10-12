package CommonTest.面试总结.JDK8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 方法引用
 *
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 */
public class TestMethodRef {

    @Test
    public void test1(){
        PrintStream pr = System.out;
        Consumer<Integer> con = pr::println;

        con.accept(100);
    }

    @Test
    public void test2(){
        Comparator<Integer> com = (a, b) -> Integer.compare(b,a);

        Comparator<Integer> com2 = Integer::compareTo;
    }

    @Test
    public void test3(){
        BiPredicate<String,String> pre = (s1,s2) -> s1.equals(s2);

        BiPredicate<String,String> pre2 = String::equals;
    }

    //构造器引用
    @Test
    public void test4(){
        //Supplier<Employee> sup = () -> new Employee();
        Supplier<Employee> sup = Employee::new;
        Employee e1 = sup.get();
        e1.setAge(10);
        e1.setName("12345");
        System.out.println(e1);
    }
    @Test
    public void test5(){
        //Supplier<Employee> sup = () -> new Employee();
        BiFunction<String,Integer,Employee> bif = Employee::new;
        Employee e1 = bif.apply("ss",22);
        System.out.println(e1);
    }

    //数组引用
    @Test
    public void test6(){
        //Function<Integer,String[]> fun = (x) -> new String[x];
        Function<Integer,String[]> fun = String[]::new;
        String[] strings = fun.apply(6);
        System.out.println(strings.length);
    }
}
