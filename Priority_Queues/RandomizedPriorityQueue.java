package Priority_Queues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

public class RandomizedPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n = 0;

    public RandomizedPriorityQueue(int n){
        pq = (Key[]) new Comparable[n + 1];
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public Key sample(){
        if (isEmpty()){
            throw new NoSuchElementException("Priority queue underflow");
        }
        int random = StdRandom.uniform(n) + 1;
        return pq[random];
    }

    public void insert(Key x){
        pq[++n] = x;
        swim(n);
    }

    public Key delRandom(){
        if (isEmpty()){
            throw new NoSuchElementException("Priority queue underflow");
        }
        int random = StdRandom.uniform(n) + 1;
        Key sample = pq[random];
        exch(random, n--);
        swim(random);
        sink(random);
        pq[n + 1] = null;
        return sample;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j = j + 1;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RandomizedPriorityQueue<Integer> pq = new RandomizedPriorityQueue<>(20);
        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        pq.insert(4);
        pq.insert(5);
        pq.insert(6);
        System.out.println(pq.delRandom());
        System.out.println(pq.delRandom());
        System.out.println(pq.delRandom());
        System.out.println(pq.delRandom());
        System.out.println(pq.delRandom());
        System.out.println(pq.delRandom());
        //System.out.println(pq.delRandom());
    }

}

