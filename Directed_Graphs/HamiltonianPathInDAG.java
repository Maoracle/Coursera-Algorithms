package Directed_Graphs;

import edu.princeton.cs.algs4.Queue;

public class HamiltonianPathInDAG {
    private boolean hasHamiltonPath;
    private DepthFirstOrder dfs;

    public HamiltonianPathInDAG(Digraph G) {
        hasHamiltonPath = true;
        Queue<Integer> q = new Queue<>();
        dfs = new DepthFirstOrder(G);
        for (int v: dfs.reversePost()) {
            q.enqueue(v);
        }
        int v = q.dequeue();
        while (!q.isEmpty()) {
            boolean flag = false;
            int w = q.dequeue();
            for (int x: G.adj(v)) {
                if (x == w) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                hasHamiltonPath = false;
                return;
            }
            v = w;
        }
    }

    public boolean hasHamiltonPath() {
        return hasHamiltonPath;
    }

    public Iterable<Integer> HamiltonPath() {
        if (!hasHamiltonPath) {
            return null;
        }
        return dfs.reversePost();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
