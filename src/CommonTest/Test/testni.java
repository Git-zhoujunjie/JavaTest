package CommonTest.Test;

import java.util.ArrayList;

public class testni {
    public static void main(String[] args) {
        //int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] a = {{1, 2, 3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(printMatrix(a));
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int rowb = 0;
        int colb = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int rowe = row - 1;
        int cole = col - 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (row > 2 * rowb && col > 2 * colb) {
            //从左到右
            for (int i = colb; i <= cole; i++) {
                list.add(matrix[rowb][i]);
            }
            rowb++;
            //从上到下
            for (int i = rowb; i <= rowe; i++) {
                list.add(matrix[i][cole]);
            }
            cole--;
            //从右到左
            if (rowb <= rowe) {
                for (int i = cole; i >= colb; i--) {
                    list.add(matrix[rowe][i]);
                }
            }
            rowe--;
            //从下到上
            if (cole >= colb) {
                for (int i = rowe; i >= rowb; i--) {
                    list.add(matrix[i][colb]);
                }
            }
            colb++;
        }
        return list;
    }
}
