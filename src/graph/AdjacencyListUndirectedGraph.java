package graph;

import java.util.LinkedList;

public class AdjacencyListUndirectedGraph {

    private LinkedList<Integer>[] adjacencyList;
    private int edges;
    private int nodes;

    public AdjacencyListUndirectedGraph(int nodes) {
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

    public static void main(String[] ags) {

        AdjacencyListUndirectedGraph graph = new AdjacencyListUndirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        graph.display();
    }
}
