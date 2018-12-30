package LearningAlgorithmInterestingly.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//编辑距离：一个字符串转换为另一个字符串的最短操作
/*
关系有：
1、一个字符串X的长度i为0时，编辑距离d[i][j]就是另一个字符串Y的长度j
2、当X[i]=Y[j]时，则有d[i][j]=d[i-1][j-1]
3、当X[i]!=Y[j]时，则d[i][j]=Min(d[i-1][j]+1,d[i][j-1]+1,d[i-1][j-1]+1) (第一个是删除，第二个是插入，第三个是替换)
 */
public class EditDistance {
    //递归思路
    int editDis(String s1,int i,String s2,int j){
        if(i==0 || j==0)
            return Math.max(i,j);
        if(s1.charAt(i) == s2.charAt(j)) return editDis(s1,i-1,s2,j-1);
        else return Math.min(
                editDis(s1,i-1,s2,j)+1,
                Math.min(editDis(s1,i,s2,j-1)+1,
                        editDis(s1,i-1,s2,j-1)+1)
        );
    }

    //动态规划思路
    private static final int MAXN = 100;
    private int[][] d = new int[MAXN][MAXN];

    void editDis2(String s1,String s2){   //方法一：两重循环，空间复杂度O(n^2)
        for(int i=0;i<=s1.length();i++){
            d[i][0] = i;   //初始化第一列
        }
        for(int j=0;j<=s2.length();j++){
            d[0][j] = j;   //初始化第一行
        }
        for(int i = 1;i<=s1.length();i++){
            for(int j = 1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) d[i][j] = d[i-1][j-1];
                else{
                    d[i][j] = Math.min(d[i-1][j-1]+1,
                            Math.min(d[i][j-1]+1,d[i-1][j]+1));
                }
            }
        }
    }
    int[] arrpre = new int[MAXN];  //保存上一行元素
    int[] arrnow = new int[MAXN];  //保存当前行元素
    void editDis22(String s1,String s2){      //空间复杂度为O(2n)
        for(int i = 0;i<=s2.length();i++) arrpre[i] = i;  //初始化第一行
        for(int i = 1;i<=s1.length();i++){
            arrnow[0] = i; //每次换行时，初始化arrnow数组的第一个元素
            for(int j = 1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) arrnow[j] = arrpre[j-1];
                else{
                    arrnow[j] = Math.min(arrpre[j]+1,Math.min(arrpre[j-1]+1,arrnow[j-1]+1));
                }
            }
            for(int j = 0;j<=s2.length();j++){  //更新arrpre
                arrpre[j] = arrnow[j];
            }
        }

    }
    int[] arr = new int[MAXN];   //可以仅用一个数组保存，空间复杂度可降为O(n)
    void editDis23(String s1,String s2){
        int topleft,nexttopleft; // topleft表示当前格子左上角元素的值，nexttopleft暂存下一个格子左上角的值
        for(int i = 0;i<=s2.length();i++) arr[i] = i;  //初始化第一行
        for(int i =1;i<=s1.length();i++){
            topleft = arr[0];  //topleft的起点位置
            arr[0] = i;   //每次换行更新第一个元素
            for(int j =1;j<=s2.length();j++){
                nexttopleft = arr[j]; //下一个元素左上角的值

                if(s1.charAt(i-1) == s2.charAt(j-1)) arr[j] = topleft;
                else{
                    arr[j] = Math.min(topleft+1,
                            Math.min(arr[j]+1,  //这个arr[j]还未更新，指的是当前格子上方的值
                                    arr[j-1]+1)); //这个arr[j-1]已经更新，指的是当前格子左方的值
                }

                topleft = nexttopleft; //更新topleft
            }
        }
    }

    void process(String s1,int i,String s2,int j){   //如果要输出变换过程，则只能用editDis2()
        if(i==0 || j==0) return;
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            process(s1,i-1,s2,j-1);
        }
        else{
            //看它来自哪个方向
            if(d[i-1][j-1]+1 == d[i][j]) {
                process(s1, i - 1, s2, j - 1);
                System.out.println("将s1的第"+i+"位 " + s1.charAt(i-1) + " 替换为 " + s2.charAt(j-1));
            }
            else if(d[i-1][j]+1 == d[i][j]) {  //来自上方，说明需要删除
                process(s1,i-1,s2,j);
                System.out.println("将s1的第"+i+"位 " +s1.charAt(i-1)+"删除");
            }
            else if(d[i][j-1]+1 == d[i][j]) {  //来自左方，说明需要插入
                process(s1,i,s2,j-1);
                System.out.println("在s1的第"+i+"位 " +"插入"+s2.charAt(j-1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String s1 = buf.readLine();
        String s2 = buf.readLine();


        EditDistance test = new EditDistance();
        System.out.println("(递归):s1和s2的编辑距离为："+ test.editDis(s1,s1.length()-1,s2,s2.length()-1));

        test.editDis2(s1,s2);
        System.out.println("(动态规划O(n^2)):s1和s2的编辑距离为："+ test.d[s1.length()][s2.length()]);
        test.editDis22(s1,s2);
        System.out.println("(动态规划O(2n)):s1和s2的编辑距离为："+ test.arrnow[s2.length()]);
        test.editDis23(s1,s2);
        System.out.println("(动态规划O(n)):s1和s2的编辑距离为："+ test.arr[s2.length()]);

        System.out.println("对s1字符串的操作为：");
        test.process(s1,s1.length(),s2,s2.length());
    }
}
