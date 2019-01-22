package CommonTest.TestCollection;

import DataStructureAndAlgorithmAnalysis.test;

import java.util.*;

/**
 * 用容器实现存储表格数据
 * 可将表格数据的每一行写入一个JavaBean对象
 * 然后用容器存储每个JavaBean 对象
 */
public class TestJavaBean {
    public static void main(String[] args){
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001,"张三",20000));
        list.add(new Employee(1002,"李四",6000));
        list.add(new Employee(1003,"王五",4000));
        list.add(new Employee(1004,"赵柳",10000));
        list.add(new Employee(1005,"周期",8000));
        list.add(new Employee(1006,"刘八",4000));

        for(Employee e:list){
            System.out.println(e);
        }

        Map<Integer,Employee> map = new TreeMap<>();
        map.put(1001,new Employee(1001,"张三",20000));
        map.put(1002,new Employee(1002,"李四",6000));
        map.put(1003,new Employee(1003,"王五",4000));
        map.put(1004,new Employee(1004,"赵柳",10000));
        map.put(1005,new Employee(1005,"周期",8000));
        map.put(1006,new Employee(1006,"刘八",4000));

        Set<Map.Entry<Integer,Employee>> set = map.entrySet();
        for(Map.Entry e:set){
            System.out.println(e.getKey()+"==="+e.getValue());
        }
    }
}


/**
 * JavaBean对象的特点：
 * 1.属性必须私有化
 * 2.拥有get,set方法
 */
class Employee{
    private int id;
    private String name;
    private double Salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        Salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return Salary;
    }

    @Override
    public String toString() {
        return "id:"+id+",name:"+name+",salary:"+Salary;
    }
}