import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int N;

    public RandomizedQueue(){
        queue = (Item[]) new Object[2];
        N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        if (item == null) throw new NullPointerException();

        if (N == queue.length) resize(2 * queue.length);
        queue[N] = item;
        N++;
    }

    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException();

        int idx = StdRandom.uniform(N);
        Item item = queue[idx];
        queue[idx] = null;
        exch(queue, idx, N - 1);
        N--;
        if (N > 0 && N == queue.length /4) resize(queue.length/2);
        return item;
    }

    public Item sample(){
        if (isEmpty()) throw new NullPointerException();

        int idx =StdRandom.uniform(N);
        return queue[idx];
    }

    public Iterator<Item> iterator(){
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item[] randomQueue;
        private int currentIdx;

        public RandomizedQueueIterator(){
            randomQueue = (Item[]) new Object[N];
            for (int i = 0; i < N; i++){
                randomQueue[i] = queue[i];
            }
            shuffle(randomQueue);
            currentIdx = 0;
        }
        public boolean hasNext(){
            return currentIdx < randomQueue.length;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();

            Item item = randomQueue[currentIdx];
            currentIdx++;
            return item;
        }

        private void shuffle(Item[] arr){
            for (int i = 1; i < arr.length; i++){
                int idx = StdRandom.uniform(i + 1);
                exch(arr, idx, i);
            }
        }
    }

    private void resize(int cap){
        Item[] copy = (Item[]) new Object[cap];
        for (int i = 0; i < N; i++){
            copy[i] = queue[i];
        }
        queue = copy;
    }
    private void exch(Item[] arr, int i, int j){
        if (i == j) return;
        Item temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
