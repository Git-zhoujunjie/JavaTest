//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int stuCount = sc.nextInt();
//        int op = sc.nextInt();
//        int[] strGoal = new int[stuCount+100];
//        for(int i =1;i<=stuCount;i++){
//            strGoal[i] = sc.nextInt();
//        }
//        while(sc.hasNext()){
//            String c = sc.next();
//            int begin = sc.nextInt();
//            int end = sc.nextInt();
//            if(c.equals("Q")){
//                if(begin>end){
//                    int temp = begin;
//                    begin = end;
//                    end = temp;
//                }
//                int max = strGoal[begin];
//                for(int i = begin+1;i<=end;i++){
//                    if(max<strGoal[i]) max = strGoal[i];
//                }
//                System.out.println(max);
//            }
//            else if(c.equals("U")){
//                strGoal[begin] = end;
//            }
//        }
//    }
//}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int M=0 ,N=0;
        int i;
        int A = 0,B = 0;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();

            //          System.out.println (N + " " + M);

            int[] score = new int[N];
            for(i=0; in.hasNext() && i<N; i++){
                score[i] = in.nextInt();
                //          System.out.println (score[i] + " ");
            }

            String c = null;

            for(i=0; in.hasNext() && i< M; i++){
                c  = in.next();
                A = in.nextInt();
                B = in.nextInt();
                process(c,A,B,score);
            }
        }

    }

    private static void process(String c, int a, int b, int[] score) {
        int begin,end;

        if(c.equals("Q")){
            end = Math.max(a, b);
            begin = Math.min(a, b)-1;
            int max = score[begin];
            for(int i=begin;i<end;i++){
                if(max<score[i]){
                    max = score[i];
                }
            }
            System.out.println(max);
        }else if(c.equals("U")){
            score[a-1] = b;
        }
    }
}