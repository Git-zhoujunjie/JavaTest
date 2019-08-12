package CommonTest.Test;

public class testroa {

    public static void main(String[] args) {
        int[] a = {6,1,2,3,4,5};
        System.out.println(minNumberInRotateArray(a));
    }

    public static int minNumberInRotateArray(int [] array) {
        if(array.length<=0) return 0;
        //有序的数组一定要想到二分法
        //分析：begin，mid，end分别表示首 中 末
        //1、a[begin]<a[end]表示数组完全递增，则返回a[begin]
        //2、a[begin]>=a[end]表示存在旋转，
        int begin=0;
        int end = array.length-1;
        int mid = begin;
        while(begin<=end){
            mid = (begin+end)/2;
            if(array[begin]==array[end] && array[mid]==array[begin]){
                //顺序查找
                int temp = array[begin];
                for(int i=begin;i<=end;i++){
                    if(temp>array[i]) temp = array[i];
                }
                return temp;
            }
            //表示数组直接有序
            if(array[begin]<array[end]) return array[begin];
            if(array[begin]>=array[end] && array[mid]>=array[begin]) begin = mid+1;
            if(array[begin]>=array[end] && array[mid]<=array[end]) end = mid;

        }
        return array[mid];
    }
}
