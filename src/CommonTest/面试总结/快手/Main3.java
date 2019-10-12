package CommonTest.面试总结.快手;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/16 21:48
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = in.nextInt();
            }
            //动态规划
            int sum = Arrays.stream(a).sum();
            int len = a.length;
            int halfS = sum/2;
            int[][] dp = new int[len+1][halfS+1];
            for(int i=0;i<dp[0].length;i++) dp[0][i]=0;
            for(int i=0;i<dp.length;i++) dp[i][0] = 0;

            for(int i=1;i<len+1;i++){
                for(int j=1;j<halfS+1;j++){
                    dp[i][j] = dp[i-1][j];
                    if(j-a[i-1]>=0&&dp[i-1][j-a[i-1]]+a[i-1]>dp[i][j]){
                        dp[i][j] = dp[i-1][j-a[i-1]]+a[i-1];
                    }
                }
            }
            System.out.println(sum-2*dp[len][halfS]);
        }
    }
}
