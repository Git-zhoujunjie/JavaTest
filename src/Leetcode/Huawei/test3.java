package Leetcode.Huawei;

import java.util.*;
public class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int count = in.nextInt();
            Set<Integer> set = new TreeSet<Integer>();
            for (int i = 0; i < count; i++) {
                set.add(in.nextInt());
            }
            //Collections.sort(set);
            for (Integer it : set) System.out.println(it);
        }
    }
}
