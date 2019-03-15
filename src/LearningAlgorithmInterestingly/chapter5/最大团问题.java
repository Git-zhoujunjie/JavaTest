package LearningAlgorithmInterestingly.chapter5;

import java.util.Arrays;

/**
 * 问题：从一个无向图中找出最大团
 * 团：无向图的一个极大完全子图，子图的任意两个节点都有路径
 * 最大团：含有节点最多的团
 *
 * 问题分析：
 * 问题：给出n个点的集合x[n]
 * 1、定义解空间：解的组织形式为n个点集合的子集；显约束：x[i]=1表示加入解集
 * 2、解的组织结构：可看作为一颗解空间树
 * 3、搜索解空间：深度优先遍历，隐约束条件为：解集中任意两个节点都有路径；限界条件：
 */
public class 最大团问题 {
    //private static final int MAX = 1000;

    private int n;  //点的数量
    private int[][] ele = new int[8][8];  //存储无向图
    private int[] v = new int[n+10];  //存储点集 v[i] = 1表示加入解集

    private int[] result =new int[n+10];  //记录最优解的状态
    private int count;
    private int bestC;

    public boolean place(int t){
//        for(int i=1;i<t;i++){
//            if(ele[i][t] == 0) return false;
//        }
//        return true;
        boolean ok = true;
        for(int j=1;j<t;j++){
            if(v[j]!=0&&ele[t][j]==0){
                ok = false;
                break;
            }
        }
        return ok;
    }

    public void BackTrack(int i){
        if(i>n){
            for(int j=1;j<=n;j++){
                result[j] = v[j];
            }
            bestC = count;
            return;
        }
        if(place(i)){
            v[i]=1;
            count++;
            BackTrack(i+1);
            count--;
        }
        if(count+n-i>bestC){
            v[i] = 0;
            BackTrack(i+1);
        }
    }

    public void init(){
        n = 5;
        ele[1][2] = 1;
        ele[1][3] = 1;
        ele[1][4] = 1;
        ele[1][5] = 1;
        ele[2][3] = 1;
        ele[3][4] = 1;
        ele[3][5] = 1;
        ele[4][5] = 1;

        ele[2][1] = 1;
        ele[3][1] = 1;
        ele[4][1] = 1;
        ele[5][1] = 1;
        ele[3][2] = 1;
        ele[4][3] = 1;
        ele[5][3] = 1;
        ele[5][4] = 1;
    }
    public static void main(String[] args) {
        最大团问题 test = new 最大团问题();
        test.init();
        test.BackTrack(1);

        System.out.println(Arrays.toString(test.result));
    }
}
