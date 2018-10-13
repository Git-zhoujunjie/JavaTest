package DataStructureAndAlgorithmAnalysis;

public class test {
    public static void main(String[] args) {
        int a[] = {2, 3, 4};
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * Math.pow(10,i);
        }
        System.out.println(sum);
    }
}
