package Undirected_Graphs;

import java.util.Iterator;
import java.util.Stack;

public class Nonrecursive_DFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public Nonrecursive_DFS(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int s) {
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
        for (int v = 0; v < G.V(); v++) {
            adj[v] = G.adj(v).iterator();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        marked[s] = true;
        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (adj[v].hasNext()) {
                int w = adj[v].next();
                if (!marked[w]) {
                    stack.push(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
            else {
                stack.pop();
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
