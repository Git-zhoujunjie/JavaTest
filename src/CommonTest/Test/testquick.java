package CommonTest.Test;

public class testquick {

    public static int MoreThanHalfNum_Solution(int [] array) {
        //1、快排思路
        int mid = array.length >> 1;
        int begin=0;
        int end = array.length-1;
        int index = Partition(array,begin,end);
        while(index != mid){
            if(index>mid){
                end = mid-1;
                index = Partition(array,begin,end);
            }
            if(index<mid){
                begin = mid+1;
                index = Partition(array,begin,end);
            }
        }
        int result = array[index];
        //判断result出现的次数是否过一半
        int times=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==result) times++;
        }
        if(times*2<=array.length) return 0;
        return result;
    }

    static int Partition(int[] a,int begin,int end){
        //默认找第一个元素的位置
        int temp = a[begin];
        while(begin<end){
            while(begin<end && a[begin]<=temp) begin++;
            while(begin<end && a[end]>=temp) end--;
            //交换
            int e = a[begin];
            a[begin] = a[end];
            a[end] = e;
        }
        if(a[begin]>temp) {
            //交换
            int e = a[begin-1];
            a[begin] = a[end];
            a[end] = e;
            return begin-1;
        }
        return begin; //表示temp所在的位置
    }

    public static void main(String[] args) {
        int[] a = {2,2,2,6,2,3,5};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}
