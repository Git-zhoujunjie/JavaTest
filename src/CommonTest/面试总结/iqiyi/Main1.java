package CommonTest.面试总结.iqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/8 15:49
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int n = in.nextInt();
            int[] flags = new int[n-1];
            for(int i=0;i<n-1;i++){
                flags[i] = in.nextInt();
            }
            int[] p = new int[n];
            for(int i=0;i<n;i++){
                p[i] = i+1;
            }
            pailie(n,flags,p,0);
            long num = res%1000000007;
            System.out.println(num);
        }
    }

    public int numPermsDISequence(String S) {
        int MOD = 1_000_000_007;
        int N = S.length();

        // dp[i][j] : Num ways to place P_i with relative rank j
        int[][] dp = new int[N+1][N+1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (S.charAt(i-1) == 'D') {
                    for (int k = j; k < i; ++k) {
                        dp[i][j] += dp[i-1][k];
                        dp[i][j] %= MOD;
                    }
                } else {
                    for (int k = 0; k < j; ++k) {
                        dp[i][j] += dp[i-1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int x: dp[N]) {
            ans += x;
            ans %= MOD;
        }

        return ans;
    }


    static long res = 0;

    public static void pailie(int n,int[] flags,int[] p,int t){
        if(t>=n){
            //输出
            boolean b = true;
            for(int i=0;i<flags.length;i++){
                if(flags[i]==0) {
                    if(p[i]>=p[i+1]) {
                        b=false;
                        break;
                    }
                }
                if(flags[i]==1){
                    if(p[i]<=p[i+1]) {
                        b=false;
                        break;
                    }
                }
            }
            if(b) res++;
            return;
        }
        for(int i=t;i<n;i++){
            int temp = p[i];
            p[i] = p[t];
            p[t] = temp;

            pailie(n,flags,p,t+1);

            temp = p[i];
            p[i] = p[t];
            p[t] = temp;
        }
    }
}
