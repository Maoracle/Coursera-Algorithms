package Directed_Graphs;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Stack;

public class ShortestDirectedCycle {
    private Stack<Integer> cycle;
    private int length; 	// length of the cycle

    public ShortestDirectedCycle(Digraph G) {
        length = G.V() + 1;	// if there is no cycle, the length will be larger than the number of vertices
        for (int v = 0; v < G.V(); v++) {
            BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(G.reverse(), v);
            for (int w: G.adj(v)) {
                if (bfs.hasPathTo(w) && (bfs.distTo(w) + 1) < length) {
                    length = bfs.distTo(w) + 1;
                    cycle = new Stack<>();
                    for (int x: bfs.pathTo(w)) {
                        cycle.push(x);
                    }
                    cycle.push(v);
                }
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public int length() {
        return length;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
