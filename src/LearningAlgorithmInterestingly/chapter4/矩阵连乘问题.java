package LearningAlgorithmInterestingly.chapter4;

/**
 * 问题描述：有n个矩阵A1A2A3A4...An，在矩阵中间加括号，使得矩阵连乘的乘法次数最少
 * 动态规划算法解析：
 * 1、是否存在最优子结构（即子问题的最优解是否一定是总问题的最优解），可证得存在最优子结构
 * 2、建立递归表达式：设m[i][j]表示Ai...Aj的连乘最优解，则有
 *      m[i][j] = 0, i==j
 *      m[i][j] = min{m[i][k]+m[k+1][j]+p[i-1]p[k]p[j]}, i<=k<j
 *
 */
public class 矩阵连乘问题 {
    int n; //表示矩阵个数
    int p[] ; //表示矩阵，因为相邻的矩阵必能相乘，所以第i个矩阵Am*n的行m存放在p[i]中，列n存放在p[i+1]中
    int m[][] = new int[n+10][n+10]; //m[1][n]即表示我们要求的最优解

    int s[][] = new int[n+10][n+10]; //用来存储分割的位置，m[i][j] = k表示在k处将矩阵分为（i,,k）和（k+1,,j）两部分

    void dp(){
        //初始化
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                m[i][j] = 0;    //表示一个矩阵时不用加括号
            }
        }

        for(int r=2;r<=n;r++){  //r表示规模，最开始从2个矩阵开始求解，然后依次求到最终解即r=n
            for(int i=1;i<=n-r+1;i++){   //i表示矩阵求解的起点，即上述中｛i..k..j｝的取值
                int j = i+r-1;  //j表示矩阵求解的终点，实际上可理解为i表示起点，r表示长度，求得终点j的值

                //先设置最优解
                m[i][j] = 99999;
                s[i][j] = 0;
                for(int k=i;k<j;k++){   //这实际上就是个遍历求解最小值的过程
                    int temp = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if(temp < m[i][j]){
                        m[i][j] = temp;  //更新最小值
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    void print(int i,int j){
        if(i==j){
            System.out.print("A["+i+"]");
            return;
        }
        System.out.print("(");
        print(i,s[i][j]);
        print(s[i][j]+1,j);
        System.out.print(")");
    }

    void init(){
        n = 5;
        int q[] = {3,5,10,8,2,4};
        p = q;

    }
    public static void main(String[] args) {
        矩阵连乘问题 test = new 矩阵连乘问题();
        test.init();
        test.dp();

        System.out.println(test.m[1][test.n]);
        test.print(1,test.n);
    }
}
