package CommonTest.面试总结.zhaohang;

import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/15 21:12
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            char[] cs = str.toCharArray();
            int[] res = new int[cs.length];

            int begin=0;
            int end=0;
            for(int i=0;i<cs.length-1;i++){
                if(cs[i]=='R'&&cs[i+1]=='L'){
                    res[i]=1;
                    res[i+1]=1;
                }
            }
            while(end<cs.length) {
                while (cs[end] != 'L') end++;
                int cha = end-begin-1;
                res[end - 1] += cha/2 ;
                res[end] += cha-cha/2 ;

                begin=end;
                //找到下一个R
                while(begin<cs.length && cs[begin]!='R') begin++;
                end = begin+1;
            }
            //从后往前
            begin = cs.length-1;
            end = begin;
            while(end>=0){
                while(cs[end]!='R') end--;
                int cha = begin-end-1;
                res[end + 1] += cha/2;
                res[end] += cha-cha/2;

                begin = end;
                while( begin>=0 && cs[begin]!='L' ) begin--;
                end = begin-1;
            }
            StringBuilder builder = new StringBuilder();
            for(int i=0;i<res.length;i++){
                builder.append(res[i]+" ");
            }
            String result = builder.toString();
            System.out.println(result.substring(0,result.length()-1));
        }

    }
}
