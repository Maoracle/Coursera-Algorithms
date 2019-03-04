public class CountingInversions {
    private static int invCount;

    public static int getInvCount(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
        return invCount;
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (lo < hi){
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            if (!less(a[mid + 1], a[mid])){
                return;
            }
            merge(a, aux, lo, mid, hi);
        }
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for (int i = lo; i <= hi; i++){
            aux[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++){
            if (i > mid){
                a[k] = aux[j];
                j++;
            }
            else if (j > hi){
                a[k] = aux[i];
                i++;
            }
            else if (less(a[j], aux[i])){
                invCount += (mid - i + 1);
                a[k] = aux[j];
                j++;
            }
            else {
                a[k] = aux[i];
                i++;
            }
        }
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
