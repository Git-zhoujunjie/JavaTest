package CommonTest.面试总结.JDK8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Java8内置的四大核心函数式接口
 *
 * Comsumer<T> : 消费型接口
 *      void accept(T t);
 *
 * Supplier<T> : 供给型接口
 *      T get();
 *
 * Function<T, R> : 函数型接口
 *      R apply(T t);
 *
 * Predicate<T> : 断言型接口
 *      boolean test(T t)
 *
 */
public class TestLambda02 {

    public void happy(int mon, Consumer<Integer> com){
        com.accept(mon);
    }
    @Test
    public void test01(){
        happy(1000, (x) -> System.out.println("消费"+x));
    }

    public List getNum(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }
    @Test
    public void test02(){
        List<Integer> list = getNum(10,() -> (int)(Math.random()*100));
        list.stream().forEach(System.out::println);
    }
}
