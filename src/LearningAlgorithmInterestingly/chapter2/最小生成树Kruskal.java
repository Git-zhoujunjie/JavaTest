package LearningAlgorithmInterestingly.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Nodek{   //节点集合
    int belon;   //节点最终属于的编号
    int num;     //节点编号

    public Nodek(int f,int b){
        this.belon = f;
        this.num = b;
    }
}

class Lenk implements Comparable<Lenk>{   //边集合
    boolean flagl;  //指示是否加入生成树集合
    int num;   //权值
    int begin;
    int end;

    public Lenk(boolean f, int n, int b, int e){
        this.flagl = f;
        this.num = n;
        this.begin = b;
        this.end = e;
    }
    public Lenk(){}

    @Override
    public int compareTo(Lenk o) {   //按照权值排序
        if(this.num >= o.num) return 1;
        else return -1;
    }
}
public class 最小生成树Kruskal {
    private static final int NUM =10;
    public ArrayList<Lenk> arrayL = new ArrayList<>();
    public int[] nodearr = new int[NUM];
    //先输入数据，用一个数组存储边，排好序
    void input(int countv, int countl) throws IOException {
        for(int i =1;i<countv;i++){
            nodearr[i] = 0;
        }
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入两个节点与相连边的权值，用空格隔开：");
        for (int i = 0; i < countl; i++) {
            String[] strings = buffer.readLine().split(" ");
            int l = Integer.parseInt(strings[0]);
            int r = Integer.parseInt(strings[1]);
            int w = Integer.parseInt(strings[2]);

            if(l>r) {   //永远保证l<r
                int t =r;
                r=l;
                l=t;
            }

            Lenk lenk = new Lenk();
            lenk.begin = l;
            nodearr[l] = l;
            lenk.end = r;
            nodearr[r] = r;
            lenk.num = w;
            lenk.flagl = false;
            arrayL.add(lenk);
        }
        Collections.sort(arrayL);
    }
    //对数组进行循环，每次选择剩余边集合中的权值最小边，
    //  判断这条边的begin和end是否在点集合中属于同一集合，若是，则跳过；
    //  若不是，则更新边的flag和点集合
    void minTree(int cnum, int lnum) {
        for (int i = 0; i < lnum; i++) {
            Lenk lenk = arrayL.get(i);
            if (!lenk.flagl && nodearr[lenk.begin] != nodearr[lenk.end]) {  //当选取的边未加入集合且边的两个端点不属于同一个集合时
                lenk.flagl = true;
                boolean[] fb = new boolean[cnum+1];
                for (int j = 1; j <= cnum; j++) {
                    if(nodearr[j] == nodearr[lenk.end]){  //用一个数组先标记要更新的节点
                        fb[j] = true;
                        //nodearr[j] = nodearr[lenk.begin];
                    }
                }
                for (int j = 1; j <= cnum; j++) {
                    if(fb[j] == true){
                        nodearr[j] = nodearr[lenk.begin]; //然后将所有标记节点全部变为begin
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{
        最小生成树Kruskal test = new 最小生成树Kruskal();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入节点数量：");
        int countv = Integer.parseInt(buffer.readLine());
        System.out.println("请输入边的数量：");
        int countl = Integer.parseInt(buffer.readLine());

        test.input(countv, countl);
        test.minTree(countv, countl);
        int sum = 0;
        for(Lenk l : test.arrayL){
            if(l.flagl){
                System.out.print(l.num + " ");
                sum += l.num;
            }
        }
        System.out.println("\n 最小生成树权值和：" + sum);

    }
}
