package Leetcode;


/**
 * @author Zhoujunjie
 * @create 2019/9/14 17:15
 */
public class test416 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
//        root.right.right = new TreeNode(6);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);

        flatten(root);
    }

    public static void flatten(TreeNode root) {
        TreeNode last = null;
        preorder(root,last);
    }

    static void preorder(TreeNode root,TreeNode last){
        if(root==null) return;
        if(root.left==null && root.right==null){
            last = root;
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode last_left = null;
        TreeNode last_right = null;
        if(left!=null){
            preorder(left,last_left);
            root.left = null;
            root.right = left;
            last = last_left;
        }
        if(right!=null){
            preorder(right,last_right);
            if(last_left!=null){
                last_left.right = right;
            }
            last = last_right;
        }
    }

}



