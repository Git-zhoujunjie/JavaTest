package Leetcode.Huawei;

import java.util.*;
public class test4{
    static ArrayList<Character> convert(String s){
        ArrayList<Character> sa = new ArrayList();
        if(s.length()%8 == 0){
            for(int i= 0;i<s.length();i++)
                sa.add(s.charAt(i));
        }
        else{
            int cha = 8-(s.length()%8);
            for(int i =0;i<s.length()+cha;i++){
                if(i<s.length()) sa.add(s.charAt(i));
                else sa.add('0');
            }
        }
        return sa;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            ArrayList<Character> ar1 = convert(s1);
            ArrayList<Character> ar2 = convert(s2);
            for(int i = 1;i<=ar1.size();i++){
                System.out.print(ar1.get(i-1));
                if(i%8==0) System.out.println();
            }
            for(int i = 1;i<=ar2.size();i++){
                System.out.print(ar2.get(i-1));
                if(i%8==0) System.out.println();
            }
        }
    }
}
