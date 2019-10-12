package CommonTest.面试总结.小米;

/**
 * @author Zhoujunjie
 * @create 2019/9/6 20:14
 */

import java.util.Stack;

/**
 *
 */
public class Main2 {

    public Node create(String str){
        char[] cs = str.toCharArray();
        Node root = new Node(cs[0]-'0');
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        boolean l = false;
        boolean r = false;
        for(int i=1;i<cs.length;i++){
            if(cs[i] >= '0' && cs[i] <= '9') {
                Node p = new Node(cs[i]-'0');
                if(l) {
                    stack.peek().left = new Node(cs[i]-'0');
                }
                stack.push(p);
            }else if(cs[i]=='('){
                Node pre = stack.peek();
                if(cs[i+1] >= '0' && cs[i+1] <= '9') l = true;
                else r=true;
            }
        }
        return root;
    }
}

class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){this.val = val;}
}
