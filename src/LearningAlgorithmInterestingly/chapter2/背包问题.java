package LearningAlgorithmInterestingly.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class theInfo implements Comparable<theInfo> { //宝物的信息
    double w;  //重量
    double v;   //价值
    double p;   //性价比

    public theInfo(double w,double v) {
        this.w = w;
        this.v = v;
        this.p = v / w;
    }

    public int compareTo(theInfo t){  //比较函数,sort方法会调用此函数
        if(p > t.p) return -1;
        else if(p < t.p) return 1;
        else return 0;
    }
}

public class 背包问题 {
    static theInfo createObject(double w, double v) {
        return new theInfo(w, v);
    }

    public static void main(String[] args) throws IOException {
        int ncount; //宝物数量
        double aweight; //背包总载重

 //       Scanner scanner = new Scanner(System.in);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入宝物的数量：");
        ncount = Integer.parseInt(buffer.readLine());
        System.out.print("请输入背包总载重：");
        aweight = Double.parseDouble(buffer.readLine());
 //       scanner.close();

        System.out.println("请输入每个宝物的重量与价值，用空格隔开：");
        List<theInfo> theInfos = new ArrayList<>();
        for (int i = 0; i < ncount; i++) {
//            Scanner scanner1 = new Scanner(System.in);
            String string = buffer.readLine();
            String[] strings = string.split(" ");
            //theInfos[i].w = Integer.parseInt(strings[0]);
            //theInfos[i].v = Integer.parseInt(strings[1]);
            theInfos.add(new theInfo(Double.parseDouble(strings[0]), Double.parseDouble(strings[1])));
//            scanner.close();
        }
        buffer.close();
        Collections.sort(theInfos);//降序排序

        double sum = 0;//总价值
        int count = 0;
        for (int i = 0; i < theInfos.size(); i++) {
            if (aweight > theInfos.get(i).w) {
                sum += theInfos.get(i).v;
                aweight -= theInfos.get(i).w;
            } else {
                sum += theInfos.get(i).p * aweight;
                aweight = 0;
            }
            count++;
        }

        System.out.println("最多的价值量为："+ sum);
        System.out.println("宝物数量为："+ count);

    }

}
