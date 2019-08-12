package CommonTest.MyArrayList;

import java.util.Scanner;

public class test22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            System.out.println(findX(a));
        }

    }
    public static int findX(int a){
        for(int i=1;i<Math.sqrt(a);i++){
            if(a%i==0) {
                int A = a/i;
                int B = i;
                if ((A + B) % 2 == 0 && (A - B) % 2 == 0)
                    if((A-B)>0) {
                        return (A - B) / 2;
                    }
            }
        }
        return -1;
    }
}
