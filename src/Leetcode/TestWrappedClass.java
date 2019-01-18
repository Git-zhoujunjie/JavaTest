package Leetcode;

public class TestWrappedClass {
    public static void main(String[] args){
        Integer i = 3;
        Integer i2 = Integer.valueOf(3);

        Integer i3 = 3333;
        Integer i4= Integer.valueOf(3333);

        System.out.println(i == i2);
        System.out.println(i3 == i4);

    }
}
