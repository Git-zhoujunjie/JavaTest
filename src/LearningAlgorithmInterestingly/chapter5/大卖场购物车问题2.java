package LearningAlgorithmInterestingly.chapter5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 0-1背包问题
 * 购物车容量为W，有n件商品（x1,x2,x3...xi...xn），每件商品重量为wi，价值为vi
 * 一件商品要么装入购物车，要么不装入
 * 如何选择商品才能使购物车中商品价值最大？
 *
 * 解题方法分析：
 * 采用回溯法，即深度优先遍历
 * 1、定义解空间：题目的题为商品集合的一个子集；显约束条件为：x[i]=0或1
 * 2、确定解的组织形式：可看作为一颗解空间树
 * 3、搜索解空间：深度优先遍历，隐约束条件为：解集中w的和小于W，限界条件为v最大
 *
 */
public class 大卖场购物车问题2 {
    private int n;
    private double WEIGHT;
    private int[] x = new int[n+10];  //每件商品的状态，x[i]=1，表示第i件商品放入购物车
    private int[] w = new int[n+10];  //每件商品的重量
    private int[] v = new int[n+10];  //每件商品的价值
    private int[] result = new int[n+10];  //记录最优解的状态

    private int weight=0;  //当前购物车中的总重量，初始为0
    private double value = 0; //当前购物车中的总价值，初始为0；
    private double bestV = 0;  //最优解

    /**
     * 限界条件：
     * 即已经找到一组最优解，然后进行回溯，判断是否存在更优的解
     * @param i  表示解空间树的第i层
     * @return
     */
    public double bound(int i){
        double tv = value;
        for(int j = i+1;j<=n;j++){
            tv+=v[j];
        }
        return tv;
    }

    /**
     * 遍历过程
     * @param i  表示解空间树的第i层
     */
    public void Backtrack(int i){
        if(i>n){  //已经遍历到最后一层，找出最优解
            for(int j=1;j<=n;j++){
                result[j] = x[j];
            }
            bestV = value;
            return;
        }
        if(weight+w[i]<=WEIGHT){ //第i层还未找到最优解
            x[i] = 1;
            weight += w[i];
            value += v[i];
            Backtrack(i+1);

            weight -= w[i];  //回溯时原路返回
            value -= v[i];
        }
        if(bound(i)>bestV){
            x[i] = 0;
            Backtrack(i+1);
        }
    }

    /**
     * 输入和初始化
     */
    public void inputAndInit(int n,double WEIGHT,int[] w,int[] v){
        this.n = n;
        this.WEIGHT = WEIGHT;
//        this.w = w;
//        this.v = v;
        for(int i=0;i<n;i++){
            this.w[i+1] = w[i];
            this.v[i+1] = v[i];
        }
    }

    public static void main(String[] args) {
        大卖场购物车问题2 test = new 大卖场购物车问题2();
        Scanner in = new Scanner(System.in);

        //while(in.hasNext()){
        System.out.print("请输入物品数量：");
        int n = in.nextInt();
        System.out.print("请输入购物车重量限制：");
        double WEIGHT = in.nextDouble();

        int[] w = new int[n];
        System.out.println("请输入每件商品的重量，以空格隔开：");
        for(int i=0;i<n;i++){
            String wStr = in.next();
            w[i] = Integer.parseInt(wStr);
        }

        int[] v = new int[n];
        System.out.println("请输入每件商品的价值，以空格隔开：");
        for(int i=0;i<n;i++){
            String vStr = in.next();
            v[i] = Integer.parseInt(vStr);
            //vStr.replace("","");
        }

        test.inputAndInit(n, WEIGHT, w, v);
        test.Backtrack(1);  //从第一层开始

        //打印结果result
        System.out.println(Arrays.toString(test.result));

        System.out.println("最大价值为：" + test.bestV);
        // }
    }
}
