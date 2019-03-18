package Undirected_Graphs;

public class Diameter {
    private BreadthFirstPaths bfs;
    private int farest;

    public Diameter(Graph G) {
        findFarest(G, 0);
        findFarest(G, farest);
    }

    private void findFarest(Graph G, int s) {
        bfs = new BreadthFirstPaths(G, s);
        int maxDist = 0;
        for (int v = 0; v < G.V(); v++) {
            if (bfs.distTo(v) > maxDist) {
                maxDist = bfs.distTo(v);
                farest = v;
            }
        }
    }

    public Iterable<Integer> longestPath() {
        return bfs.pathTo(farest);
    }
}
