package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


/**
 *          0------1            4
 *          |      |            |       6
 *          |      |            |
 *          3      2            5
 *
 *      these are components of a graph
 *      connected graphs are as  [{0,1,2,3}, {4,5}, {6}] and total are 3
 *
 *      we can find i this problem whether two nodes are connected or not
 * */

public class ConnectedComponentsUndirectedGraph {

    private LinkedList<Integer>[] adjacencyList;
    private int edges;
    private int nodes;
    private int connectedCount;
    private int[] componentId;

    public ConnectedComponentsUndirectedGraph(int nodes) {
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

    /**  For recursive call */
    public void DFS() {
        boolean[] visited = new boolean[nodes];
        componentId = new int[nodes];
        connectedCount = 0;

        for(int i=0; i<nodes; i++)      // required for unconnected graph nodes
            if(!visited[i]) {
                DFS(i, visited);
                connectedCount++;
            }
    }

    public void DFS(int u, boolean[] visited) {

        System.out.println(u);
        visited[u] = true;
        componentId[u] = connectedCount;

        for(int v: adjacencyList[u]){
            if(!visited[v])
                DFS(v, visited);
        }
    }

    public int getConnectedGraphs() {
        return connectedCount;
    }

    public boolean isNodesConnected(int u, int v) {
        return componentId[u] == componentId[v];
    }

    public static void main(String[] ags) {

        ConnectedComponentsUndirectedGraph graph = new ConnectedComponentsUndirectedGraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        //graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(5, 4);

        //graph.display();
        //graph.DFS(0);
        graph.DFS();

        System.out.println("Coponents array: " + Arrays.toString(graph.componentId));
        System.out.println("Number of connected tress: " + graph.connectedCount);
        System.out.println("Nodes are connecter? : " + graph.isNodesConnected(2,3));
        System.out.println("Nodes are connecter? : " + graph.isNodesConnected(2,4));
    }
}
