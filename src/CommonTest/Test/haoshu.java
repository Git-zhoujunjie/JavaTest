package CommonTest.Test;

import java.util.Scanner;

public class haoshu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int count = 0;
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                int temp = i;
                int jie=0;
                while (temp > 0) {
                    int yu = temp % 10;
                    int hao = haoshu(yu);
                    if (hao == -1) {
                        sum=0;
                        break;
                    }

                    sum += hao*Math.pow(10,jie);
                    jie++;
                    temp /= 10;
                }
                if (sum!=0 && sum != i) {
                    System.out.println(i);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static int haoshu(int k) {
        if (k == 0) return 0;
        else if (k == 1) return 1;
        else if (k == 2) return 5;
        else if (k == 5) return 2;
        else if (k == 6) return 9;
        else if(k==8) return 8;
        else if (k == 9) return 6;
        else return -1;
    }

}
