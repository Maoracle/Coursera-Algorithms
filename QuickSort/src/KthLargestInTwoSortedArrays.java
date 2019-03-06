import java.util.ArrayList;
import java.util.List;

public class KthLargestInTwoSortedArrays {
    private static int kthLargestBase(List<Integer> arr1, List<Integer> arr2, int m, int n, int k) {
        List<Integer> sorted = new ArrayList<>(m + n);
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (arr1.get(i) < arr2.get(j)) {
                sorted.add(arr1.get(i));
                i++;
            }
            else {
                sorted.add(arr2.get(j));
                j++;
            }
        }
        while (i < m) {
            sorted.add(arr1.get(i++));
        }
        while (j < n) {
            sorted.add(arr2.get(j++));
        }
        return sorted.get(k);
    }

    private static int kthLargestBinarySearch(List<Integer> arr1, List<Integer> arr2, int m, int n,
                                              int k) {
        if (m == 0) {
            return arr2.get(k);
        }
        if (n == 0) {
            return arr1.get(k);
        }
        int mid1 = (m - 1) / 2;
        int mid2 = (n - 1) / 2;
        if (mid1 + mid2 < k) {
            if (arr1.get(mid1) > arr2.get(mid2)) {
                return kthLargestBinarySearch(arr1, arr2.subList(mid2 + 1, n), m, n - 1 - mid2,
                                              k - mid2 - 1);
            }
            else {
                return kthLargestBinarySearch(arr1.subList(mid1 + 1, m), arr2, m - 1 - mid1, n,
                                              k - mid1 - 1);
            }
        }
        else {
            if (arr1.get(mid1) > arr2.get(mid2)) {
                return kthLargestBinarySearch(arr1.subList(0, mid1), arr2, mid1, n, k);
            }
            else {
                return kthLargestBinarySearch(arr1, arr2.subList(0, mid2), m, mid2, k);
            }
        }
    }


    private static int kthLargestLogK(List<Integer> arr1, List<Integer> arr2, int m, int n, int k) {
        if (m == 0) {
            return arr2.get(k - 1);
        }
        if (n == 0) {
            return arr1.get(k - 1);
        }
        if (k == 1) {
            return (arr1.get(0) < arr2.get(0)) ? arr1.get(0) : arr2.get(0);
        }
        int curr = k / 2;

        if (m <= curr - 1) {
            if (arr1.get(m - 1) < arr2.get(curr - 1)) {
                return arr2.get(k - m - 1);
            }
            else {
                return kthLargestLogK(arr1, arr2.subList(curr, n), m, n - curr, k - curr);
            }
        }
        else if (n <= curr - 1) {
            if (arr2.get(n - 1) < arr1.get(curr - 1)) {
                return arr1.get(k - n - 1);
            }
            else {
                return kthLargestLogK(arr1.subList(curr, m), arr2, m - curr, n, k - curr);
            }
        }
        else {
            if (arr1.get(curr - 1) < arr2.get(curr - 1)) {
                return kthLargestLogK(arr1.subList(curr, m), arr2, m - curr, n, k - curr);
            }
            else {
                return kthLargestLogK(arr1, arr2.subList(curr, n), m, n - curr, k - curr);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(2);
        arr1.add(3);
        arr1.add(6);
        arr1.add(7);
        arr1.add(9);
        List<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(1);
        arr2.add(4);
        arr2.add(8);
        arr2.add(10);

        for (int k = 1; k <= 9; k++) {
            System.out.println(kthLargestBase(arr1, arr2, 5, 4, arr1.size() + arr2.size() - k));
            System.out.println(kthLargestBinarySearch(arr1, arr2, 5, 4, arr1.size() + arr2.size() - k));
            System.out.println(kthLargestLogK(arr1, arr2, 5, 4, arr1.size() + arr2.size() - k + 1));
        }

    }
}

