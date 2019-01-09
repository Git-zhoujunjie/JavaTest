package Leetcode.Huawei2019;

import java.util.*;

class zuobiao {
    int x;
    int y;
    int value;

    public zuobiao(int x,int y,int v){
        this.x = x;
        this.y = y;
        this.value = v;
    }

}
public class test3{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String sZhong = in.next();
            //System.out.println(sZhong);
            String sBegin = in.next();
            String sEnd = in.next();
            int count = in.nextInt();
            String[] sarr = new String[count];
            for(int i=0;i<count;i++){
                sarr[i] = in.next();
            }
            int xb = Integer.parseInt(sBegin.substring(0,1));
            int xe = Integer.parseInt(sBegin.substring(2));
            int yb = Integer.parseInt(sEnd.substring(0,1));
            int ye = Integer.parseInt(sEnd.substring(2));

            int[][] a = init(sZhong,sBegin,sEnd,sarr);
            a[xb][xe] = 0;
            a[yb][ye] =2 ;
            ArrayList<zuobiao> arrayList = process(a,xb,xe,yb,ye);
            for(zuobiao c : arrayList){
                System.out.print("["+c.x+","+c.y+"]");
            }
            System.out.println();

        }
    }
    public static int[][] init(String s1,String s2,String s3,String[] arr){
        int a1 = Integer.parseInt(s1.substring(0,1));
        int a2 = Integer.parseInt(s1.substring(2));
        int[][] a = new int[a1+1][a2+1];
        //a[Integer.parseInt(s2.substring(0,1))][Integer.parseInt(s2.substring(0,1))]=1;
        //a[Integer.parseInt(s3.substring(0,1))][Integer.parseInt(s3.substring(0,1))]=2;
        for(int i=0;i<arr.length;i++){
            int c1 = Integer.parseInt(arr[i].substring(0,1));
            int c2 = Integer.parseInt(arr[i].substring(2));
            a[c1][c2]=1;
        }
        return a;
    }
    public static ArrayList<zuobiao> process(int[][] a,int xb,int xe,int yb,int ye){
        zuobiao p = new zuobiao(xb,xe,1); //起始点
        zuobiao q = new zuobiao(yb,ye,3);
        int row = a.length-1;
        int col = a[0].length-1;
        ArrayList<zuobiao> arrayList = new ArrayList<>();
        arrayList.add(new zuobiao(xb,xe,1));
        while(a[p.x][p.y]!=2){
            //右。下，左，上
            if((p.x+1)<=row && a[p.x+1][p.y]==0){
                p.x++;
                a[p.x][p.y] = 1;
                arrayList.add(new zuobiao(p.x,p.y,1));
                if(a[p.x][p.y]==2) break;
            }
            else if((p.y+1)<=col && a[p.x][p.y+1]==0){
                p.y++;
                a[p.x][p.y] = 1;
                arrayList.add(new zuobiao(p.x,p.y,1));
                if(a[p.x][p.y]==2) break;
            }else if((p.x-1>=0) && a[p.x-1][p.y]==0) {
                p.x--;
                a[p.x][p.y] = 1;
                arrayList.add(new zuobiao(p.x, p.y, 1));
                if(a[p.x][p.y]==2) break;
            } else if((p.y-1>=0) && a[p.x][p.y-1]==0){
                p.y--;
                a[p.x][p.y] = 1;
                arrayList.add(new zuobiao(p.x,p.y,1));
                if(a[p.x][p.y]==2) break;
            }
        }
        return arrayList;
    }
}
