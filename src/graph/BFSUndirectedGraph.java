package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSUndirectedGraph {

    private LinkedList<Integer>[] adjacencyList;
    private int edges;
    private int nodes;

    public BFSUndirectedGraph(int nodes) {
        this.nodes = nodes;
        this.edges = 0;
        adjacencyList = new LinkedList[nodes];

        for(int i=0; i<nodes; i++)
            adjacencyList[i] = new LinkedList();
    }

    public void addEdge(int node1, int node2) {
        adjacencyList[node1].add(node2);
        adjacencyList[node2].add(node1);
        edges++;
    }

    public void display() {

        for(int i=0; i<nodes; i++) {

            System.out.print("Node " + i + ": ");

            for(int j=0; j<adjacencyList[i].size(); j++)
                System.out.print(adjacencyList[i].get(j) + " ");

            System.out.println();
        }
    }

    public void BFS(int s) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodes];

        queue.offer(s);
        visited[s] = true;

        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println(u);
            for(int v : adjacencyList[u]) {
                if(!visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }
    }

    public static void main(String[] ags) {

        BFSUndirectedGraph graph = new BFSUndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(2, 4);

        graph.display();
        graph.BFS(2);
    }
}
