package CommonTest.面试总结.携程;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 豚厂给自研的数据库设计了一套查询表达式，在这个表达式中括号表示将里面的字符串翻转。请你帮助实现这一逻辑
 */
public class Main {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static String resolve(String expr) {
        Stack<Character> stack = new Stack<>();
        char[] chars = expr.toCharArray();
        for(char c:chars){
            if(c==')'){
                Queue<Character> stemp = new LinkedList<>();
                while(!stack.empty() && stack.peek()!='('){
                    stemp.add(stack.pop());
                }
                if(stack.empty()) return "";
                stack.pop();
                while(!stemp.isEmpty()) stack.push(stemp.remove());
            }else stack.push(c);
        }
        StringBuilder res = new StringBuilder();
        while(!stack.empty()){
            res.append(stack.pop());
        }
        String result = res.reverse().toString();
        if(result.contains("(")||result.contains(")")) return "";
        else return result;
    }
/******************************结束写代码******************************/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;
            
        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }
  
        res = resolve(_expr);
        System.out.println(res);
    }
}