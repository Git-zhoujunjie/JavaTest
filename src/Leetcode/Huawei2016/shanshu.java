package Leetcode.Huawei2016;

import java.util.*;
public class shanshu{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            int[] a = new int[num];
            int count = 0;
            int flag = 0;
            int begin = 0;
            while(count<num){
                if(begin>=num) begin=0;
                if(flag == 2 && a[begin]==0){
                    a[begin] = 1;
                    flag = 0;
                    count++;
                    if(count == num) break;
                }
                if(a[begin]==0 && flag!=2){
                    flag++;
                    begin++;
                }
                else begin++;

            }
            System.out.println(begin);
        }
    }
}