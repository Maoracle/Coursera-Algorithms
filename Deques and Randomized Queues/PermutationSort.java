import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdRandom;

public class PermutationSort {
    public static boolean isPermutation(Integer[] a, Integer[] b){
        if (a.length != b.length){
            return false;
        }
        Shell.sort(a);
        Shell.sort(b);
        for (Integer i = 0; i < a.length; i++){
            if (a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Integer N = 10;
        Integer[] a = new Integer[N];
        Integer[] b = new Integer[N];
        for(Integer i = 0; i < N; i++){
            a[i] = i + 1;
            b[i] = i;
        }
        StdRandom.shuffle(a);
        StdRandom.shuffle(b);

        System.out.println("Array a: ");
        for(Integer i = 0; i < N; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("Array b: ");
        for(Integer i = 0; i < N; i++){
            System.out.print(b[i] + " ");
        }
        System.out.println();

        if(PermutationSort.isPermutation(a, b)){
            System.out.println("Arrays a and b are permutations!");
        }
        else{
            System.out.println("Arrays a and b are NOT permutations!");
        }
    }
}

