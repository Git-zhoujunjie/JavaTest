package LearningAlgorithmInterestingly.chapter3;

public class QuickSort {
    public void swap(int a,int b, int[] A) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public int Patition(int[] A,int low, int high){
        int i=low;
        int j=high;
        while(i<j){
            while(i<j){
                if(A[i]>A[j]) { swap(i,j,A); break;}
                else j--;
            }
            while(i<j){
                if(A[i]>A[j]) { swap(i,j,A); break;}
                else i++;
            }
        }
        return i;
    }

    public int Patition2(int[] A,int low,int high){
        int i = low;
        int j = high;
        boolean b1 = false;
        boolean b2 = false;

        while(i<j){
            while(A[i]<=A[low] && i<j) i++;
            while(A[j]>=A[low] && i<j) j--;
            swap(i,j,A);
        }

        if(A[i]>A[low]){
            swap(i-1,low,A);
            return i-1;
        }

        swap(i,low,A);
        return i;
    }


    public void qsort(int[] A, int low, int high){
        if(low < high){
            int mid = partition(A,low,high);
            qsort(A,low,mid);
            qsort(A,mid+1,high);
        }
    }
    public int partition(int a[], int left, int right) {
        int key = a[left];  //选第一个元素作为 pivot
        while (left < right) {
            while (left < right && a[right] >= key)
                right--;
            a[left] = a[right];  //把比 pivot 小的元素调到 pivot 左边去
            while (left < right && a[left] <= key)
                left++;
            a[right] = a[left];  //把比 pivot 大的元素调到 pivot 右边去
        }
        a[left] = key;
        return left;   //返回 pivot 的数组位置
    }
    public void qsort2(int[] A, int low, int high){
        if(low < high){
            int mid = Patition2(A,low,high);
            qsort2(A,low,mid);
            qsort2(A,mid+1,high);
        }
    }

    public static void main(String[] args) {

        QuickSort test = new QuickSort();
        int[] A = {42,15,20,6,8,35,50,12,9,45,25,48,97,12,66,34,4,28};
        test.qsort(A,0,A.length-1);
        for(int a:A){
            System.out.print(a + " ");
        }
        System.out.println();

//        int[] B = {42,15,20,6,8,35,50,12,9,45,25,48,97,12,66,34,4,28};
//        test.qsort2(B,0,B.length-1);
//        for(int a:B){
//            System.out.print(a + " ");
//        }
//        System.out.println();
//        MidNum2 test = new MidNum2();
//        //int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,12};
//        int a[] = {3,2,5,4,1,6};
//        System.out.println(test.sort(a));

    }


}

class MidNum2 {
    public static double sort(int[] a) {
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

    //快排
    static int partition(int a[], int left, int right) {
        int key = a[left];  //选第一个元素作为 pivot
        while (left < right) {
            while (left < right && a[right] >= key)
                right--;
            a[left] = a[right];  //把比 pivot 小的元素调到 pivot 左边去
            while (left < right && a[left] <= key)
                left++;
            a[right] = a[left];  //把比 pivot 大的元素调到 pivot 右边去
        }
        a[left] = key;
        return left;   //返回 pivot 的数组位置
    }
}
