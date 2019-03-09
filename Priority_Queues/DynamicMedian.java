package Priority_Queues;

public class DynamicMedian {
    private HeapMaxPQ<Integer> lessThan = null;
    private HeapMinPQ<Integer> moreThan = null;

    public DynamicMedian(int a, int b){
        lessThan = new HeapMaxPQ<>(100);
        moreThan = new HeapMinPQ<>(100);
        if (a <= b){
            lessThan.insert(a);
            moreThan.insert(b);
        } else {
            lessThan.insert(b);
            moreThan.insert(a);
        }
    }

    public double findMedium(){
        int l = lessThan.size();
        int m = moreThan.size();
        if (l == m){
            return (lessThan.max() + moreThan.min()) / 2;
        } else if (l > m){
            return lessThan.max();
        } else {
            return moreThan.min();
        }
    }

    public void insert(int key){
        int l = lessThan.size();
        int m = moreThan.size();
        double medium = findMedium();
        if (key <= medium){
            lessThan.insert(key);
            if (l - m >= 2){
                moreThan.insert(lessThan.delMax());
            }
        }else {
            moreThan.insert(key);
            if (m - l >= 2){
                lessThan.insert(moreThan.delMin());
            }
        }
    }

    public int delMedium(){
        int l = lessThan.size();
        int m = moreThan.size();
        if (l > m){
            return lessThan.max();
        } else {
            return moreThan.min();
        }
    }

    public static void main(String[] args){
        DynamicMedian pq = new DynamicMedian(11, 12);
        pq.insert(2);
        System.out.println(pq.findMedium());
        pq.insert(3);
        pq.insert(1);
        pq.insert(7);
        pq.insert(8);
        System.out.println(pq.findMedium());
    }
}
