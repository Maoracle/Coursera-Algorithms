import edu.princeton.cs.algs4.StdRandom;

public class MergeWithSmallerAuxArray {
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length/2];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (lo < hi){
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            if (!less(a[mid + 1], a[mid])) {
                return;
            }
            merge(a, aux, lo, mid, hi);
        }
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for (int i = lo; i <= mid; i++){
            aux[i - lo] = a[i];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++){
            if (i > mid){
                return;
            }
            else if (j > hi){
                a[k] = aux[i - lo];
                i++;
            }
            else if (less(a[j], aux[i - lo])){
                a[k] = a[j];
                j++;
            }
            else {
                a[k] = aux[i - lo];
                i++;
            }
        }
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        int N = 6;

        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }

        StdRandom.shuffle(a);
        System.out.println("Array of Integers before sorting:");
        print(a);
        MergeWithSmallerAuxArray.sort(a);
        System.out.println("Array of Integers after sorting:");
        print(a);
    }

    public static void print(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            System.out.print(a[i].toString() + " ");
        }
        System.out.println();
    }
}
