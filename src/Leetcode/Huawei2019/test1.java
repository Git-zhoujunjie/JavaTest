package Leetcode.Huawei2019;

import java.io.*;
import java.util.*;

/**
 * 输入一行数字
 * 输出这行数字中最大的三位数
 */
public class test1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            String s = in.nextLine();
            String[] str = s.split("");
            int len = str.length;
            if(len<=3){
                System.out.println(s);
            }
            else{
                int max = Integer.parseInt(str[0]);
                int ind = 0;
                int maxNum=0;
                for(int i=1;i<=len-3;i++){
                    int t = Integer.parseInt(str[i]);
                    if(max<t) {
                        max=t;
                        ind = i;
                    }
                }

                for(int i=0;i<=len-3;i++){
                    if(max == Integer.parseInt(str[i])){
                        if(maxNum < Integer.parseInt(s.substring(i,i+3)))
                            maxNum = Integer.parseInt(s.substring(i,i+3));
                    }
                }
               // System.out.println(s.substring(ind,ind+3));
                System.out.println(maxNum);
            }

            //test();
        }
    }

    public static void test(){

        try(BufferedReader in =
                    new BufferedReader(new InputStreamReader(System.in));){
            String msg;
            while((msg=in.readLine())!=null){
                int len = msg.length();
                if(len<=3) System.out.println(msg);
                else{
                    char max = msg.charAt(0);
                    int maxNum = 0;
                    for(char c:msg.toCharArray()){ //找出最大的数字
                        if(c>max) max=c;
                    }
                    int pos=0;
                    for(char c:msg.toCharArray() ){
                        if(c == max ){
                            pos = msg.indexOf(c,pos);
                            if(pos<=msg.length()-3){
                                int n = Integer.parseInt(
                                        msg.substring(pos, pos + 3));
                                if (maxNum < n) maxNum = n;
                            }
                            pos++;
                        }
                    }
                    System.out.println(maxNum);
                    //System.out.println(msg.substring(msg.indexOf(max),msg.indexOf(max)+3));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
