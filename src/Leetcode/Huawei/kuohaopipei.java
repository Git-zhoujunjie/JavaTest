package Leetcode.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 使用栈实现字符串的括号匹配检查。
 */
public class kuohaopipei {

    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            System.out.println(match(str));
        }
    }

    /**
     * 进行匹配的算法。
     *
     * @param str 待检查的字符串。
     * @return boolean
     */
    public static boolean match(String str) {
        Stack stack = new Stack(); // 定义一个存放括号的栈。
        char[] ca = str.toCharArray(); // 将字符串转为字符数组以便对其遍历。
        stack.push((Character) ca[0]); // 首先将第一个字符压入栈中。
        /*
         * 从第二个字符开始，依次与栈中字符匹配。
         * 成功则将栈顶元素弹出。
         * 失败则将字符数组中的当前字符压入栈中。
         */
        for (int index = 1; index < ca.length; ++index) {
            if(stack.empty()){
                return false;//右括号先于左括号，则wrong
            }
            Character c1 = (Character) stack.peek();
            Character c2 = ca[index];
            if ((c1.equals('(') && c2.equals(')'))
                    || (c1.equals('[') && c2.equals(']'))) {
                stack.pop();
            } else {
                stack.push(c2);
            }
        }
        return stack.empty();
    }
}
