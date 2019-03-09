package Priority_Queues;

import java.util.ArrayList;
import java.util.List;

public class Taxicab implements Comparable<Taxicab> {
    private int a;
    private int b;
    private int cube;

    public Taxicab(int a, int b){
        this.a = a;
        this.b = b;
        this.cube = a * a * a + b * b * b;
    }

    public int compareTo(Taxicab that){
        return this.cube - that.cube;
    }

    @Override
    public String toString() {
        return "Taxicab{" +
                "a=" + a +
                ", b=" + b +
                ", cube=" + cube +
                '}';
    }

    public static List<Taxicab> findAllTaxicabNumbers(int n){
        List<Taxicab> result = new ArrayList<>();
        HeapMinPQ<Taxicab> pq = new HeapMinPQ<>(n);
        for (int i = 1; i <= 1000; i++){
            for (int j = i + 1; j <= 1000; j++){
                Taxicab t = new Taxicab(i, j);
                if (t.cube > n){
                    break;
                }
                pq.insert(t);
            }
        }
        while (!pq.isEmpty()){
            Taxicab min = pq.delMin();
            if (!pq.isEmpty() && min.compareTo(pq.min()) == 0){
                result.add(min);
                result.add(pq.delMin());
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (Taxicab i: findAllTaxicabNumbers(200000)) {
            System.out.println(i);
        }
    }
}
