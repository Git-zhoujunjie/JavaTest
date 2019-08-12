package CommonTest.Test;

/**
 * 输入一个只包含1和0的矩阵，求其中的组数。一个组表示最大的连续包含1的路径
 */
public class zu {
    static int count = 0;
    static void dfs(int c,int r,int[][] a){
        if(c<0||r<0||c>=a.length || r>=a[0].length || a[c][r]==0 || a[c][r]==2) return ;
        else if(a[c][r]==1){
            a[c][r]++;
            dfs(c+1,r,a);
            dfs(c,r+1,a);
            dfs(c-1,r,a);
            dfs(c,r-1,a);
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,1,0,1},{1,0,0,1},{1,1,0,0},{0,0,1,0},{1,1,1,1}};
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==1){
                    count++;
                    dfs(i,j,a);
                }
            }
        }
        System.out.println(count);
    }
}
