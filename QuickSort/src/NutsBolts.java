public class NutsBolts {
    public static void sort(Comparable[] a, Comparable[] b){
        sort(a, 0, a.length - 1, b, 0, b.length - 1);
    }

    private static void sort(Comparable[] a, int lo_a, int hi_a, Comparable[] b, int lo_b, int hi_b){
        if (hi_a <= lo_a){
            return;
        }
        if (hi_b <= lo_b){
            return;
        }
        int j_a = partition(a, lo_a, hi_a, b[lo_b]);
        int j_b = partition(b, lo_b, hi_b, a[j_a]);
        sort(a, lo_a, j_a - 1, b, lo_b, j_b - 1);
        sort(a, j_a + 1, hi_a, b, j_b + 1, hi_b);
    }

    private static int partition(Comparable[] a, int lo, int hi, Comparable v){
        int i = lo - 1;
        int j = hi + 1;
        int index = -1;
        while (true){
            while (!less(v, a[++i])){
                if (a[i].compareTo(v) == 0){
                    index = i;
                    if (i > j){
                        break;
                    }
                    continue;
                }
                if (i == hi){
                    break;
                }
            }
            while (!less(a[--j], v)){
                if (a[j].compareTo(v) == 0){
                    index = j;
                    if (i >= j){
                        break;
                    }
                    continue;
                }
                if (j == lo){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            exch(a, i, j);
        }
        if (index != -1){
            exch(a, index, j);
        }
        return j;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] nuts = new Integer[] {5, 7, 10, 2, 8, 6, 3, 9, 1, 4};
        Integer[] bolts = new Integer[] {6, 1, 8, 3, 10, 5, 7, 9, 4, 2};
        sort(nuts, bolts);
        System.out.println(isSorted(nuts));
        System.out.println(isSorted(bolts));
    }
}
