package LearningAlgorithmInterestingly.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
 // 5 32 18 7 25 13
class Node implements Comparable<Node>{
    double n;  //代表权值
    Node lc;
    Node rc;
    String s;

    public Node(double n,Node lc,Node rc,String s){
        this.n = n;
        this.lc = lc;
        this.rc = rc;
        this.s = s;
    }
    @Override
    public int compareTo(Node o) {
        if(this.n >= o.n) return 1;
   //     else if(this.n == o.n) return 0;   //两种方式均可构建哈夫曼数，不过编码方式会有所差异
        else return -1;
    }
}

public class HuffmanCode {
    int count;
    PriorityQueue<Node> queue = new PriorityQueue<>(); //可用最优先队列存储输入的节点，每次取最小的两个元素并删除

    Node huff(PriorityQueue<Node> queue){  //进行哈弗曼编码，最终返回一个根节点
        Node root = new Node(0,null,null,""); //初始化根节点

        while(queue.size() > 1) {
            Node node = new Node(0,null,null,""); //每次创建一个新节点

            Node l = queue.poll(); //取出队列中两个最小的元素并删除
            Node r = queue.poll();
            node.n = l.n+r.n;

            node.lc = l;
            node.rc = r;

            root = node; //更新根节点
            queue.add(root);  //将新节点入队

        }
        return root;
    }

    void input() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入节点数量：");
        count = Integer.parseInt(buffer.readLine());

        System.out.println("请输入每个节点的字符和权值，用空格隔开：");
        for(int i=1;i<=count;i++) {
            System.out.println("请输第" + i + "个节点：");
            String[] strings = buffer.readLine().split(" ");
            //int n = Integer.parseInt(strings[i]);
            String s = strings[0];
            int n = Integer.parseInt(strings[1]);
            queue.add(new Node(n, null, null, s));
        }
    }


    void print(Node p, ArrayList arr, ArrayList arrayList) {  //输出所有的哈弗曼编码，可采用前序遍历
        if(p.lc==null && p.rc == null){
            String temp = p.s + " 编码为: ";
            for(int i =0;i<arr.size();i++){
                temp = temp + arr.get(i);
            }
            arrayList.add(temp);
        }
        if(p.lc != null){
            arr.add("0");
            print(p.lc,arr,arrayList);
            arr.remove(arr.size()-1);
        }
        if(p.rc != null){
            arr.add("1");
            print(p.rc,arr,arrayList);
            arr.remove(arr.size()-1);
        }
    }
    public static void main(String[] args) throws IOException{
        HuffmanCode test =new HuffmanCode();
        test.input();
        ArrayList arr = new ArrayList();
        ArrayList arrayList = new ArrayList();
        test.print(test.huff(test.queue),arr,arrayList);

        for(int i = 0;i < arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
}
