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
            int mid = Patition(A,low,high);
            qsort(A,low,mid);
            qsort(A,mid+1,high);
        }
    }

    public void qsort2(int[] A, int low, int high){
        if(low < high){
            int mid = Patition2(A,low,high);
            qsort2(A,low,mid);
            qsort2(A,mid+1,high);
        }
    }

    public static void main(String[] args){
        QuickSort test = new QuickSort();
        int[] A = {42,15,20,6,8,35,50,12,9,45,25,48,97,12,66,34,4,28};
        test.qsort(A,0,A.length-1);
        for(int a:A){
            System.out.print(a + " ");
        }
        System.out.println();

        int[] B = {42,15,20,6,8,35,50,12,9,45,25,48,97,12,66,34,4,28};
        test.qsort2(B,0,B.length-1);
        for(int a:B){
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
