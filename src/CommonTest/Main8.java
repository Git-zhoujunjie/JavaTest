package CommonTest;

import java.util.Scanner;

/**
 * 薯队长最近在玩一个迷宫探索类游戏，迷宫是一个N*N的矩阵形状，
 * 其中会有一些障碍物禁止通过。这个迷宫还有一个特殊的设计，
 * 它的左右边界以及上下边界是连通的，比如在(2,n)的位置继续往右走一格可以到(2,1)，
 * 在(1,2)的位置继续往上走一格可以到(n,2)。
 * 请问薯队长从起点位置S，最少走多少格才能到达迷宫的出口位置E。
 */
public class Main8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        char[][] a = new char[num][num];
        for(int i=0;i<num;i++){
            String s = in.nextLine();
            for(int j=0;j<s.length();j++) {
                a[i][j] = s.charAt(i);
                if(a[i][j]=='S') {
                    sx = i;
                    sy = j;
                }
                if(a[i][j]=='E'){ex=i;ey=j;}
            }
        }
        n=m=num;
        walk[sx][sy]=0;
        dfs(sx,sy,0);
        System.out.println(ans);
    }

    static int n,m;
    static int[][] walk = new int[200][200];
    static int sx,sy,ex,ey,ans=0x3f3f3f3f;
    static char[][] s = new char[200][200];


    static int[] row={-1,0,1,0};
    static int[] col={0,1,0,-1};

    static void dfs(int x,int y,int layer){
        if(x==ex&&y==ey){
            if(layer<ans)ans=layer;
            return;
        }
        for(int i=0;i<4;i++){
            int r=x+row[i],c=y+col[i];
            if(r>=0&&c>=0&&s[r][c]!='#'&&walk[r][c]>layer+1) {
                if(r>m) r=0;
                if(c>n) c=0;
                walk[r][c] = layer + 1;
                dfs(r, c, layer + 1);
            }

        }
        return;
    }

}
