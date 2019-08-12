package 剑指offer;

public class llyunqi {
    public static void main(String[] args) {
        int[] a = {1,3,5,0,0};
        isContinuous(a);
    }

    public static boolean isContinuous(int [] numbers) {
        //1、先给数组排序
        java.util.Arrays.sort(numbers);
        //如果存在相同元素，直接返回false
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]==numbers[i+1] && numbers[i]!=0) return false;
        }
        //2、求出0的个数
        int count = 0;
        int i=0;
        while(numbers[i]==0) i++;
        count = i;
        //3、求出数组剩余值的最大与最小的差，表示能组成的顺子的长度
        int tlen = numbers[numbers.length-1]-numbers[i] + 1;
        if(count==0 && (numbers.length-i)==tlen) return true;
        if(count==(tlen - (numbers.length-i))) return true;

        return false;
    }
}
