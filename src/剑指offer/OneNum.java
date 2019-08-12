package 剑指offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class OneNum {
    public static void main(String[] args) {
        int[] array = {4,6,2,2,3,3,8,8,9,9,1000000,1000000};
        int a = 0, b = 0;
        boolean flag = false;
        Queue q = new PriorityQueue();
        for(int i=0;i<array.length;i++) q.add(array[i]);
        while(!q.isEmpty()){
            int a1 = (int)q.poll();
            if(q.isEmpty()) {
                b=a1;
                break;
            }
            int a2 = (int)q.peek();
            if(a1==a2) {
                q.remove();
                continue;
            }
            else{
                if(!flag) {
                    a=a1;
                    flag = true;
                }
                else b=a1;
            }
        }

        System.out.println(a+"---"+b);
    }
}
