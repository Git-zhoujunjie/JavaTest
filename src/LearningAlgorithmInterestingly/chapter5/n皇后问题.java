package LearningAlgorithmInterestingly.chapter5;

/**
 * 问题描述：
 * 在n*n的棋盘上放置n个皇后，皇后可以攻击同一行、同一列、同一斜线上的棋子
 * 请设计算法在棋盘上放置n个皇后，使之相互不受攻击
 *
 * 解题思路：
 * 1、问题的解空间：n元组，{x1,x2,...,xn}，xi=j表示第i个皇后放在第i行第x[i]列
 * 2、解的组织结构：m(=n)叉树
 * 3、搜索解空间
 * --1.约束条件：新节点t不能与之前的节点在(同一行)，同一列（x[t]!=x[1~t-1]），同一斜线（|i-t|!=|xi-xt|）;
 * --2.限界条件：无
 * --3.搜索过程：深度优先
 *
 */
public class n皇后问题 {
    int n;
    int[] coord ;  //皇后的坐标
    static int count = 0;

    //约束条件j
    boolean isAttack(int t,int j){  //t表示横坐标，j表示纵坐标
        boolean ok = false;
        for(int i=1;i<t;i++){
            if(j == coord[i] || Math.abs(i-t)==Math.abs(j-coord[i])){
                ok = true;
                break;
            }
        }

        return ok;
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

        for(int i=1;i<=n;i++){  //遍历列，寻找放置当前皇后的位置
            if(!isAttack(t,i)){  //t表示横坐标，i表示纵坐标
                coord[t] = i;
                BackTrack(t+1);
            }
        }
    }

    void init(){
        n = 8;
        coord = new int[n+10];
        //for(int i=1;i<)
    }

    public static void main(String[] args) {
        n皇后问题 test = new n皇后问题();

        test.init();
        test.BackTrack(1);
        System.out.println("解法个数为："+test.count);
    }

}
