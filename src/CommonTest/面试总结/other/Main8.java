package CommonTest.面试总结.other;

import java.util.Scanner;
import java.util.Stack;

/**
 * 沙滩按照线型摆放着n个大小不一的球形石头，
 * 已知第i个石头的半径为ri，且不存在两个石头有相同的半径。
 * 为了使石头的摆放更加美观，现要求摆放的石头的半径从左往右依次递增。
 * 因此，需要对一些石头进行移动，每次操作可以选择一个石头，
 * 并把它放在剩下n−1个石头在最左边或最右边。
 * 问最少需要操作多少次才能将这n个石头的半径变成升序？
 */
public class Main8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<chars.length;i++){
            if((chars[i]>='A'&&chars[i]<='Z')||(chars[i]>='a'&&chars[i]<='z')){
                stack.push(chars[i]);
            }
            if(chars[i]=='<'){
//                if((chars[i-1]>='A'&&chars[i-1]<='Z')||(chars[i-1]>='a'&&chars[i-1]<='z')){
//                    stack.pop();
//                }
                if(chars[i-1]!='(' && chars[i-1]!=')')
                    stack.pop();
            }
            if(chars[i]=='('){
                stack.push(chars[i]);
            }
            if(chars[i]==')'){
                while(stack.peek()!='(') stack.pop();
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.empty()) res.append(stack.pop());

        String s = res.reverse().toString();
        System.out.println(s);

    }

}
