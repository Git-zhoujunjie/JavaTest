package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhoujunjie
 * @create 2019/9/15 23:14
 */
public class test200 {
    //广度优先
    private void bfs(int[][] mark,char[][] grid,int i,int j){
        //初始化一个方向数组
        int[] posX = {-1,1,0,0};
        int[] posY = {0,0,-1,1};
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i,j));

        while(!q.isEmpty()){
            Node node = q.poll();
            int l = node.left;
            int r = node.right;
            mark[l][r]=1;
            for(int t=0;t<4;t++){
                int newX = l+posX[t];
                int newY = r+posY[t];
                //超出边界
                if(newX<0||newX>=grid.length || newY<0||newY>=grid[newX].length) continue;
                if(grid[newX][newY]=='1' && mark[newX][newY]==0) q.add(new Node(newX,newY));
            }

        }
    }

    class Node{
        public int left;
        public int right;
        public Node(int i,int j){
            left=i;
            right=j;
        }
    }
}
