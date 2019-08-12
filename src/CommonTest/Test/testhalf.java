package CommonTest.Test;

public class testhalf {

    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array.length<=0) return 0;
        //2、判断次数即可
        int times = 1;
        int temp = array[0];
        for(int i=1;i<array.length;i++){
            if(times==0){
                temp = array[i];
                times=1;
            }else if(temp==array[i]) times++;
            else times--;
        }
        //此时temp即为次数最多的元素
        //判断temp出现的次数是否大于一般
        times = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==temp) times++;
        }
        if(times*2<=array.length) return 0;
        return temp;
    }

    public static void main(String[] args) {
        int[] a = {1,2,9,2,4,2,7,2,3};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}
