package LearningAlgorithmInterestingly.chapter3;

//算法思想：用数组s存储有序数列

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 二分搜索 {
    public int[] arr = new int[1];

    static int binsearch(int n,int[] a){
        int begin = 0;
        int end = a.length-1;
        int mid = 0;
        while(begin<=end){
            mid = (begin+end)/2;

            if(n==a[mid]) return mid;
            else if(n<a[mid]) end = mid-1;
            else begin = mid+1;
        }
        return mid;
    }

    static int binsearch2(int n,int[] a,int begin,int end){
        int mid = (begin+end)/2;
        if(begin>end) return -1;
        else {
            if(a[mid] == n) return mid;
            else if(a[mid] > n) return binsearch2(n,a,begin,mid-1);
            else return binsearch2(n,a,mid+1,end);
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("请输入元素个数：");
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(b.readLine());
        System.out.println("请输入元素，用空格隔开：");
        String[] str = b.readLine().split(" ");
        int[] arr = new int[c];
        for(int i = 0;i<c;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.print("请输入要寻找的元素：");
        int n = Integer.parseInt(b.readLine());

        System.out.println(binsearch(n,arr));
        System.out.println(binsearch2(n,arr,0,arr.length-1));
    }

}
