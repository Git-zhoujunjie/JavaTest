package CommonTest.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class testpq {

    public static void main(String[] args) {
        int[] a = {2,6,3,4,9,6,4,1};
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            queue.add(a[i]);
        }
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

}
