package Hash_Tables;

import java.util.HashMap;

public class Interview_4_Sum {
    public static boolean exist4Sum(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int tmp = a[i] + a[j];
                if (map.containsKey(tmp) && map.get(tmp) != i) {
                    System.out.println(tmp);
                    return true;
                }
                map.put(a[i] + a[j], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {30, -40, 30, -10, 40, 0, 10, 5, -15};
        int[] arr1 = {1,3,3,4,5,6,7,8,9};
        System.out.println(exist4Sum(arr1));
    }
}
