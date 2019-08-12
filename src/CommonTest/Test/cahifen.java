package CommonTest.Test;

import java.util.Scanner;


public class cahifen {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            int n = in.nextInt();
//            if(n>=6){
//                n = n-6;
//            }
//
//            for(int i=0;i<=n;i++){
//                divN(i,1);
//            }
//            int result = (times+1)%666666666;
//            System.out.println(result);
//        }
        Math.random();
        System.out.println(0.1==0.1);
    }

    static int res[] = new int[100000];
    static int times = 0;
    static void divN(int n, int k) {
        int rest; //存放拆分后剩余的整数
        for (int num = 1;num <= n; num++) {  //从1开始尝试拆分
            if (num >= res[k - 1] ) { //拆分的解要大于或等于前一个解保证不重复
                res[k] = num; //将这次拆分存放在res数组中
                rest = n - num; //剩下的是n-num
                if (rest == 0) { //如果没有剩下的，说明本次拆分结束
                    times++;  //拆分次数加1
                }
                else divN(rest, k + 1);  //如果有剩下的，继续求出res[k+1]
            }
        }

    }

}

