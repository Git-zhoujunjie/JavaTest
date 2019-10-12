package CommonTest.面试总结.other;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author Zhoujunjie
 * @create 2019/9/9 9:48
 */
public class SlideWindow {

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        System.out.println(maxInWindows(num,size));
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> Integer.compare(y,x));
        if(num.length<=0 || size>num.length) return res;
        for(int i=0;i<num.length;i++){
            queue.offer(num[i]);
            if(queue.size()==size){
                res.add(queue.peek());
                queue.remove(num[i-size+1]);
            }
        }
        return res;
    }

    PriorityQueue<Integer> minQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxQ = new PriorityQueue<>((x,y)->Integer.compare(y,x));
    public void Insert(Integer num) {
        if(maxQ.isEmpty()) maxQ.offer(num);
        else {
            if(num<=maxQ.peek()){
                if(maxQ.size()==minQ.size()) maxQ.offer(num);
                else{
                    maxQ.offer(num);
                    minQ.offer(maxQ.poll());
                }
            }else{
                if(maxQ.size()==minQ.size()) minQ.offer(num);
                else{
                    minQ.offer(num);
                    maxQ.offer(minQ.poll());
                }
            }
        }
    }

    public Double GetMedian() {
        if(maxQ.size()==minQ.size()) return (maxQ.peek()+minQ.peek())*0.5;
        else if(maxQ.size()>minQ.size()) return maxQ.peek()*1.0;
        else return minQ.peek()*1.0;
    }
}
