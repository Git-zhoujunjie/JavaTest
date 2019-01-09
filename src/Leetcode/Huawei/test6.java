package Leetcode.Huawei;

import java.util.*;
public class test6 {
    public static String getResult(long num){
        long number = num;
        String str = "";
        long n = (long)Math.sqrt(number);
        while(number != 1)
        {
            for(int i = 2; i <= number ;i++)
            {
                if(number % i == 0)
                {
                    number /= i;
                    str += i+" ";
                    break;
                }
            }
        }
        return str;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long a = in.nextLong();
            System.out.println(getResult(a));
        }
    }
}
