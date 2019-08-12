package CommonTest.MyArrayList;

import org.junit.Test;

import java.util.*;


public class testComparator {

    public void test() {
        List<Price> list = new ArrayList<>();
        Price p1 = new Price(5,1);
        Price p2 = new Price(2,1);

        Price p3 = new Price(1,1);

        Price p4 = new Price(6,1);

        Price p5 = new Price(3,1);
        list.add(p1);
        list.add(p2);

        list.add(p3);
        list.add(p4);
        list.add(p5);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        String s = "1234";
        String s2 = "12234";
        System.out.println(s2.indexOf(s));
        s.isEmpty();
        //Arrays.equals(s,s2);

        //s.indexOf()
        String[] strings = null;
       // Arrays.

    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int winSize = s1.length(); //滑动窗口大小

        int[] c1 = new int[26]; //存放s1各个数字的个数
        for(int i=0;i<winSize;i++) c1[s1.charAt(i)-'a']++;

        for(int i=0;i<=s2.length()-winSize;i++){
            int[] c2 = new int[26]; //存放s2各个数字的个数
            String temp = s2.substring(i,i+winSize);
            for(int j=0;j<winSize;j++) c2[temp.charAt(j)-'a']++;
            //如果temp中各个字母的个数和s1完全相同，则说明true
            if(Arrays.equals(c1,c2)) return true;
        }
        return false;
    }
    public String multiply(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        int[] arr1 = new int[110];
        int k=0;
        for(int i=c1.length-1;i>=0;i--){
            arr1[k++]=c1[i]-'0';
        }
        char[] c2 = num2.toCharArray();
        int[] arr2 = new int[110];
        k=0;
        for(int i=c2.length-1;i>=0;i--){
            arr2[k++] = c2[i]-'0';
        }

        StringBuilder sb = new StringBuilder();
        int[] a = new int[220];
        for(int i=0;i<c2.length;i++){
            int jwc = 0;
            int jwj = 0;
            for(int j=0;j<c1.length;j++) {
                int r = arr1[j] * arr2[i] + jwc;

                jwc = r / 10;
                a[i + j] = a[i + j] + jwj + r % 10;

                jwj = a[i + j] / 10;
                a[i + j] %= 10;
            }
            if(jwc>0||jwj>0) a[i+c1.length]=jwc+jwj;
            //if(jwj>0 && i==c2.length-1) a[i+c1.length]=jwj;
        }
        //输出
        String result = "";
        boolean flag = true;
        for(int i=c1.length+c2.length-1;i>=0;i--){
            if(a[i]==0 && flag) {
                continue;
            }
            flag = false;
            result += a[i];
        }
        return result;
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split(" ");
        // for(int i=0;i<strs.length/2;i++){
        //     String temp = strs[i].trim();
        //     strs[i] = strs[strs.length-i-1].trim();
        //     strs[strs.length-i-1] = temp;
        // }
        StringBuilder sb = new StringBuilder();

        for(int i=strs.length-1;i>=0;i--){
            if(strs[i].length()==0) continue;
            sb.append(strs[i].trim()+" ");
        }

        return sb.toString().trim();
    }
    public String simplifyPath(String path) {
        path = path+"/";
        Stack<String> stack = new Stack<>();
        int begin = path.indexOf("/");
        while(begin>=0){
            int end = path.indexOf("/",begin+1);
            if(end>begin+1){
                String s = path.substring(begin+1,end);
                if(s.equals("..")) {
                    if(!stack.isEmpty())
                        stack.pop();
                }else if(s.equals(".")){
                    begin = end;
                    continue;
                }else {
                    stack.push(s);
                }
            }
            begin = end;
        }
        //输出
        StringBuilder sb = new StringBuilder();
        Stack<String> stack2 = new Stack<>();
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            stack2.push("/"+stack.pop());
        }
        while(!stack2.isEmpty()){
            sb.append(stack2.pop());
        }

        return sb.toString();
    }
    @Test
    public void test1(){
        //System.out.println(checkInclusion("adc","dcda"));
        //System.out.println(multiply("123456789","987654321"));
        //System.out.println(reverseWords("a good   example"));
        //System.out.println("aaa".substring(0,0).equals(""));
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}

class Price implements Comparable<Price>{
    int v;  //价值
    int m;  //重量
    double p ;  //单价

    public Price(int v, int m) {
        this.v = v;
        this.m = m;
        this.p = v/m;
    }

    @Override
    public String toString() {
        return p+"   ";
    }

    @Override
    public int compareTo(Price o){
        if(o.p<this.p) return 1;
        else if(o.p==this.p) return 0;
        else return -1;
    }
}
