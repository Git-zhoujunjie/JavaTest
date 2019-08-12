package LearningAlgorithmInterestingly.chapter4;

/**
 * 问题描述：有n个站点，每个站点到其他站点有不同的租金，求站点1到n的最小租金
 * 动态规划分析：
 * 1、最优子结构：设已知站点(i,k,j)的最小租金为s1，(i,k)的最小租金为s2，(k,j)的最小租金为s3，则有s1=s2+s3，最优子结构成立
 * 2、递归表达式：设m[i][j]表示站点i到站点j的最优解
 *      m[i][j] = 0;        i==j
 *      m[i][j] = w[i][j];  j=i+1
 *      m[i][j] = min{m[i][k]+m[k][j],w[i][j]}  j>i+1
 *
 */
public class 游艇租聘 {
    int n; //表示站点数
    int w[][] = new int[100][100];
    int m[][] = new int[100][100];
    int s[][] = new int[100][100];

    void dp(){
        for(int r=2;r<=n;r++){  //r表示规模
            for(int i=1;i<=n-r+1;i++){
                int j=i+r-1;

                if(j==i+1) m[i][j] = w[i][j];
                else {
                    m[i][j] = w[i][j];
//                    s[i][j] = i;
                    for (int k = i+1; k < j; k++) {
                        int temp = m[i][k] + m[k][j];
                        if(temp<m[i][j]){
                            m[i][j] = temp;
                            s[i][j] = k;
                        }
                    }
                }
            }
        }
    }

    void print(int i,int j){
        if(s[i][j]==0){
            System.out.print("--"+j);
            return;
        }
        print(i,s[i][j]);
        print(s[i][j],j);
    }
    void init(){
        n=6;
        w[1][2] = 2;
        w[1][3] = 6;
        w[1][4] = 9;
        w[1][5] = 15;
        w[1][6] = 20;
        w[2][3] = 3;
        w[2][4] = 5;
        w[2][5] = 11;
        w[2][6] = 18;
        w[3][4] = 3;
        w[3][5] = 6;
        w[3][6] = 12;
        w[4][5] = 5;
        w[4][6] = 8;
        w[5][6] = 6;
    }
    public static void main(String[] args) {
        游艇租聘 test = new 游艇租聘();
        test.init();
        test.dp();
        System.out.println(test.m[1][6]);
        System.out.print(1);
        test.print(1,6);

    }

}
