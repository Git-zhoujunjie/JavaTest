package CommonTest.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zhengs {
    public static void main(String[] args) {
        List<List<Integer>> a = new ArrayList();
        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        a.add(c);

        List aa = new ArrayList();
        aa.add(1);
        aa.add(2);

        System.out.println(a.get(0).containsAll(aa));
    }
}
