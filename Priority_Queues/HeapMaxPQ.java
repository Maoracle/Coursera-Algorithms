package Priority_Queues;

import java.util.NoSuchElementException;

public class HeapMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n = 0;

    public HeapMaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public HeapMaxPQ(){
        this(1);
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public Key max(){
        if (isEmpty()){
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }

    public void insert(Key x){
        pq[++n] = x;
        swim(n);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        return max;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k){
        while (k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2 * k <= n){
            int j = 2 * k;
            if (j < n && less(j, j + 1)){
                j = j + 1;
            }
            if (!less(k , j)){
                break;
            }
            exch(k, j);
            k = j;
        }
    }
}
