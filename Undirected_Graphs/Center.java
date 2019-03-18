package Undirected_Graphs;

public class Center {
    private int center;

    public Center(Graph G) {
        int start = findFarest(G, 0);
        int end = findFarest(G, start);
        BreadthFirstPaths bfs_from_start = new BreadthFirstPaths(G, start);
        BreadthFirstPaths bfs_from_end = new BreadthFirstPaths(G, end);
        center = start;
        for (int v : bfs_from_start.pathTo(end)) {
            if (bfs_from_start.distTo(v) == bfs_from_end.distTo(v)
                    || bfs_from_start.distTo(v) == bfs_from_end.distTo(v) + 1) {
                center = v;
                break;
            }
        }
    }

    private int findFarest(Graph G, int s) {
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        int maxDist = 0;
        int farest = s;
        for (int v = 0; v < G.V(); v++) {
            if (bfs.distTo(v) > maxDist) {
                maxDist = bfs.distTo(v);
                farest = v;
            }
        }
        return farest;
    }

    public int center() {
        return center;
    }
}

