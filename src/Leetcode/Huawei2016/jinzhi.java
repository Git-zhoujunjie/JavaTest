package Leetcode.Huawei2016;

import java.util.*;
public class jinzhi{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            char[] carr = str.substring(2).toCharArray();
            int sum =0;
            for(int i =0;i<carr.length;i++){
                if(carr[i]>='0' && carr[i]<='9') sum += (carr[i]-'0')*Math.pow(16,carr.length-i-1);
                else sum += (carr[i]-'A'+10)*Math.pow(16,carr.length-i-1);
            }
            System.out.println(sum);
            System.out.println(Integer.parseInt(str.substring(2),16));
        }
    }
}
