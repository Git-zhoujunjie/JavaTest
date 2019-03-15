package LearningAlgorithmInterestingly.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

/**
1 5 12
5 1 8
1 2 16
2 1 29
5 2 32
2 4 13
4 2 27
1 3 15
3 1 21
3 4 7
4 3 19
 */
public class 最短路径问题 {
    private static int N =100;//初始值，可更改
    private static int INF = 10000;  //表示无穷大
    int[][] map = new int[N][N]; //有向图的邻接矩阵
    int[] dist = new int[N];  //最短路径矩阵，dist[i]表示<u,i>之间的最短距离的估计值，不断更新
    int[] p = new int[N];   //前驱节点矩阵，p[i]=j 表示i节点的前驱节点为j
    boolean[] flag = new boolean[N]; //flag[i]=true表示节点i属于集合S，反之属于集合V-S

    class Node implements Comparable<Node>{
        int v;
        int l;
        public Node(int v,int l){
            this.v = v;
            this.l = l;
        }

        @Override
        public int compareTo(Node o) {
            if(this.l>o.l) return 1;
            else return -1;
        }
    }
    void Dijkstra(int u,int n){  //u表示初始节点
        //初始化
        for(int i=1;i<=n;i++){
            dist[i] = map[u][i];
            if(dist[i] < INF) p[i] = u;
            else p[i] = -1;
            flag[i] = false;
        }
        flag[u] = true;//集合S中只有u
        dist[u] = 0;

        for(int i = 1;i<=n;i++){
            int temp = INF;
            int t = u;
            for(int j=1;j<=n;j++) {  //这个循环主要用于更新S集合
                if (!flag[j] && dist[j] < temp) {  //flag[i]==false表示i属于V-S
                    temp = dist[j];
                    t = j;
                }
            }
            if(t == u) break;
            flag[t] = true;
            for(int j=1;j<=n;j++){  //这个循环主要用来更新dist数组
                if(!flag[j] && dist[t]+map[t][j]<dist[j]){
                    dist[j] = dist[t] + map[t][j];
                    p[j] = t;
                }
            }
        }

    }
    void Dijkstra2(int u,int n){ //采用优先队列进行dist数组的存储，时间复杂度可降低
        PriorityQueue<Node> queue = new PriorityQueue();
        for(int i = 1;i<=n;i++){
            dist[i] = INF;
            flag[i] = false; //初始化为false，表示都属于V-S集合
        }
        dist[u] = 0;
        queue.add(new Node(u,0));

        while(!queue.isEmpty()){
            Node node = queue.poll();//取出队首元素并删除
            int t = node.v;
            if(flag[t]) continue;
            flag[t]=true;
            for(int i=1;i<=n;i++){
                if(!flag[i] && map[t][i]<INF){
                    if(dist[i] > dist[t] + map[t][i]){
                        dist[i] = dist[t] + map[t][i];
                        queue.add(new Node(i,dist[i])); //优先队列会将存入的元素进行排序，每次讲最小的元素放在队首
                    }
                }
            }
        }
    }

    void print(int n,int m) throws IOException {  //输入有向图，将输入的数据存到map数组中
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // Arrays.fill(map,INF);
        for(int i=1;i<=n;i++){    //先初始化map中的值全为无穷大
            for(int j=1;j<=n;j++)
                map[i][j] = INF;
        }
        System.out.println("请输入边与点的对应关系，用空格隔开：");
        for(int i=1;i<=m;i++){
            String[] strs = bufferedReader.readLine().split(" ");
            int v1 = Integer.parseInt(strs[0]);
            int v2 = Integer.parseInt(strs[1]);
            int l = Integer.parseInt(strs[2]);
            map[v1][v2] = l;
        }
       // bufferedReader.close();
    }
    public static void main(String[] args) throws IOException{
        最短路径问题 test = new 最短路径问题();
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入点的数量：");
        int n = Integer.parseInt(bufferedReader1.readLine());
        System.out.print("请输入边的数量：");
        int m = Integer.parseInt(bufferedReader1.readLine());
        test.print(n,m);

        System.out.print("请输入小明所在的起始位置：");
        int u = Integer.parseInt(bufferedReader1.readLine());
        //test.Dijkstra(u,n);
        test.Dijkstra2(u,n);

        for(int i=1;i<=n;i++){
            System.out.print(test.dist[i] + " ");
        }
        System.out.println();
        for(int i=1;i<=n;i++){
            System.out.print(test.p[i] + " ");
        }
        System.out.println();

        for(int i=1;i<=n;i++){
            System.out.print("小明需要到达的位置为："+ i +"  详细路径为：");
            int e =i;
            Stack s = new Stack();
            s.push(e);
            while(test.p[e]>0){
                s.push(test.p[e]);
                e=test.p[e];
            }
            System.out.print(s.pop());
            while(!s.empty()){
                System.out.print("-->" +s.pop());
            }
            System.out.print("  最短距离为：" +test.dist[i]);
            System.out.println();
        }
    }
}
