package LearningAlgorithmInterestingly.chapter5;

import java.util.Arrays;

/**
 * 问题描述：
 * 一张有n个区域的为着色地图，现有m种颜色给地图着色，
 * 要求每相邻的两块区域颜色不同，给出一张着色方案
 *
 * 解题思路：
 * 每个区域可看做一个点，相邻的区域用线连接，因此地图转换为一个无向图
 * 1、定义解空间：m着色问题解为一个n元向量{x1,x2...xn}，其中xi=1,2,..,m,(i=1,2..n)
 * 2、解的组织结构：满m叉树
 * 3、搜索解空间
 * --1）约束条件：将要添加的节点要保证与已经加入的且相连节点颜色不能相同
 * --2）限界条件：只需求出一组可行解即可，无需找出最优解，因此不需要限界条件
 * --3）搜索过程：深度优先遍历
 */
public class 地图着色问题 {
    int n; //节点数
    int m; //颜色数

    static int count = 1;

    int[] v ;  //表示节点，默认为0，v[0]=3表示1号节点颜色为3，这里要+1
    int[][] ele ; //表示边集，有连线的两个节点值为1
    //int[] color = new int[m]; //颜色，初始化时用[1,2,3...m];

    int[] result ;//结果集，直接存储每个节点的颜色，result[5]=4，表示5号节点颜色为4

    //判断新加入的节点当前的颜色是否冲突
    boolean check(int t,int mcolor){  //表示第t号节点，和当前节点的颜色
        boolean ok = true;
        for(int i=1;i<t;i++){
            if(ele[t][i]==1 && v[i]==mcolor){ //如果有相连且颜色相同，则要换颜色
                ok = false;
                break;
            }
        }
        return ok;
    }

    void BackTrack(int t) {
        if (t > n) {  //找到结果，输出result
//            for(int i=1;i<=n;i++){
//                //result[i] = v[i];
//
//            }
            //输出结果
            System.out.print("第" + count + "种方案为：");
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 1; i <= n; i++) {
                sb.append(v[i] + ",");
            }
            sb.setCharAt(sb.length() - 1, ']');
            System.out.println(sb.toString());
            count++;
            return;
        }
        //确定t号节点的颜色
        for (int c = 1; c <= m; c++) {
            if (check(t, c)) {
                v[t] = c;
                BackTrack(t + 1);
            }
        }
    }

    void init(){
        n=7;
        m=3;
        ele = new int[10][10];
        ele[1][2] = ele[2][1] = 1;
        ele[1][3] = ele[3][1] = 1;
        ele[1][4] = ele[4][1] = 1;
        ele[2][3] = ele[3][2] = 1;
        ele[2][5] = ele[5][2] = 1;
        ele[3][4] = ele[4][3] = 1;
        ele[3][5] = ele[5][3] = 1;
        ele[4][5] = ele[5][4] = 1;
        ele[4][7] = ele[7][4] = 1;
        ele[5][6] = ele[6][5] = 1;
        ele[5][7] = ele[7][5] = 1;
        ele[6][7] = ele[7][6] = 1;

        result = new int[n+5];
        v = new int[n+5];
    }

    public static void main(String[] args) {
        地图着色问题 test = new 地图着色问题();

        test.init();
        test.BackTrack(1);

        //System.out.println(Arrays.toString(test.result));
    }
}
