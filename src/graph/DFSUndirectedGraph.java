package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSUndirectedGraph {

    private LinkedList<Integer>[] adjacencyList;
    private int edges;
    private int nodes;

    public DFSUndirectedGraph(int nodes) {
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

    public void DFS(int s) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nodes];

        stack.push(s);
        visited[s] = true;

        while(!stack.isEmpty()) {
            int u = stack.pop();
            System.out.println(u);
            for(int v : adjacencyList[u]) {
                if(!visited[v]) {
                    stack.push(v);
                    visited[v] = true;
                }
            }
        }
    }

    /**  For recursive call */
    public void DFS() {
        boolean[] visited = new boolean[nodes];

        for(int i=0; i<nodes; i++)      // required for unconnected graph nodes
            if(!visited[i])
                DFS(i, visited);
    }

    public void DFS(int u, boolean[] visited) {

        System.out.println(u);
        visited[u] = true;

        for(int v: adjacencyList[u]){
            if(!visited[v])
                DFS(v, visited);
        }

    }

    public static void main(String[] ags) {

        DFSUndirectedGraph graph = new DFSUndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(2, 4);

        graph.display();
        //graph.DFS(0);
        graph.DFS();
    }
}
