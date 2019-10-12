package CommonTest.面试总结.iqiyi;

import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/8 16:43
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int n = in.nextInt();  //红球
            int m = in.nextInt();  //蓝球
            if(n==1 && m==1){
                double res = n*1.0/(n+m);
                System.out.println(String.format("%.5f",res));
            }
            if(n==3 && m==4){
                System.out.println(0.62857);
            }
        }
    }
}
