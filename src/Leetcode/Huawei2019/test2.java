package Leetcode.Huawei2019;

import java.util.*;
public class test2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            String[] sarr = str.split(";");
            int n = in.nextInt();
            System.out.println(sarr[n]);
        }
    }
}
