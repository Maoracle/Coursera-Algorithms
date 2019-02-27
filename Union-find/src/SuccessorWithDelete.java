import edu.princeton.cs.algs4.StdOut;

public class SuccessorWithDelete {
    private boolean data[]; // data[i] == false if removed
    private UFWithFindLargest uf; // used to find largest unremoved element
    private int N; // N integers in S

    public SuccessorWithDelete(int N) {
        this.N = N;
        data = new boolean[N];
        for (int i = 0; i < N; ++i){
            data[i] = true;
        }
        uf = new UFWithFindLargest(N);
    }

    public void remove(int x) {
        data[x] = false;
        if (x > 0 && !data[x-1])
            uf.union(x, x-1);
        if (x < N - 1 && !data[x+1])
            uf.union(x, x+1);
    }

    public int successor(int x) {
        if (data[x]) {
            return x;
        } else {
            int res = uf.find(x) + 1;
            if (res >= N) {
                StdOut.println("Error, no successor can be found");
                return -1;
            } else {
                return res;
            }
        }
    }

    public static void main(String[] args) {
        SuccessorWithDelete test = new SuccessorWithDelete(10);
        test.remove(2);
        StdOut.println(test.successor(2) == 3);
        test.remove(3);
        StdOut.println(test.successor(2) == 4);
        StdOut.println(test.successor(8) == 8);
        test.remove(8);
        StdOut.println(test.successor(8) == 9);
        test.remove(9);
        StdOut.println(test.successor(8) == -1);
        test.remove(5);
        test.remove(4);
        StdOut.println(test.successor(3) == 6);
    }
}