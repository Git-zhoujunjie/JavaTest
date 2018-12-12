package LearningAlgorithmInterestingly.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*采用Prim算法
 1、无向图采用邻接矩阵表示，用二维数组m[][]存储
 2、用bool数组s[i]=true 表示节点i属于最小生成树节点集合U
 3、用数组lowcost[]表示集合V-U中的点到U中的点的最短距离，用数组clostest[]表示集合V-U中的点到U中的点的最短距离的节点
    例如：lowcost[3]=23表示节点3属于集合V-U，且节点3到集合U的最短距离为23
         clostest[3]=2表示节点3属于集合V-U，且节点3与集合U中的节点2距离最短
1 2 23
1 6 28
1 7 36
2 3 20
2 7 1
3 4 15
3 7 4
4 5 3
4 7 9
5 6 17
5 7 16
6 7 25
 */

class Node1{
    int flag;
    int value;

    public Node1(int f,int v){
        this.flag = f;
        this.value = v;
    }
}

public class 最小生成树 {
    private static final int MAXN = 100;
    int[][] m = new int[MAXN][MAXN];
    boolean[] s = new boolean[MAXN];
    int[] lowcost = new int[MAXN];
    int[] clostest = new int[MAXN];



    void input(int countv, int countl) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("请输入节点数量：");
//        int countv = Integer.parseInt(buffer.readLine());
//        System.out.println("请输入边的数量：");
//        int countl = Integer.parseInt(buffer.readLine());
        for (int i = 1; i < countv; i++) {  //初始化邻接矩阵
            for (int j = 1; j < countv; j++)
                m[i][j] = MAXN;
        }
        System.out.println("请输入两个节点与相连边的权值，用空格隔开：");
        for (int i = 0; i < countl; i++) {
            String[] strings = buffer.readLine().split(" ");
            int l = Integer.parseInt(strings[0]);
            int r = Integer.parseInt(strings[1]);
            int w = Integer.parseInt(strings[2]);
            m[l][r] = w;
            m[r][l] = w;
        }
    }

    void minTree(int countv, int n) {  //输入起始节点
        for (int i = 1; i <= countv; i++) { //初始化s、closest、lowcost
            s[i] = false;
            clostest[i] = n;
            lowcost[i] = MAXN;
        }
        s[n] = true;
        clostest[n] = 0;
        lowcost[n] = 0;
        int t = n;
        for(int i = 1;i<=countv;i++){
            for(int j = 1;j<=countv ;j++){   //用来更新lowest和closest
                if(!s[j] && lowcost[j] > m[t][j]){ //!s[i]==true表示节点i属于集合V-U
                    lowcost[j] = m[t][j];
                    clostest[j] = t;
                }
            }
            int min = MAXN;
            int flag =0;
            for(int j = 1;j<=countv;j++){  //寻找lowcost书中最小的值
                if(!s[j] && min > lowcost[j]){
                    min = lowcost[j];
                    flag = j;
                }
            }
            s[flag] = true; //将V-U中离U最小值的节点加入U
            t = flag;
        }

//        PriorityQueue<Node1> queue = new PriorityQueue<>(); //用于对lowcost数组排序，每次取队列最小值
//        queue.add(new Node1(n,0)); //现将初始节点加入队列
//        while( countv-- >0 ){
//            Node1 p = queue.poll();
//            s[p.flag] = true;   //每次更新一个节点
//
//            for(int j = 1;j<=countv ;j++){   //用来更新lowest和closest
//                if(!s[j] && lowcost[j] > m[p.flag][j]){ //!s[i]==true表示节点i属于集合V-U
//                    lowcost[j] = m[p.flag][j];
//                    clostest[j] = p.flag;
//                    queue.add(new Node1(j,lowcost[j]));
//                }
//            }
//        }
    }

    public static void main(String[] args) throws IOException{
        最小生成树 test = new 最小生成树();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入节点数量：");
        int countv = Integer.parseInt(buffer.readLine());
        System.out.println("请输入边的数量：");
        int countl = Integer.parseInt(buffer.readLine());

        test.input(countv,countl);
        test.minTree(countv,5);
        int sum = 0;
        for(int i = 1;i<=countv;i++){
            System.out.print(test.lowcost[i] + " ");
            sum += test.lowcost[i];
        }
        System.out.println("\n" + "最小生成树权值为： "+ sum);
        for(int i = 1;i<=countv;i++){
            System.out.print(test.clostest[i] + " ");
        }
    }
}
