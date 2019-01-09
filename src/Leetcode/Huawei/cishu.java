package Leetcode.Huawei;

import java.util.*;
public class cishu{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int count = in.nextInt();
            int cishu = in.nextInt();
            int[] arr = new int[count+1];
            for(int i=1;i<=count;i++){
                arr[i] = in.nextInt();
            }
            for(int s =0;s<cishu;s++){
                String c = in.next();
                int begin = in.nextInt();
                int end = in.nextInt();
                if(c.equals("Q")){
                    if(begin>end){
                        int t = begin;
                        begin=end;
                        end = t;
                    }
                    int max = arr[begin];
                    for(int i=begin+1;i<=end;i++){
                        if(max<arr[i]) max = arr[i];
                    }
                    System.out.println(max);
                }
                else if(c.equals("U")){
                    arr[begin] = end;
                }
            }
        }
    }
}
