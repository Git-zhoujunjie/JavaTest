package Leetcode;

import java.util.Stack;

/**
 * @author Zhoujunjie
 * @create 2019/9/10 15:55
 */
public class test224 {

    public static void main(String[] args) {
        String s = " 3+ 5-(4*2)+2 + 10 ";
        System.out.println(calculate2(s));
    }
    public static int calculate(String s){
        char op = '+';
        int num=0;
        Stack<Integer> stack = new Stack<>();
        for(char c:(s+",").toCharArray()){
            if(c==' ') continue;
            if(c>='0'&&c<='9') num = num*10+c-'0';
            if(c<'0' || c>'9'){
                if(op=='+') stack.push(num);
                if(op=='-') stack.push(-num);
                if(op=='*') stack.push(num*stack.pop());

                op=c;
                num=0;
            }
        }
        int res=0;
        while(!stack.isEmpty()) res += stack.pop();
        return res;
    }

    static void compute(Stack<Integer> numS,Stack<Character> opS){
        if(numS.isEmpty()||opS.isEmpty()) return;
        int num1 = numS.pop();
        int num2 = numS.pop();
        char op = opS.pop();
        if(op=='+') numS.push(num1+num2);
        if(op=='-') numS.push(num2-num1);
        if(op=='*') numS.push(num2*num1);
    }
    public static int calculate2(String s){
        Stack<Integer> numS = new Stack<>();
        Stack<Character> opS = new Stack<>();
        int num=0;
        char op = '+';
        int state=0;
        final int BEGIN_STATE=0;
        final int NUM_STATE=1;
        final int OPE_STATE=2;
        boolean isCal = false;
        char[] cs = s.toCharArray();
        for(int i=0;i<cs.length;i++){
            if(cs[i]==' ') continue;
            switch (state){
                case BEGIN_STATE:
                    if(cs[i]<='9'&&cs[i]>='0') state=NUM_STATE;
                    else state=OPE_STATE;
                    i--;
                    break;
                case NUM_STATE:
                    if(cs[i]<='9'&&cs[i]>='0') num = num*10 + cs[i]-'0';
                    else{
                        numS.push(num);
                        if(isCal) compute(numS,opS);
                        state = OPE_STATE;
                        i--;
                        num=0;
                    }
                    break;
                case OPE_STATE:
                    if(cs[i]=='+'||cs[i]=='-'||cs[i]=='*') {
                        opS.push(cs[i]);
                        isCal=true;
                    }
                    if(cs[i]=='('){
                        state=NUM_STATE;
                        isCal=false;
                    }
                    if(cs[i]<='9'&&cs[i]>='0'){
                        state=NUM_STATE;
                        i--;
                    }
                    if(cs[i]==')'){
                        compute(numS,opS);
                    }
                    break;
            }
        }
        if(num!=0) {
            numS.push(num);
            compute(numS,opS);
        }
        if(numS.isEmpty()) return 0;
        return numS.pop();
    }
}
