package Leetcode.Huawei;
import java.util.*;
public class test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String[] strarr = in.nextLine().split(" ");
            System.out.println(strarr[strarr.length - 1].length());
        }
    }
}

