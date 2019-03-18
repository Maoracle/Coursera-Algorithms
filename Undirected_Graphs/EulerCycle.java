package Undirected_Graphs;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;


public class EulerCycle {
    private boolean isEulerCycle;
    private Stack<Integer> cycle;

    private static class Edge {
        private final int v;
        private final int w;
        private boolean isUsed;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
            isUsed = false;
        }


        public int other(int v) {
            if (this.v == v) {
                return this.w;
            } else if (this.w == v) {
                return this.v;
            } else {
                throw new IllegalArgumentException("Illegal endpoint");
            }
        }
    }

    public EulerCycle(Graph G) {
        isEulerCycle = true;
        for (int v = 0; v < G.V(); v++) {
            if (Graph.degree(G, v) % 2 == 1) {
                isEulerCycle = false;
                return;
            }
        }
        // create local view of adjacency lists of edges
        Queue<Edge>[] adj = (Queue<Edge>[]) new Queue[G.V()];
        for (int v = 0; v < G.V(); v++) {
            adj[v] = new Queue<>();
        }
        for (int v = 0; v < G.V(); v++) {
            int selfLoop = 0;
            for (int w: G.adj(v)) {
                if (w == v) {
                    if (selfLoop == 0) {
                        Edge edge = new Edge(v, w);
                        adj[v].enqueue(edge);
                        adj[w].enqueue(edge);
                    }
                    selfLoop++;
                } else if (v < w) {
                    Edge edge = new Edge(v, w);
                    adj[v].enqueue(edge);
                    adj[w].enqueue(edge);
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        cycle = new Stack<>();
        while (!stack.isEmpty()) {
            int v = stack.pop();
            while (!adj[v].isEmpty()) {
                Edge edge = adj[v].dequeue();
                if (edge.isUsed) {
                    continue;
                }
                edge.isUsed = true;
                stack.push(v);
                v = edge.other(v);
            }
            cycle.push(v);
        }
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public boolean hasEulerianCycle() {
        return isEulerCycle;
    }
}
