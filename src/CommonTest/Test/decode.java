package CommonTest.Test;

import java.util.Scanner;

public class decode {
    int n;
    int p[];
    int count=0;
    int result=0;

    void dfs(int t){
        if(t>n){
            count++;
            return;
        }

        if(p[t]+p[t+1]<=26 && t<n){
            dfs(t+1);
        }
        //dfs(t+1);

//        for(int i=t;i<=n;i++){
////            int temp = p[i];
////            p[i] = p[t];
////            p[t] = temp;
//
//            if(p[i]*10+p[i+1]<=26){
//                dfs(t+2);
//            }else{
//                dfs(t+1);
//            }
//
////            temp = p[i];
////            p[i] = p[t];
////            p[t] = temp;
//        }
    }

    public static void main(String[] args) {
        decode test = new decode();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            char[] cs = in.nextLine().toCharArray();
            test.p = new int[cs.length+5];
            for(int i=0;i<cs.length;i++){
                test.p[i+1] = cs[i]-'0';
            }
            test.n = cs.length;
            test.dfs(1);
            System.out.println(test.count+1);
        }
//        Scanner input=new Scanner(System.in);
//        while(input.hasNext()) {
//            String str = input.nextLine();
//            String[] strs = str.split("");
//            int len = strs.length;
//            int[] dp = new int[len + 1];
//            dp[0] = 1;
//            dp[1] = 1;
//            for (int i = 2; i < len + 1; i++) {
//                if (strs[i - 1].equals("0")) {
//                    dp[i] = dp[i - 2];
//                }
//                int tmp = Integer.parseInt(strs[i - 2] + strs[i - 1]);
//                if (tmp > 26) {
//                    dp[i] = dp[i - 1];
//                } else {
//                    dp[i] = dp[i - 1] + dp[i - 2];
//                }
//            }
//            System.out.println(dp[len]);
//        }
    }
}
