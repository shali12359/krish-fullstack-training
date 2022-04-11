import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;   // NO OF VERTICES
    private LinkedList<Integer> adj[]; // ADJACENT LIST

    // CONSTRUCTOR
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // METHOD FOR ADD EDGE
    public void addEdge(int v,int w) {
        adj[v].add(w);
    }

    // METHOD FOR BFS TRAVERSAL
    public void BFS(int s) {
        // ARRAY FOR HOLD VISITED NODES
        boolean visited[] = new boolean[V];

        // CREATE A QUEUE
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // MARK VISITED NODES
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // DEQUEUE A VERTEX & PRINT
            s = queue.poll();
            System.out.print(s + " ");

            // GET ADJACENT VERTICES OF DEQUED VERTEX & MARK VISITED
            Iterator<Integer> i = adj[s].listIterator();

            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}