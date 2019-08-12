package LearningAlgorithmInterestingly.chapter5;

import java.util.Arrays;

/**
 * 问题：输入n，输出n个数的一个排列，这个排列组成素数环（即相邻两项和为素数）
 *
 * 1、解空间：n个数的一个排列
 * 2、解的组织结构：排列树
 * 3、搜索解空间：约束条件：判断当前节点与前一个节点和是否为素数
 */
public class 素数环问题 {
    int n = 8;
    int a[] = {0,1,2,3,4,5,6,7,8,0};

    //判断素数
    boolean isPrime(int a,int b){
        int sum = a+b;
        int k = (int)(Math.sqrt(sum)+0.5);
        for(int i=2;i<=k;i++){
            if(sum%i == 0) return false;
        }
        return true;
    }

    void dfs(int t){
        if(t>n){
            if(isPrime(a[n],a[1])){
                System.out.println(Arrays.toString(a));
            }
            return;
        }

        for(int i=t;i<=n;i++){
            //a[i] = t;
            int temp = a[i];
            a[i] = a[t];
            a[t] = temp;

            if(isPrime(a[i],a[i-1]) && isPrime(a[t],a[t-1])){
                dfs(t+1);
            }

            temp = a[i];
            a[i] = a[t];
            a[t] = temp;
        }
    }

    public static void main(String[] args) {
        素数环问题 test = new 素数环问题();

        test.dfs(2);
    }
}
