package Leetcode.Huawei2016;

import java.util.*;
public class zifujihe{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            char[] carr = str.toCharArray();
            Set<Character> s = new LinkedHashSet();
            for(char c : carr){
                s.add(c);
            }
            Iterator<Character> it = s.iterator();
            while(it.hasNext()){
                System.out.print(it.next());
            }
            System.out.println();
        }
    }
}
