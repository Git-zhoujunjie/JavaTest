package Leetcode.Huawei2016;

import java.util.*;
public class qishuiping{
    static int result(int n){
        if(n==1) return 0;
        else if(n==2) return 1;
        else{
            return n/3+result(n/3+n%3);
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList();
        while(in.hasNext()){
            int num = in.nextInt();
            if(num == 0) {
                //输出并清空数组
//                for(int i=0;i<list.size();i++){
//                    System.out.println(list.get(i));
//                }
//                list.clear();
                continue;
            }
            else{
                //list.add(result(in.nextInt()));
                System.out.println(result(num));
                //System.out.println();
            }
        }
    }
}
