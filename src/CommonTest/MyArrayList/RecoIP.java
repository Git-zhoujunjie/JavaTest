package CommonTest.MyArrayList;

import org.junit.Test;

import java.util.*;

public class RecoIP {

    @Test
    public void test() {
//        int{] nums = {-1, 0, 1, 2, -1, -4};
//        System.out.println(threeSum(nums));
        /*
        {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
         */
//        int[][] grid = {{1}};
//        System.out.println(maxAreaOfIsland(grid));
//        int[] nums = {1,2,3,4,5,6,7};
//        System.out.println(search(nums,4));
        //System.out.println(getPermutation(3,3));

        int[][] a = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(a));
    }

    public int findCircleNum(int[][] M) {
        int maxr=M.length;
        int count=0;
        for(int i=0;i<maxr;i++){
            for(int j=0;j<=i;j++){
                int num=dfs(i,j,maxr,M);
                if(num>0) count++;
            }
        }
        return count;
    }

    int dfs(int r,int c,int maxr,int[][] a){
        if(r>=0 && r<maxr && c>=0 && c<=r && a[r][c]==1){
            a[r][c]=0;
            return 1 + dfs(r-1,c,maxr,a)+ dfs(r,c-1,maxr,a)+ dfs(r+1,c,maxr,a)+ dfs(r,c+1,maxr,a);
        }else return 0;
    }

    int k1;
    String res="";
    public String getPermutation(int n, int k) {
        //回溯法实现排列树
        int[] a = new int[n+10];
        for(int i=1;i<=n;i++) a[i] = i;
        //String res="";
        k1=k;
        dfs(1,n,a);
        return res;
    }

    void dfs(int t,int n,int[] a){
        if(t>n){
            k1--;
            if(k1==0){
                StringBuilder sb = new StringBuilder();
                for(int i=1;i<=n;i++){
                    sb.append(a[i]);
                }
                res = sb.toString();
            }
            return ;
        }
        for(int i=t;i<=n;i++){
            if(k1==0) break;
            int temp=a[i];
            a[i]=a[t];
            a[t]=temp;
            dfs(t+1,n,a);
            temp=a[i];
            a[i]=a[t];
            a[t]=temp;
        }
    }
    public int search(int[] nums, int target) {
        //采用二分搜索
        int beg = 0;
        int end = nums.length-1;

        while(beg<=end){
            int mid = (beg+end)/2;
            if(nums[mid] == target) return mid;
            else if(nums[beg]<=nums[mid] && target<=nums[mid] &&
                    target>=nums[beg]) end = mid-1;
            else if(target<=nums[mid] && nums[mid]<nums[beg]) end = mid-1;
            else if(target>=nums[beg] && nums[mid]<nums[beg]) end = mid-1;
            else beg = mid+1;
        }
        return -1;
    }
    int maxSize=0;
    int cur = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxr = grid.length;
        int maxc = grid[0].length;
        //boolean[][] flag = new boolean[maxr][maxc];
//        for(int i=0;i<maxr;i++){
//            for(int j=0;j<maxc;j++){
//                flag[i][j]=true;
//            }
//        }

        for(int i=0;i<maxr;i++){
            for(int j=0;j<maxc;j++){
                cur = 0;
                dfs(i,j,grid,maxr,maxc);

            }
        }
        return maxSize;
    }
    void dfs(int r,int c,int[][] a,int maxr,int maxc){ //r、c表示当前节点行和列
        if(r<0||r>=maxr || c<0|| c>=maxc || a[r][c]==0){
            if (maxSize < cur) maxSize = cur;
            return;
        }else {
            //if(flag[r][c]) {
                //添加到当前解中
            if(a[r][c]==1) {
                cur++;
                a[r][c]=0;
                //flag[r][c] = false;
                dfs(r - 1, c, a, maxr, maxc); //找上节点

                dfs(r, c - 1, a, maxr, maxc); //找左节点
                dfs(r + 1, c, a, maxr, maxc); //找下节点
                dfs(r, c + 1, a, maxr, maxc); //找右节点
            }
                //cur--;
            //}
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //先排序
        Arrays.sort(nums);
        int i = 0;
        int beg = i + 1;
        int end = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();

        while (i <= nums.length - 1&& beg<=nums.length - 1) {
            int sum = nums[i] + nums[beg] + nums[end];
            if (sum == 0) {
                List<Integer> ans = new ArrayList<>();
                ans.add(nums[i]);
                ans.add(nums[beg]);
                ans.add(nums[end]);
                res.add(ans);
                beg++;
                end--;
            }
            if (sum < 0) beg++;
            if (sum > 0) end--;
            if (beg >= end || (i >= 1 && nums[i] == nums[i - 1])) {
                i++;
                beg = i+1;
                end = nums.length - 1;
            }
        }
        return res;
    }

}
