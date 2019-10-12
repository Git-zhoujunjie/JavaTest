package CommonTest.面试总结.JDK8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

public class TestStream02 {

    @Test
    public void test01(){
        //给定一个数组，返回各数字平方的数组
        int[] a = {3,6,2,4,6};
        Arrays.stream(a)
                .map((x) -> x*x)
                .forEach(System.out::println);
    }

    List<Object> list = Arrays.asList(
            new Employee("张三",25),
            new Employee("李四",16),
            new Employee("王五",23),
            new Employee("赵六",25),
            new Employee("a四",16),
            1,
            "2222"
    );
    @Test
    public void test02(){
        //统计流中有多少个Employee
        Optional<Integer> op = list.stream()
                .map((x) -> x.getClass().isInstance(Employee.class)?1:0)
                .reduce(Integer::sum);
        System.out.println(op.get());
    }

    /**
     * 测试并行流和ForkJoin框架
     */
    @Test
    public void test03(){
        //jdk8计算时间
        Instant start = Instant.now();
        //计算一百亿累加和
        LongStream.rangeClosed(0,20000000000L)
                .parallel()
                .reduce(Long::sum);

        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());

    }
}
