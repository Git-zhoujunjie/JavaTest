package LearningAlgorithmInterestingly.chapter1;

//验证哥德巴赫猜想：2000以内的偶数均可分解为两个素数的和
public class Goldbach {
    static boolean isPrime(int n){
        if(n<2) return false;

        int k = (int)(Math.sqrt((double) n)+0.5);
        for(int i = 2;i<=k;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    static void fun1(){
        for(int i = 2;i<2000;i +=2){
            for(int j=2;j<=i/2;j++){
                if(isPrime(j) && isPrime(i-j)) {
                    System.out.println(String.format("%d = %d + %d",i,j,i-j));

                }
            }
        }

    }

    static boolean[] flag = new boolean[2000];
    static void array(boolean[] a){
        for(int i=0;i<2000;i++){
            if(isPrime(i)) a[i] = true;
            else a[i] = false;
        }
    }
    static void fun2(){
        array(flag);
        for(int i=2;i<2000;i +=2){
            for(int j=2;j<=i/2;j++){
                if(flag[j] && flag[i-j]){
                    System.out.println(String.format("%d = %d + %d",i,j,i-j));

                }
            }
        }

    }

    static int[] prime = new int[305];
    static void array2(int[] a){
        int n=2;
        int i=0;
        while(n<2000){
            if(isPrime(n)) a[i++] = n;
            n++;
        }
    }
    static boolean bsearch(int n,int[] a){ //折半查找
        int begin =0;
        int end = a.length-1;
        while(begin<=end){
            int flag = (begin+end)/2;
            if(n > a[flag]){
                begin = flag+1;
            }
            else if(n < a[flag]){
                end = flag-1;
            }
            else return true;
        }
        return false;
    }
    static void fun3(){
        array2(prime);
        for(int i=2;i<2000;i +=2){
            for(int j=2;j<=i/2;j++){
                if(bsearch(j,prime) && bsearch(i-j,prime)){
                    System.out.println(String.format("%d = %d + %d",i,j,i-j));

                }
            }
        }

    }
    static void fun4(){
        array2(prime);
        for(int i=2;i<2000;i+=2){
            for(int j=0;j<prime.length;j++){
                boolean b =true;
                for(int k=j;k<prime.length && b;k++){
                    if(prime[j]+prime[k] > i) b=false;
                    if(prime[j]+prime[k] == i) {
                        System.out.println(String.format("%d = %d + %d",i,prime[j],prime[k]));
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        //fun1();
        //fun2();
        //fun3();
        fun4();
    }
}
