package CommonTest.面试总结.快手;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/16 21:30
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            String[] num = new String[str.length()];
            List<String> res = new ArrayList<>();
            if(str.length()<=0) System.out.println(res);
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='2') num[i]="abc";
                if(str.charAt(i)=='3') num[i]="def";
                if(str.charAt(i)=='4') num[i]="ghi";
                if(str.charAt(i)=='5') num[i]="jkl";
                if(str.charAt(i)=='6') num[i]="mno";
                if(str.charAt(i)=='7') num[i]="pqrs";
                if(str.charAt(i)=='8') num[i]="tuv";
                if(str.charAt(i)=='9') num[i]="wxyz";
            }
            res = getStrings(num,0,res,"");
            System.out.println(res);
        }
    }
    //回溯法
    static List<String> getStrings(String[] num,int i,List<String> cur,String temp){
        if(i<num.length-1){
            for(int j=0;j<num[i].length();j++){
                cur = getStrings(num,i+1,cur,temp+num[i].charAt(j));
            }
        }else{
            for(int j=0;j<num[i].length();j++){
                cur.add(temp+num[i].charAt(j));
            }
        }
        return cur;
    }

}
