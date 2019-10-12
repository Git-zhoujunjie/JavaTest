package CommonTest.面试总结.快手;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/16 22:04
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++) a[i] = in.nextInt();

            Arrays.sort(a);

            int len = a[a.length-1]-a[0];
            int[][] dp1=new int[a.length][len+1];
            int[][] dp2=new int[a.length][len+1];
            int res=0;
            for(int i=0;i<a.length;i++){
                for(int j=i-1;j>=0;j--){
                    int cha=a[i]-a[j];
                    if(cha<0){
                        cha=Math.abs(cha);
                        dp1[i][cha]=Math.max(dp1[j][cha]+1,dp1[i][cha]);
                        res=Math.max(res,dp1[i][cha]);
                    }
                    else{
                        dp2[i][cha]=Math.max(dp2[j][cha]+1,dp2[i][cha]);
                        res=Math.max(res,dp2[i][cha]);
                    }
                }
            }
            System.out.println(res+1);
        }
    }
}
