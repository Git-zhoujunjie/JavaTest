package CommonTest.面试总结.JDK8;

import org.junit.Test;

import java.util.*;

public class TestLambda01 {

    @Test
    public void test01(){
        Set<Integer> set = new TreeSet<>((a,b) -> Integer.compare(b,a));
        set.addAll(Arrays.asList(1,7,3,6,2));

        set.stream().forEach(System.out::print);
    }

    @Test
    public void test02(){
        FunctionInterface<Integer> fc = (a,b) -> Integer.compare(a,b);
        System.out.println(fc.Steratage(4,3));
    }

    /**
     * 输入一个数，对其进行任何运算操作
     */
    @Test
    public void test03(){
        double v1 = operateVal(200, (x) -> x*x);
        System.out.println(v1);

        System.out.println(operateVal(1000,(y) -> Math.sqrt(y)));
    }

    double operateVal(int val,MyFun<Integer> fun){
        return fun.getValue(val);
    }

    /**
     * 比较两个Employee对象，使用Collections.sort()，
     * 先比较年龄，年龄相同比较姓名，使用Lambda表达式
     */
    @Test
    public void testSortEmp(){
        List<Employee> list = Arrays.asList(
                new Employee("张三",25),
                new Employee("李四",16),
                new Employee("王五",23),
                new Employee("赵六",25),
                new Employee("田七",16)
        );
        Collections.sort(list,(a,b) -> {
            if(a.getAge()>b.getAge()) return 1;
            else if(a.getAge()<b.getAge()) return -1;
            else return a.getName().compareTo(b.getName());
        });

        list.stream().forEach(System.out::println);
    }

    public double ope02(long t1,long t2,MyFun02<Long,Double> fun){
        return fun.getValue(t1,t2);
    }

    @Test
    public void test04(){
        System.out.println(ope02(100,200, (a,b) -> (double)(a+b)));

        System.out.println(ope02(100,200, (a,b) -> (double)(a*b)));

    }
}
