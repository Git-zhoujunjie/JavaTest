package CommonTest.MyArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test44 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> l = new ArrayList<>();
            l.add(in.nextInt());
            l.add(in.nextInt());
            list.add(l);
        }
        int x = list.get(0).get(0);
        int y = list.get(0).get(1);
        for(int i=1;i<n;){
           List<Integer> ll = list.get(i);
           if(x==ll.get(0)) i++;
           else if(y==ll.get(1)) i++;
           else {

           }
        }
        System.out.println();
    }
}
