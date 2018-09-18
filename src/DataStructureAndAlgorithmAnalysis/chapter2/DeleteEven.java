package DataStructureAndAlgorithmAnalysis.chapter2;

import java.util.Iterator;
import java.util.List;

public class DeleteEven {
    //LinkListed时间复杂度为O(n^2)，ArrayList为O(n^2)
    public static void removeEvenVer1(List<Integer> lst) {
        int i = 0;
        while (i < lst.size()) {
            if (lst.get(i) % 2 == 0)
                lst.remove(i);
            else
                i++;
        }
    }
//运行会报错，因为在增强的for循环中无法修改lst
    public static void removeEvenVer2(List<Integer> lst) {
        for (int i : lst) {
            if (i % 2 == 0)
                lst.remove(i);
        }
    }
//使用迭代器，LinkListed时间复杂度为O(n)，ArrayList为O(n^2)
    public static void removeEvenVer3(List<Integer> lst) {
        Iterator<Integer> itr = lst.iterator();

        while (itr.hasNext()) {
            if (itr.next() % 2 == 0)
                itr.remove();
        }
    }
}
