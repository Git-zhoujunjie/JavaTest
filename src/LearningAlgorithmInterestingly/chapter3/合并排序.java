package LearningAlgorithmInterestingly.chapter3;

public class 合并排序 {

    public void Merge(int[] A, int begin,int mid,int end){
        int[] B = new int[end-begin+1];
        int i=begin;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=end){
            if(A[i]<A[j]) B[k++]=A[i++];
            else B[k++]=A[j++];
        }
        while(i<=mid) B[k++]=A[i++];
        while(j<=end) B[k++]=A[j++];
        for(int m=begin,t=0;m<=end;m++,t++){
            A[m] = B[t];
        }
    }
    public void MergeSort(int[] A, int begin, int end){
        if(begin<end){
            int mid = (begin+end)/2;
            MergeSort(A,begin,mid);
            MergeSort(A,mid+1,end);
            Merge(A,begin,mid, end);
        }
    }

    public static void main(String[] args){
        合并排序 test = new 合并排序();
        int[] A = {42,15,20,6,8,35,50,12};
        test.MergeSort(A,0,7);
        for(int a:A){
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
