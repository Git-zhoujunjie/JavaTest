package DataStructureAndAlgorithmAnalysis.chapter1;

public class BinarySearch {
    public static int binarySearch(int[] a, int x) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] < x) low = mid + 1;
            else if (a[mid] > x) high = mid - 1;
            else return mid;
        }

        return -1;
    }
}
