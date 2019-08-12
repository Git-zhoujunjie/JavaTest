package CommonTest.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 单组测试数据。
 *
 * 第一行有一个整数n（0 < n <= 200）。
 *
 * 第二行有n个整数，表示数组p。
 *
 * 接下来有若干条情报要加密。
 *
 * 每一条要加密的情报占一行，先输入一个整数m表示要轮换的次数，后面是要加密的情报，与m用一个空格分开。情报只由英文字母组成，是非空串。0<m<=200。
 *
 * 当m=0的时候结束查询
 */
public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();

            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }

            int m;

            while ((m = in.nextInt()) != 0) {
                String s = in.next();
                while (s.length() < n) {
                    s += " ";
                }
                System.out.println(fun(p, m, s));
            }

        }
    }

    static String fun(int[] p,int m,String s){
        //m和p[m]交换即可
        char c1 = s.charAt(m-1);
        char c2 = s.charAt(p[m]-1);

        String result="";

        if(m<p[m]){
            result = s.substring(0,m-1)+c2+s.substring(m,p[m]-1)+c1+s.substring(p[m]);
        }else{
            result = s.substring(0,p[m]-1)+c1+s.substring(p[m],m-1)+c2+s.substring(m);
        }

        return result;
    }
}
