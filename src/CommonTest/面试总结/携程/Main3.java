package CommonTest.面试总结.携程;

import java.util.*;

/**
 * 在m个节点的分布式计算系统中，有一批任务需要执行，
 * 每个任务需要的时间是array[i]，每个节点同一时间只能执行一个任务，
 * 每个节点只能执行连续的任务，例如i,i+1,i+2,但是不能执行i,i+2。
 * 请问任务完成的最短时间
 *
 * 输入：第一行：n,m，n表示任务数，m表示节点数 第二行n个数，
 *
 */
public class Main3 {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static int minres = 10000;

    static int schedule(int m,int[] array) {

        return minres;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
//    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int m = in.nextInt();
//            int n = in.nextInt();
//            List list = new ArrayList<Integer>();
//            for (int i = 0; i < n; i++) {
//                list.add(in.nextInt());
//            }
//            //从大到小排序
//            //Collections.sort(list);
//            //初始化状态值
//            int status[] = new int[m];
//            //统计耗时
//            int time = 0;
//            //统计status 中作业耗时最长的
//            int max = (int) list.get(0);
//            for (int i = n - 1; i >= 0; i--) {
//                int flag = 0; //用于判断作业是否有完成的
//                int min = (int) list.get(n - 1) + 1;
//                for (int j = 0; j < m; j++) {
//                    min = Math.min(min, status[j]); //统计status 中作业耗时最短的
//                    if (status[j] == 0) {
//                        status[j] = (int) list.get(i);
//                        max = Math.max(max, status[j]);
//                        min = Math.min(min, status[j]);
//                        flag = 1;
//                        break;
//                    }
//                }
//                //当作业中status都在运行时，直接跳到最短作业已完成的status的状态
//                if (flag == 0) {
//                    for (int j = 0; j < m; j++) {
//                        status[j] -= min;
//                    }
//                    time += min; //统计耗时
//                    max = max - min; //更新此时status的最大值
//                    i++;
//                }
//            }
//            //最好的耗时等于更换status时累计的跳转值和最后status的最大值之和
//            System.out.println(time + "+" + max + "=" + (time + max));
//        }
//    }
}
