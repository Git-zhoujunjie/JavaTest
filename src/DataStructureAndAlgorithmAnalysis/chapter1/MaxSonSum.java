package DataStructureAndAlgorithmAnalysis.chapter1;

public class MaxSonSum {
    public static int funmax1(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int maxSum2 = 0;
                for (int k = i; k < j; k++) {
                    maxSum2 += a[k];
                    if (maxSum < maxSum2) maxSum = maxSum2;
                }
            }
        }
        return maxSum;
    }

    // [4,-3,5,-2,-1,2,6,-2]
    public static int funmax2(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int maxSum2 = 0;
            for (int j = i; j < a.length; j++) {
                maxSum2 += a[j];
                if (maxSum < maxSum2) maxSum = maxSum2;
            }
        }
        return maxSum;
    }

    public static int funmax3(int[] a, int left, int right) {
        if (left == right) {
            if (a[left] > 0) return a[left];
            else return 0;
        }

        int center = (left + right) / 2;
        int maxLeftSum = funmax3(a, left, center);
        int maxRightSum = funmax3(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, RightBorderSum = 0;
        for (int i = center+1; i <=right; i++) {
            RightBorderSum += a[i];
            if (RightBorderSum > maxRightBorderSum)
                maxRightBorderSum = RightBorderSum;
        }

        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    static int max3(int a, int b, int c) {
        if (a > b) {
            if (a > c) return a;
            else return c;
        } else {
            if (b > c) return b;
            else return c;
        }
    }

    public static int funmax4(int[] a) {
        int maxSum = 0;
        int maxSum2 = 0;

        for (int i = 0; i < a.length; i++) {
            maxSum2 += a[i];

            if (maxSum2 > maxSum) maxSum = maxSum2;
            else if (maxSum2 < 0) maxSum2 = 0;

        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] a = {4,-3,5,-2,-1,2,6,-2};
        System.out.println("方法一：" + funmax1(a));
        System.out.println("方法二：" + funmax2(a));
        System.out.println("方法三（分治法）：" + funmax3(a,0,a.length-1));
        System.out.println("方法四（最优）:" + funmax4(a));
    }
}
