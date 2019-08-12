package CommonTest.Test;

import java.util.Scanner;

/**
 * 公司组织团建活动，到某漂流圣地漂流，现有如下情况：
 * 员工各自体重不一，第 i 个人的体重为 people[i]，每艘漂流船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 为节省开支，麻烦帮忙计算出载到每一个人所需的最小船只数(保证每个人都能被船载)。
 *
 * 输入描述:
 * 第一行输入参与漂流的人员对应的体重数组，
 *
 * 第二行输入漂流船承载的最大重量
 *
 * 输出描述:
 * 所需最小船只数
 *
 * 分析：回溯法
 * 解空间看做一颗排列树，求体重数组的一个排列
 * 限界条件：求得count最小值
 */
public class chuanshu {
    int n;
    int p[];
    int count;
    int bestC = 1000;
    int limit;

    void dfs(int t){
        if(t>n){
            if(count<bestC){
                bestC = count;
            }
            return;
        }

        for(int i=t;i<=n;i++){
            int temp = p[i];
            p[i] = p[t];
            p[t] = temp;

            if(p[i]+p[i+1]<=limit){
                count = count+1;
                dfs(t+2);
            }else{
                count = count+1;
                dfs(t+1);
            }

            temp = p[i];
            p[i] = p[t];
            p[t] = temp;
        }
    }

    public static void main(String[] args) {

//        test.n = 2;
//        test.p = new int[5];
//        test.p[1] = 1;
//        test.p[2] = 5;
//        test.limit = 3;
//
//        test.dfs(1);
//        System.out.println(test.bestC);
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String input = in.nextLine();
            //System.out.println(input.length());
            String[] strings = input.split(" ");
            chuanshu test = new chuanshu();
            test.p = new int[strings.length+5];
            for(int i=0;i<strings.length;i++){
                test.p[i+1] = Integer.parseInt(strings[i]);
            }
            test.n = strings.length;
            test.limit = Integer.parseInt(in.nextLine());
            //test.limit = in.nextInt();

            test.dfs(1);
            System.out.println(test.bestC);
        }
    }
}
