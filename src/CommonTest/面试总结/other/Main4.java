package CommonTest.面试总结.other;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()) {
//            int num = in.nextInt();
//            int[] h = new int[num];
//            for(int i=0;i<num;i++){
//                h[i] = in.nextInt();
//            }
//            int res = 0;
//            if(num==1) res = 1;
//            else res = fun(h);
//            System.out.println(res);
//        }

        List list = Arrays.asList(1,2,3,4);
        list.stream().forEach(System.out::println);
    }


    public static int fun(int[] h){
        int[] dp = new int[h.length];  //表示每个当前学生属于哪一组
        int[] a = new int[h.length+1];  //表示每个组中最大学生的身高
        dp[0]=1;
        a[dp[0]] = h[0];
        for(int i=1;i<h.length;i++){
            //当前学生身高小于前面一个学生时
            if(h[i]<a[dp[i-1]]){
                //遍历已经分好组的每组最大学生身高
                for(int j=dp[0];j<=dp[i-1];j++){
                    if(h[i]>=a[j]) continue;
                    //当当前学生升高小于前面某组最高身高时，归到该组中去
                    dp[i] = j;
                    a[dp[i]] = a[dp[i-1]];
                    break;
                }
                //dp[i] = dp[i-1];
            }else{
                //当前学生身高大于前面一个学生时，可新增分组
                dp[i] = dp[i-1]+1;
                a[dp[i]] = h[i];
            }
        }
        return dp[h.length-1];
    }
}
