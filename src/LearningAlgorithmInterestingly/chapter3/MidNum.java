package LearningAlgorithmInterestingly.chapter3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MidNum {

    public int partition(int[] array,int low,int high){
        int i = low;
        int j = high;

        while(i<j){
            while(array[i]<=array[low] && i<j) i++;
            while(array[j]>=array[low] && i<j) j--;
            swap(i,j,array);
        }

        if(array[i]>array[low]){
            swap(i-1,low,array);
             return i-1;
        }
        swap(i,low,array);
        return i;
    }

    public void swap(int a,int b, int[] array) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public double qsort(int[] a){
        //int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int len = a.length;  //取数组长度
        int start = 0, end = len - 1;
        int addr = partition(a, start, end);
        int mid = (len - 1) / 2;
        while (addr != mid) {
            if (addr < mid)
                addr = partition(a, addr + 1, end);
            else addr = partition(a, start, addr - 1);
        }
        double ans;
        //数组长度分为奇数和偶数两种情况
        if (len % 2 != 0) ans = a[addr];
        else ans = (double) (a[addr] + a[addr + 1]) / 2;
        return ans;
    }

    public static void main(String[] args) {
        MidNum test = new MidNum();
        int[] array = {3,1,4,2,5};
        System.out.println(test.qsort(array));
    }

    @Test
    public void test(){
        List list = Arrays.asList(1,2,3,4,5);
        for(int i=0;i<list.size();i++){
            if(i==2){
                list.remove(i);
            }
        }
    }
}
