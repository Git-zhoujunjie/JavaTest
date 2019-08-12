package CommonTest.Test;

import java.util.Arrays;

public class test3 {
    static int count=0;
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        pailie(0,a.length,a);
        System.out.println(count);
    }

    static void pailie(int t,int n,int[] a){
        if(t>=n){
            count++;
            System.out.println(Arrays.toString(a));
            return;
        }
        for(int i=t;i<n;i++){
            int temp = a[i];
            a[i] = a[t];
            a[t] = temp;

            pailie(t+1,n,a);

            temp = a[i];
            a[i] = a[t];
            a[t] = temp;
        }
    }
}
