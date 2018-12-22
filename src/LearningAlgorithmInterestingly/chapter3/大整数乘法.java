package LearningAlgorithmInterestingly.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BigNum{  //
    //ArrayList<Integer> s = new ArrayList<>();   //存储大数，倒序存储
    int[] s = new int[100];
    int l;  //数组的长度
    int c;    //当前数的阶数

}
public class 大整数乘法 {
    public BigNum input() throws IOException {
        BigNum num = new BigNum();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = buf.readLine().split("");
        for (int i = 0; i < str.length; i++) {
            num.s[i] = Integer.parseInt(str[str.length - 1 - i]);
            //num.s.add();   //倒序存储
        }
        num.l = str.length;
        num.c = 0;
        return num;
    }

    public void cp(BigNum a, BigNum b, BigNum c) { //将a平分为b和c，b存储低位，c存储高位
        //if (a.l == 1) return;
        int mid = a.l / 2;
        for (int i = 0; i < mid; i++) {
            b.s[i] = a.s[i];
            //b.s.add(a.s.get(i));
        }
        b.l = mid;
        b.c = a.c + 0;
        int j = 0;
        for (int i = mid ; i <= a.l - 1 ; i++) {
            c.s[j++] = a.s[i];
            //c.s.add(a.s.get(i));
        }
        c.l = a.l - mid;
        c.c = a.c + mid;
    }

    public void mul(BigNum s,BigNum h,BigNum l) {  //将两个乘数h,l进行相乘，结果存在s中
        if (h.l == 1 || l.l == 1) {   //当分解到只有一位乘数时，相乘
            if (h.l > 1) {    //保证h的位数为1位
                BigNum temp = h;
                h = l;
                l = temp;
            }
            int jinwei = 0;
            int i;
            for (i = 0; i <= l.l - 1; i++) {
                int n = h.s[0] * l.s[i];
                //int n = h.s.get(0) * l.s.get(i);
                s.s[i] = (n+ jinwei) % 10 ;
                //s.s.add(n % 10 + jinwei);
                jinwei = (n+ jinwei) / 10;
            }
            if (jinwei != 0) {
                s.s[i++] = jinwei;
                //s.s.add(jinwei);
            }
            //s.l = s.s.size();
            s.l = i;
            s.c = h.c + l.c;
            return;
        }

        BigNum h1 = new BigNum();  //high
        BigNum l1 = new BigNum();  //low
        BigNum h2 = new BigNum();  //high
        BigNum l2 = new BigNum();  //low
        cp(h, h1, l1);
        cp(l, h2, l2);

        BigNum s1 = new BigNum();  //high
        BigNum s2 = new BigNum();  //low
        BigNum s3 = new BigNum();  //high
        BigNum s4 = new BigNum();  //low
        mul(s1, h1, h2);
        mul(s2, h1, l2);
        mul(s3, l1, h2);
        mul(s4, l1, l2);

        BigNum a1 = new BigNum();  //high
        BigNum a2 = new BigNum();
        BigNum a3 = new BigNum();

        add(s, s3, s4);
        add(a2, s, s2);
        add(s, a2, s1);


    }

    public void add(BigNum sum,BigNum a,BigNum b){  //将a，b合并到sum中
        int ta,tb;  //表示各位上相加的数字
        int jinwei = 0;
        if(a.c<b.c){   //保证a的次幂比b大
            BigNum temp = a;
            a=b;
            b=temp;
        }
        sum.c = b.c;  //则和的次幂就是b的次幂
        int k = a.c-b.c;//表示a要补0点位数
        int len = Math.max(a.l+a.c,b.l+b.c);
        len = len - b.c;
        int i;
        for(i =0;i<len;i++) {
            if (i < k) ta = 0;  //a左侧补0
            else ta = a.s[i - k];
            if (i < b.l) tb = b.s[i];
            else tb = 0;  //b右侧补0
            if (i >= a.l + k) ta = 0;  //a右侧补0

            int s = ta + tb;
            sum.s[i] = (s + jinwei)%10;
            //sum.s.add((s + jinwei)%10);
            jinwei = (s + jinwei)/10;
        }
        if(jinwei>10){
            sum.s[i++] = jinwei;
            //sum.s.add(jinwei);
        }
        sum.l = i;
        //sum.l = sum.s.size();
    }

    public static void main(String[] args) throws IOException{
        大整数乘法 test = new 大整数乘法();
        BigNum a = new BigNum();
        a = test.input();
        BigNum b = new BigNum();
        b = test.input();

        BigNum c = new BigNum();
        test.mul(c,a,b);

        for(int i = c.l-1;i>=0;i--){
            System.out.print(c.s[i]);
        }
        System.out.println();
//
//        BigNum d = new BigNum();
//        test.cp(a,c,d);
//        BigNum x = new BigNum();
//        BigNum y = new BigNum();
//        test.cp(b,x,y);
//
//        BigNum e = new BigNum();
//        test.mul(e,c,x);
//        test.add(e,d,y);
    }

}
