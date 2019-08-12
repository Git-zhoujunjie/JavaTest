package CommonTest.MyHeapSort;

import java.util.Arrays;

public class TestSort {
    //交换调整的过程
    public void OneSort(int[] array,int currentNode,int size){
        if(currentNode<size){
            int lchird = currentNode*2+1;
            int rchild = currentNode*2+2;

            int max = currentNode;

            if(lchird<size){
                if(array[lchird]>array[max]){
                    max = lchird;
                }
            }

            if(rchild<size){
                if(array[rchild]>array[max]){
                    max = rchild;
                }
            }

            if(max!=currentNode){
                int temp = array[max];
                array[max] = array[currentNode];
                array[currentNode] = temp;

                OneSort(array, max ,size);
            }
        }
    }

    //建堆的过程
    public void createHeap(int[] array,int size){
        for(int i=size-1;i>=0;i--){
            OneSort(array,i,size);
        }
    }

    public void sort(int[] array){
        for(int i=0;i<array.length;i++){
            createHeap(array,array.length-i);

            //交换
            int temp = array[0];
            array[0] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
    }

    public static void main(String[] args) {
        TestSort t = new TestSort();

        int[] a = {5,3,7,2,8,19,2,3,76,4};

        t.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
