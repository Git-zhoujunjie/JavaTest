package CommonTest.面试总结;

import java.time.Instant;
import java.util.*;

/**
 * 某条街道两侧分别种植了一排树木，并按如下编号：
 *
 * 1 3 5 7 .... 45 47 49 ... 99
 *
 * 2 4 6 8 ... 46 48 50 ... 100
 *
 * 但是有一些树被砍去，希望你能找出一边最长的连续的大树。
 */
public class Main6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] r = new int[n];
            for(int i=0;i<n;i++){
                r[i] = in.nextInt();
            }
            //int res = maxNum(r);
            List<Integer> list = maxNum(r);
            System.out.println(list.get(0)+" "+list.get(1));
        }

        //Instant.now();
    }
    public static List<Integer> maxNum(int[] a){
        List<Integer> list = new ArrayList<>();
        //先排序
        Arrays.sort(a);
        int maxn=0;
        int prej=-1;
        int preo=0;
        int begin=0;

        for(int i=0;i<a.length;i++){
            if(a[i]%2!=0){
                int len = (a[i]-prej-2)/2;
                if(maxn<len){
                    maxn = len;
                    begin = prej+2;
                }
                prej = a[i];
            }else{
                int len = (a[i]-preo-2)/2;
                if(maxn<len){
                    maxn = len;
                    begin = preo+2;
                }
                preo = a[i];
            }
        }
        int yuj = (99-prej)/2;
        int yuo = (100-preo)/2;
        if(maxn<yuj){
            maxn = yuj;
            begin = prej+2;
        }
        if(maxn<yuo){
            maxn=yuo;
            begin = preo+2;
        }
        list.add(begin);
        list.add(maxn);
        return list;
    }
}
