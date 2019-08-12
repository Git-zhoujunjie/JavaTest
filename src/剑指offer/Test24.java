package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Test24 {
    Map<TreeNode,Integer> map = new HashMap<>();  //存放每个节点对应的路径和
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> currS = new ArrayList<>();
    //回溯法
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//        arrayListCon<TreeNode> list = new arrayListCon<>();  //模拟队列
//
//        list.add(root);
//        map.put(root,root.val);
//
//        while(list.size()>0){
//            TreeNode p = list.remove(0); //每次移除第一个
//            int s = map.get(p);
//
//
//            if(p.left!=null){
//                list.add(p.left);
//                map.put(p.left,s+p.left.val);
//            }
//            if(p.right!=null){
//                list.add(p.right);
//                map.put(p.right,s+p.right.val);
//            }
//        }
//
//        print(root,target);

        if(root==null) return result;

        currS.add(root.val);
        target -= root.val;

        if(target==0 && root.left==null && root.right==null){
            //输出
            result.add(new ArrayList<>(currS));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        currS.remove(currS.size()-1);
        return result;
    }


    void print(TreeNode p,int target){
        if(p==null) {
            return;
        }
        currS.add(p.val);
        int a;
        if((a = map.get(p))==target && p.left==null && p.right==null){
            ArrayList aa = new ArrayList();
            for(int i:currS) aa.add(i);
            //按照长度进行直接插入排序
            result.add(aa);
            currS.remove(currS.size()-1);
            return;
        }

        print(p.left,target);
        print(p.right,target);

        currS.remove(currS.size()-1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
//        TreeNode t6 = new TreeNode(1);
//        TreeNode t7 = new TreeNode(2);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
//        t3.left=t6;
//        t3.right=t7;

        Test24 test = new Test24();
        System.out.println(test.FindPath(t1,19));

    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
