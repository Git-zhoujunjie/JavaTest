package LearningAlgorithmInterestingly.chapter1;

public class FibonacciArray {
    static int fun1(int n){ //时间复杂度为指数阶
        if(n<1) return -1;
        else if(n==1 || n==2) return 1;
        else return fun1(n-1)+fun1(n-2);
    }
    static int fun2(int n){
        if(n<1) return -1;
        int[] a = new int[n+10];
        a[0] = 1;
        a[1] = 1;
        for(int i =3;i<=n;i++)
            a[n] = a[n-1]+a[n-2];
        return a[n];
    }
    static int fun3(int n){
        if(n<1) return -1;
        int s1=1;
        int s2 =1;
        for(int i = 3;i<=n;i++){
            s2 = s2+s1;
            s1=s2-s1;
        }
        return s2;
    }
}
