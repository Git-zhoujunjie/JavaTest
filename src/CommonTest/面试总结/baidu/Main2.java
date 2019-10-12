package CommonTest.面试总结.baidu;

import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/10 20:32
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int k = in.nextInt();
            huafen(n,k);
            System.out.println(res);
        }
    }

    static int res = 0;
    static void huafen(int n,int k){
        if(n-k<=1) {
            res ++;
            return;
        }
        boolean flag = false;
        for(int i=1;i<n;i++){
            if(i+i+k == n) {
                huafen(i,k);
                huafen(n-i,k);
                flag=true;
            }
        }
        if(!flag) res++;
    }
}
