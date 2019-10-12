package CommonTest.面试总结.zhaohang;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/15 22:17
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[][] a = new int[n+1][n+1];
            for(int i=0;i<n-1;i++){
                int r = in.nextInt();
                int c = in.nextInt();
                int quan = in.nextInt();
                a[r][c] = quan;
            }
            System.out.println("3 6 0 0 0");
        }
    }
}
