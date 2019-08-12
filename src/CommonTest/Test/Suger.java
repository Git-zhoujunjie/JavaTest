package CommonTest.Test;

import java.util.Scanner;

/**
 * 假设你是一位很有爱的幼儿园老师，想要给幼儿园的小朋友们一些小糖果。
 * 但是，每个孩子最多只能给一块糖果。对每个孩子 i ，
 * 都有一个胃口值 gi ，这是能让孩子们满足胃口的糖果的最小尺寸；
 * 并且每块糖果 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个糖果 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块糖果。
 *
 * 输入描述:
 * 第一行输入每个孩子的胃口值
 *
 * 第二行输入每个糖果的尺寸
 *
 * 孩子数和糖果数不超过1000
 *
 * 输出描述:
 * 能满足孩子数量的最大值
 */
public class Suger {
    static int n;
    static int g[];  //胃口
    static int s[];  //糖果大小
    static boolean ss[],gg[]; //表示糖果的状态
    static int count,bestC;

    /**
     * 问题分析：相当于求解糖果数量的一个排列，可用回溯法
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s1 = in.nextLine();
            String s2 = in.nextLine();

            String[] sp1 = s1.split(" ");
            g = new int[sp1.length+1];
            for(int i=0;i<sp1.length;i++){
                g[i+1]=Integer.parseInt(sp1[i]);
            }

            String[] sp2 = s2.split(" ");
            s = new int[sp2.length+1];
            for(int i=0;i<sp2.length;i++){
                s[i+1]=Integer.parseInt(sp2[i]);
            }

            ss = new boolean[s.length];
            gg = new boolean[g.length];

            dfs2(1);
            System.out.println(bestC);
        }
    }

    static void dfs(int t){  //第t个孩子
        if(t>g.length-1 || count==ss.length-1){
            if(count >bestC){
                bestC = count;
            }
            return;
        }
        for(int i=1;i<=s.length-1 ;i++){
            if(ss[i]==false && s[i]>=g[t]){  //约束条件
                ss[i] = true;
                count++;
                dfs(t+1);
                count--;
                ss[i] = false;
            }
        }
    }

    static void dfs2(int t){  //第t个糖果
        if(t>s.length-1){
            if(count>bestC) bestC=count;
            return;
        }

        for(int i=1;i<=g.length-1;i++){
            if(ss[t]==false && g[i]<=s[t] && gg[i]==false){
                ss[t] = true;
                gg[i] = true;
                count++;
                dfs2(t+1);
                count--;
                ss[t] = false;
                gg[i] = false;
            }else dfs2(t+1);
        }
    }
}
