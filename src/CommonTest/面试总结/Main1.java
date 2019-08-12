package CommonTest.面试总结;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner in = new Scanner(System.in);
        //输入
        int n = in.nextInt();
        String[] strings = new String[n];
        for(int i=0;i<n;i++){
            strings[i] = in.next();
        }

        //输出
        for(String str : strings){
            char[] cs = str.toCharArray();
            for(int i=0;i<cs.length;i++){
                char c = cs[i];
                if(c=='(' || (c>='A'&&c<='Z')) stack.push(c+"");
                if(c=='0') continue;
                if(c>='1' && c<='9') {
                    int len = c - '0';
                    //判断下一个是否为数字

                    while (cs[i + 1] >= '1' && cs[i + 1] <= '9' && i<cs.length-1) {
                        len = len * 10 + cs[i + 1] - '0';
                        i++;
                    }

                    //取出栈顶元素
                    String stemp = stack.pop();
                    StringBuilder sb = new StringBuilder();
                    while (len > 0) {
                        sb.append(stemp);
                        len--;
                    }
                    //再将结果压入栈
                    stack.push(sb.toString());
                }
                if(c==')'){
                    //将栈内到'('的元素取出形成字符串压入栈
                    StringBuilder sb = new StringBuilder();
                    while(!stack.peek().equals("(")){
                        String stemp = stack.pop();
                        sb.insert(0,stemp);
                    }
                    stack.pop();
                    stack.push(sb.toString());
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.empty()){
                String stemp = stack.pop();
                sb.insert(0,stemp);
            }
            System.out.println(sb.toString());
        }
    }
}
