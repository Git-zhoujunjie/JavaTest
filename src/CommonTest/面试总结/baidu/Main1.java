package CommonTest.面试总结.baidu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/10 19:46
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for(int i=0;i<n;i++){
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(x[i],y[i]);
            }
            Arrays.sort(x);
            int res=0;
            for(int i=n-1;i>=0;i--){
                if(x[i]>=m) res += map.get(x[i]);
                else{
                    int num= m/x[i];
                    if(num>map.get(x[i])) num=map.get(x[i]);
                    int sum=0;
                    while(map.get(x[i])>0){
                        sum += num*x[i];
                        map.put(x[i],map.get(x[i])-num);
                        for(int j=0;j<=i;j++){
                            int cha = m-sum;
                            int num2 = 0;
                            if(cha>x[j]&&map.get(x[j])>0)
                                num2 = cha/x[j];
                            else num2 = 1;
                            if(num2>map.get(x[j])) num2=map.get(x[j]);
                            sum += num2*x[j];
                            map.put(x[j],map.get(x[j])-num2);
                            if(sum>=m) {
                                res++;
                                sum = 0;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}
