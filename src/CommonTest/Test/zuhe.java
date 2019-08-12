package CommonTest.Test;

import java.util.Scanner;

public class zuhe {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int sum=0;
            int fenzi=jiec(n);
            for(int i=1;i<3;i++){
                int fenmu = jiec(i)*jiec(n-i);
                sum += fenzi/fenmu;
            }
            System.out.println(sum+1);
        }
    }

    static int jiec(int i){
        int ji = 1;
        while(i>1){
            ji *= i;
            i--;
        }
        return ji;
    }
}
