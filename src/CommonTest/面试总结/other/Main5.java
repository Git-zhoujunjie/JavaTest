package CommonTest.面试总结.other;

import java.util.Scanner;

/**
 * 沙滩按照线型摆放着n个大小不一的球形石头，
 * 已知第i个石头的半径为ri，且不存在两个石头有相同的半径。
 * 为了使石头的摆放更加美观，现要求摆放的石头的半径从左往右依次递增。
 * 因此，需要对一些石头进行移动，每次操作可以选择一个石头，
 * 并把它放在剩下n−1个石头在最左边或最右边。
 * 问最少需要操作多少次才能将这n个石头的半径变成升序？
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] r = new int[n];
            for(int i=0;i<n;i++){
                r[i] = in.nextInt();
            }
            int res = cishu(r);
            System.out.println(res);
        }
    }
    public static int cishu(int[] a){
        int count = a.length-1;
        if(count<=0) return 0;
        if(count==1) return 1;

        int temp = a[a.length-1];
        for(int i=a.length-1;i>=0;i--){
            if(temp-a[i] == 1){
                count--;
                temp = a[i];
            }
        }
        return count;
    }
}
