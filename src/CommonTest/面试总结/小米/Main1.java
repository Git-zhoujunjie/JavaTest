package CommonTest.面试总结.小米;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/6 19:41
 */
public class Main1 {

    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int solution(int[] prices, int budget) {
//
//        int[][] min = new int[prices.length][budget+1];
//
//        min[0][0]=0;
//        for(int i=0; i<prices.length; i++) {
//            for(int j=0; j<=prices.length; j++) {
//                min[i][j] = i==0? budget : min[i-1][j];
//                if(j-prices[i] >= 0) {
//                    min[i][j]=Math.min(min[i-1][j-prices[i]]+1, min[i][j]);
//                }
//            }
//        }
//        return min[prices.length-1][budget];

        Arrays.sort(prices);
        int cnt = 0;
        int n=0;
        for(int i=prices.length-1;i>=0;i++){
            if(budget>=prices[i]){
                n = budget/prices[i];
                budget = budget - n*prices[i];
                cnt += n;
                if(budget==0)  break;
            }
        }
        if(budget!=0) return -1;
        return cnt;
    }


    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
