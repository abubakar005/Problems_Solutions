package graph;

public class AdjacencyMatrixUndirectedGraph {

    int[][] adjacencyMatrix;

    public AdjacencyMatrixUndirectedGraph(int nodes) {
        adjacencyMatrix = new int[nodes][nodes];
    }

    public void addEdge(int node1, int node2) {
        adjacencyMatrix[node1][node2] = 1;
        adjacencyMatrix[node2][node1] = 1;
    }

    public void display() {

        for(int i=0; i<adjacencyMatrix.length; i++) {

            for(int j=0; j<adjacencyMatrix[i].length; j++)
                System.out.print(adjacencyMatrix[i][j] + " ");

            System.out.println();
        }
    }

    public static void main(String[] ags) {

        AdjacencyMatrixUndirectedGraph graph = new AdjacencyMatrixUndirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        graph.display();
    }
}
