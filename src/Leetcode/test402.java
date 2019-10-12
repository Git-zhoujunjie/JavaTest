package Leetcode;

import java.util.Stack;

/**
 * @author Zhoujunjie
 * @create 2019/9/11 0:07
 */
public class test402 {

    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();
        char[] cs = num.toCharArray();
        if(cs.length<=0) return "0";
        for(int i=0;i<cs.length;i++){
            while(!stack.isEmpty() && k>0 && cs[i]<stack.peek()){
                stack.pop();
                k--;
            }
            if(cs[i]!='0' || !stack.isEmpty()){
                stack.push(cs[i]);
            }
        }
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString();
        return res.equals("")?"0":res;
    }
}
