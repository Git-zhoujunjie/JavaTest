package LearningAlgorithmInterestingly.chapter5;

import java.util.*;

/**
 * 问题描述：
 * 有n个机器零件{J1,J2...Jn}，每个零件必须先由机器1处理，再由机器2处理，
 * 零件Ji需要机器1和机器2的处理时间为ti1,ti2，如何安排加工顺序，可使所加工的时间最短？
 *
 * 算法设计：
 * 1、定义问题解空间：
 * 2、解空间：排列树，树深度为n
 * 3、搜索解空间
 *  --1.约束条件：无
 *  --2.限界条件：加工时间最短
 *
 */
//class Component{  //定义零件类
//    int x;  //零件编号
//    int t1;  //零件在机器1的加工时间
//    int t2;  //零件在机器2的加工时间
//
//    public Component(int x, int t1, int t2) {
//        this.x = x;
//        this.t1 = t1;
//        this.t2 = t2;
//    }
//}

public class 最优加工顺序问题 {
    int n = 6; //零件数
    int[] x = {0,1,2,3,4,5,6,0};
    int[] a = {0,5,1,8,5,3,4,0}; //a[i]=j表示第i个零件的在第一台机器上的加工时间为j
    int[] b = {0,7,2,2,9,7,4,0}; //b[i]=j表示第i个零件的在第二台机器上的加工时间为j
    //int currTime=0;
    int bestTime=100;
    int[] currX = new int[n+10];  //当前顺序
    int[] bestX = new int[n+10];  //最佳顺序

    int f1,f2;

    void fun(int t){
        if(t>n){  //输出
            for(int i=1;i<=n;i++){
                bestX[i] = x[i];
            }
            bestTime = f2;
        }

        for(int i=t;i<=n;i++){
//            if(a[x[i]]+a[x[i-1]] < currTime){
//                currTime += b[x[i]];
//            }else currTime += a[x[i]]+b[x[i]]-b[x[i-1]];
            f1 += a[x[i]];
            int cc = f2;
            f2 = Math.max(f1,f2)+b[x[i]];

            if(f2 < bestTime){  //限界条件
                int temp=x[t];
                x[t] = x[i];
                x[i] = temp;

                fun(t+1);

                temp=x[t];
                x[t] = x[i];
                x[i] = temp;
            }

            f1 -= a[x[i]];
            f2 = cc;

//            if(a[x[i]]+a[x[i-1]] < currTime){
//                currTime -= b[x[i]];
//            }else currTime -= a[x[i]]+b[x[i]]-b[x[i-1]];
        }
    }

    public static void main(String[] args) {
        最优加工顺序问题 test = new 最优加工顺序问题();

        test.fun(1);
        System.out.println(Arrays.toString(test.bestX));
        System.out.println(test.bestTime);
    }
}
