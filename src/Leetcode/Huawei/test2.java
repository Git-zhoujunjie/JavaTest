package Leetcode.Huawei;

import java.util.*;
public class test2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int count = 0;
        while(in.hasNext()){
            //String s = "ADf".toLowerCase();
            char[] str = in.next().toLowerCase().toCharArray();
            String sc = in.next().toLowerCase();
            char cc = sc.charAt(0);

            for(char s : str){
//                char cs = s;
//                if(cs>='A' && cs<='Z'){
//                    if(cs==cc || (cs+32) == cc) count++;
//                }
//                if(cs>='a' && cs<='z'){
//                    if(cs == cc || (cs-32) == cc) count++;
//                }
                if(cc == s) count++;
            }

            System.out.println(count);
        }

    }
}