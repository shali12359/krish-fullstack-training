public class Main {
    public static void main(String args[]) {
        // BFS TRAVERSAL
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Breadth First Traversal: ");
        g.BFS(2);
        System.out.println();

        // DFS TRAVERSAL
        Graph2 g2 = new Graph2(6);

        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 0);
        g2.addEdge(1, 3);
        g2.addEdge(2, 0);
        g2.addEdge(2, 3);
        g2.addEdge(3, 4);
        g2.addEdge(3, 5);
        g2.addEdge(4, 3);
        g2.addEdge(5, 3);

        System.out.println("Depth First Traversal: ");

        g2.DFS(0);
    }
}