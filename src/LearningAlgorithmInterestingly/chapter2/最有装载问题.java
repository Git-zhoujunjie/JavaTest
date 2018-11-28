package LearningAlgorithmInterestingly.chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class 最有装载问题 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in); //键盘输入

        System.out.print("请输入船载总重量：");
        int w = scan.nextInt();
        System.out.print("请输入古董个数：");
        int c = scan.nextInt();

        Scanner scan2 = new Scanner(System.in);
        int[] wc = new int[c];
        System.out.println("请输入各个古董的重量，用空格隔开：");
        String str = scan2.nextLine();
        String[] s = str.split(" ");
        for(int i=0;i<c;i++){
            wc[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(wc);
        int ans=0;
        int count=0;
        int i=0;
        while(ans<=w){
            ans += wc[i++];
            count++;
        }

        int count2 = c;
        int ans2=0;
        for(int k=0;k<c;k++){
            ans2 += wc[k];
            if(ans2 >= w) {
                if (ans2 == w) count2 = k + 1;
                else count2 = k;
                break;
            }
        }
        System.out.println(String.format("可装载最多的古董数量为：%d",count-1));
        System.out.println(String.format("可装载最多的古董数量为：%d",count2));
    }
}
