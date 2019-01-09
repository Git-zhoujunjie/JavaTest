package Leetcode.Huawei2019;

import java.util.*;
public class test1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            String[] str = s.split("");
            int len = str.length;
            if(len<=3){
                System.out.println(s);
            }
            else{
                int max = Integer.parseInt(str[0]);
                int ind = 0;
                for(int i=1;i<=len-3;i++){
                    int t = Integer.parseInt(str[i]);
                    if(max<t) {
                        max=t;
                        ind = i;
                    }
                }
                System.out.println(s.substring(ind,ind+3));
            }
        }
    }
}
