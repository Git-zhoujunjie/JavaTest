package CommonTest.面试总结;

import java.util.Scanner;

/**
 * 假设以一个n*m的矩阵作为棋盘，每个棋位对应一个二维坐标 (x, y)。
 * 你有一颗棋子位于左上起点(0, 0)，现在需要将其移动到右下底角 (n-1, m-1)，
 * 棋子可以向相邻的上下左右位置移动，每个坐标最多只能经过一次。
 * 棋盘中散布着若干障碍，障碍物不能跨越，只能绕行，
 * 问是否存在到达右下底角的路线？若存在路线，输出所需的最少移动次数；
 * 若不存在，输出0。
 * Input 第一行三个正整数n，m和k，代表棋盘大小与障碍物个数  1< n、m < 100,  k < n*m 第二行至第k+1行，
 * 每行为两个整数x和y，代表k个障碍物的坐标。
 */
public class Main7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] grid = new int[m][n];
        for(int i=0;i<k;i++){
            int c = in.nextInt();
            int r = in.nextInt();
            grid[c][r] = 1;
        }

        System.out.println(minpath(grid));
    }

    char ch;
    char[][] s = new char[60][60];
    int[][] walk = new int[60][60];
    int ans=0x3f3f3f3f;
    int m,n;
    int[] row={-1,0,1,0};
    int[] col={0,1,0,-1};

    void dfs(int x,int y,int tot){
        if(x==m-1&&y==n-1){
            if(tot<ans)ans=tot;
            return;
        }
        if(tot<walk[x][y])walk[x][y]=tot;
        else return;
        for(int i=0;i<4;i++){
            int r=x+row[i],c=y+col[i];
            if(r>=0&&r<m&&c>=0&&c<n&&s[r][c]!='#')dfs(r,c,tot+1);
        }
    }



    public static int minpath(int[][] obstacleGrid) {
        int m = obstacleGrid.length; //取得行数
        if(m == 0 || obstacleGrid[0][0] == 1)    //行数为0,或者起点有障碍,直接返回为0
            return 0;
        int n = obstacleGrid[0].length;     //取得列数
        int[][] steps = new int[m][n];      //定义同等大小的二维数组
        steps[0][0] = 0;                    //此时起点已经排除有障碍的情况,所以直接赋值为1
        for(int i=1; i<n; i++){             //对于第一列的元素如果有障碍则为1,否则无障碍就和其上方元素一样
            if(obstacleGrid[0][i] == 1)  //表示有障碍
                steps[0][i] = 0;
            else {
                steps[0][i] = steps[0][i - 1] + 1;
            }
        }
        for(int i=1; i<m; i++){             //对于第一行的元素如果有障碍则为1,否则无障碍就和其左方元素一样
            if(obstacleGrid[i][0] == 1)
                steps[i][0] = 0;
            else
                steps[i][0] = steps[i-1][0] + 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j] == 1)     //此处有障碍,则赋值为0,表示到此位置的走法数目为0
                    steps[i][j] = 0;
                else {
                    steps[i][j] = steps[i - 1][j] + steps[i][j - 1]; //此处无障碍,则是其左方和上方的走法数目的和
                    steps[i][j] = Math.min(steps[i - 1][j]+1,steps[i][j - 1]+1);
                }

            }
        }
        return steps[m-1][n-1];      //最后返回
    }

}
