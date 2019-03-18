package Directed_Graphs;

import edu.princeton.cs.algs4.DepthFirstOrder;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;

public class ReachableVertexDigraph {
    private boolean[] marked;
    private int[] id;
    private int count;
    private int resultVertex;

    public ReachableVertexDigraph (Digraph G) {
        resultVertex = -1;
        marked = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;
        DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());
        for (int v: dfs.reversePost()) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
        if (count == 1) {	//all vertices are strongCC
            resultVertex = 0;
            return;
        }
        for (int s = 0; s < G.V(); s++) {
            if (id[s] == count - 1) {
                int count_traverse = bfs(G.reverse(), s);
                if (count_traverse == G.V()) {
                    resultVertex = s;
                    break;
                }
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
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

}
