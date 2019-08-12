package CommonTest.Test;

import java.util.*;

/*
 * simulation的过程中发现有很多交换是浪费的
 * 1. 可以证明要想最小的交换一定要 idx与number构成环
 * 2. 可以怎么只需要一次交换，就可以把0插入到环中
 */
public class sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            int sum = 0;
            boolean[] marked = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (a[i] == i) {
                    marked[i] = true;
                    continue;
                }

                if (!marked[i]) {
                    int cnt = 0, j = i;
                    while (true) {
                        cnt++;
                        marked[j] = true;
                        j = a[j];

                        if (i == j) break;
                    }

                    if (i == 0) sum += cnt - 1;
                    else sum += cnt + 1;
                }
            }

            System.out.println(sum);
        }
    }
}
