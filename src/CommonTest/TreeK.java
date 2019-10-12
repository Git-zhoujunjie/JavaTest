package CommonTest;

/**
 * @author Zhoujunjie
 * @create 2019/9/17 10:56
 */
public class TreeK {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val = val;}
    }
    static int index=0;
    static TreeNode fun(TreeNode root,int k){
        if(root!=null){
            TreeNode temp = fun(root.left,k);
            if(temp!=null) return temp;
            index++;
            if(k==index) return root;
            temp = fun(root.right,k);
            if(temp!=null) return temp;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(0);
        TreeNode e = new TreeNode(2);
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        TreeNode p = fun(a,3);
    }
}
