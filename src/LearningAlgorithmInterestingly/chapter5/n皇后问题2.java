package LearningAlgorithmInterestingly.chapter5;

/**
 * 问题描述：
 * 在n*n的棋盘上放置n个皇后，皇后可以攻击同一行、同一列、同一斜线上的棋子
 * 请设计算法在棋盘上放置n个皇后，使之相互不受攻击
 *
 * 解题思路：用排列树进行解
 * 1、问题的解空间：n元组，{x1,x2,...,xn}，xi=j表示第i个皇后放在第i行第x[i]列
 * 2、解的组织结构：m(=n)叉排列树
 * 3、搜索解空间
 * --排列树能保证新一层的节点，必然与之前的节点不在同一行和同一列，这样就缩小了约束条件
 *
 */
@SuppressWarnings("all")
public class n皇后问题2 {
    int n;
    int[] coord ;  //皇后的坐标
    static int count = 0;
    int[] x;

    //只需要判断新节点是否与前面的节点在同一斜线即可
    boolean isAttack(int t,int j){  //t表示横坐标，j表示纵坐标
        boolean ok = false;
        for(int i=1;i<t;i++){
            if(Math.abs(i-t)==Math.abs(j-coord[i])){
                ok = true;
                break;
            }
        }
        return ok;
    }

    void swap(int a,int b){
        int temp = a;
        a=b;
        b=temp;
    }

    void BackTrack(int t){
        if(t>n){
            //输出
            for(int i=1;i<=n;i++){
                System.out.print(coord[i]+" ");
            }
            count++;
            System.out.println();
            return;
        }

        for(int i=t;i<=n;i++){

            coord[t] = x[i];
            //swap(x[t],x[i]);
            int temp = x[t];
            x[t] = x[i];
            x[i] = temp;

            if(!isAttack(t,coord[t])){  //t表示横坐标，x[i]表示纵坐标
                BackTrack(t+1);
            }
            //swap(x[i],x[t]);
            temp = x[t];
            x[t] = x[i];
            x[i] = temp;
        }
    }

    void init(){
        n = 8;
        coord = new int[n+10];
        x = new int[n+10];
        for(int i=1;i<=n;i++){
            x[i] = i;
        }
    }

    public static void main(String[] args) {
        n皇后问题2 test = new n皇后问题2();

        test.init();
        test.BackTrack(1);
        System.out.println("解法个数为："+test.count);
    }

}
