package Directed_Graphs;

import edu.princeton.cs.algs4.Queue;

public class ReachableVertexDAG {
    private int resultVertex;

    public ReachableVertexDAG(Digraph G) {
        resultVertex = -1;
        for (int s = 0; s < G.V(); s++) {
            if (G.outdegree(s) == 0) {
                int count = bfs(G.reverse(), s);
                if (count == G.V()) {
                    resultVertex = s;
                    break;
                }
            }
        }
    }

    private int bfs(Digraph G, int s) {
        boolean[] marked = new boolean[G.V()];
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(s);
        marked[s] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w: G.adj(v)) {
                if (!marked[w]) {
                    q.enqueue(w);
                    marked[w] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public int getVertex() {
        return resultVertex;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
