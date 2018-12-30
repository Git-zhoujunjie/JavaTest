package LearningAlgorithmInterestingly.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 最长公共子序列 {
    private static final int MAXN = 1000;
    private int[][] c = new int[MAXN][MAXN];
    private int[][] b = new int[MAXN][MAXN];
    String str1;
    String str2;
    int len1;
    int len2;

    void LCS(){
        len1 = str1.length();
        len2 = str2.length();

        for(int i = 0;i<=len1;i++){
            c[i][0] = 0;
        }
        for(int j=0;j<=len2;j++){
            c[0][j] = 0;
        }
        for(int i = 1;i<=len1;i++){
            for (int j = 1;j<=len2;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 1;
                }
                else {
                    if(c[i][j-1]>=c[i-1][j]){
                        c[i][j] = c[i][j-1];
                        b[i][j] = 2;
                    }
                    else{
                        c[i][j] = c[i-1][j];
                        b[i][j] = 3;
                    }
                }
            }
        }
    }
    int[] arr = new int[MAXN];
    void LCS2(){
        int topleft,nexttopleft;
        for(int i = 0;i<=str2.length();i++) arr[i] = 0;
        for(int i = 1;i<=str1.length();i++){
            topleft = arr[i-1];
            for(int j =1;j<=str2.length();j++){
                nexttopleft = arr[j];
                if(str1.charAt(i-1) == str2.charAt(j-1)) arr[j] = topleft + 1;
                else arr[j] = Math.max(arr[j-1],arr[j]);

                topleft = nexttopleft;
            }
        }
    }

    void print(int i,int j) {
        if (i == 0 || j == 0) return;
        if (b[i][j] == 1) {
            print(i - 1, j - 1);
            System.out.print(str1.charAt(i-1));
        } else if (b[i][j] == 2) print(i, j-1);
        else print(i-1,j);

    }

    /*
    ABCADAB
    BACDBA
     */
    public static void main(String[] args) throws IOException {
        最长公共子序列 test = new 最长公共子序列();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = buf.readLine();
        String str2 = buf.readLine();
        test.str1 = str1;
        test.str2 = str2;

        test.LCS();
        System.out.println("最长公共子序列长度为："+ test.c[test.len1][test.len2]);
        test.print(test.len1,test.len2);
        System.out.println();
        test.LCS2();
        System.out.println("最长公共子序列长度为："+ test.arr[str2.length()]);

    }
}
