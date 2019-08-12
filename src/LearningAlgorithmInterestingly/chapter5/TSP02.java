package LearningAlgorithmInterestingly.chapter5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 旅行商问题：回溯法解法，优化
 */
public class TSP02 {
    int n; //节点数量
    int a[] = {0,1,2,3,4,5,0,0,0};  //存储当前的节点
    int x[][];  //邻接矩阵存储无向图，值为0表示没有边
    int currX[],bestX[];  //currX表示当前遍历的路径，bestX表示最优的路径
    int currS=0,bestS=1000;  //currS表示当前的距离，bestS表示最短的距离

    //回溯函数
    void fun(int t){
        if(t>n) {
            //到达叶子节点，如果叶子节点与起始节点有路径，且路径和最短就进行更新输出
            if (x[currX[1]][currX[t - 1]] != 0) {
                currS += x[currX[t - 1]][currX[1]];
                if (currS < bestS) {
                    for (int i = 1; i <= n; i++) {
                        bestX[i] = currX[i];
                    }
                    bestX[n + 1] = bestX[1];
                    // bestS = currS + x[currX[t - 1]][currX[1]];
                    bestS = currS;
                }
                currS -= x[currX[t - 1]][currX[1]];
            }
            return;
        }

        //搜索排列树
        for(int i=t;i<=n;i++){
            currX[t] = a[i];

            if(x[currX[t-1]][currX[t]] != 0 ){  //约束条件，判断要加入的节点和上一个节点之间是否有边

                currS += x[currX[t-1]][currX[t]];  //更新路径长度

                int temp = a[t];
                a[t] = a[i];
                a[i] = temp;

                if(currS<bestS) {  //限界条件，判断最优解
                    fun(t + 1);  //搜索下一个节点
                }

                temp = a[t];
                a[t] = a[i];
                a[i] = temp;

                currS -= x[currX[t-1]][currX[t]];  //回溯
            }
        }
    }

    void init(){
        n=5;

        //a=new int[n+10];
        x = new int[n+10][n+10];
        currX = new int[n+10];
        bestX = new int[n+10];

        x[1][2] = 3;
        x[1][4] = 8;
        x[1][5] = 9;
        x[2][3] = 3;
        x[2][4] = 10;
        x[2][5] = 5;
        x[3][4] = 4;
        x[3][5] = 3;
        x[4][5] = 20;

        x[2][1] = 3;
        x[4][1] = 8;
        x[5][1] = 9;
        x[3][2] = 3;
        x[4][2] = 10;
        x[5][2] = 5;
        x[4][3] = 4;
        x[5][3] = 3;
        x[5][4] = 20;


    }
    public static void main(String[] args) {
        /*
        如果要更换出发节点，可以改变图中的节点序号，将要出发的节点变成1号节点
         */
        System.out.println("请输入出发节点：");
        //Scanner in = new Scanner(System.in);
        //int begin = in.nextInt();

        TSP02 test = new TSP02();
        test.init();

        test.currX[1] = 1;

        test.fun(2);

        System.out.println(test.bestS);
        System.out.println(Arrays.toString(test.bestX));
    }
}
