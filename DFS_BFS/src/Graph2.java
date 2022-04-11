import java.util.LinkedList;

class Graph2 {
    private int V;  // NO OF VERTICES
    private LinkedList<Integer> adj[];  // ADJACENT LIST

    // CONSTRUCTOR
    public Graph2(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // METHOD FOR ADD EDGE
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int vertex, boolean nodes[]) {
        // MARK VISITED NODES
        nodes[vertex] = true;
        System.out.print(vertex + " ");
        int a = 0;

        for (int i = 0; i < adj[vertex].size(); i++) {
            a = adj[vertex].get(i);

            // GO TO NEXT NODE IF NOT EXPLORED
            if (!nodes[a]) {
                DFSUtil(a, nodes);
            }
        }
    }

    void DFS(int v){
        // ARRAY FOR HOLD VISITED NODES
        boolean already[] = new boolean[V];
        DFSUtil(v, already);
    }
}