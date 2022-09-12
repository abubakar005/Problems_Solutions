package ing;

import java.util.Arrays;
import java.util.LinkedList;

public class DirectedGraph {

    public static boolean solution(int[] A, int[] B) {
        Graph graph = new Graph(A.length);
        for(int i=0; i<A.length; i++){
            graph.addEdge(A[i], B[i]);
        }

        return isCycle(0, graph);
    }

    private static boolean dfs(int startNode, Graph graph, int node, Boolean[] visited) {
        if(visited[node])
            return true;
        visited[node] = true;
        boolean isCycle = false;

        for(int edge : graph.getEdges()[node]) {
            isCycle = dfs(startNode, graph, edge, visited);
            if(isCycle && node==startNode) {
                return true;
            }
        }
        visited[node] = false;
        return false;
    }
    private static boolean isCycle(int node, Graph graph) {
        boolean isCycle = false;
        Boolean[] visited = new Boolean[graph.getVertices()];
        Arrays.fill(visited, false);

//            visited[node] = true;
        for(int edge : graph.getEdges()[node]) {
            isCycle = dfs(node, graph, edge, visited);
            if(isCycle) {
                if(!Arrays.asList(visited).contains(false))
                    return true;
                else {
                    break;
                }
            }
        }
        Arrays.fill(visited, false);

        return false;
    }

    public static void main(String[] args) {
//        int[] A = {3, 1, 2};
//        int[] B = {2, 3, 1};

        int[] A = {1, 2, 3};
        int[] B = {2, 3, 3};

//        int[] A = {1, 2, 3, 4};
//        int[] B = {2, 1, 4, 4};

//        int[] A = {1, 2, 3, 4};
//        int[] B = {2, 1, 4, 3};

//        int[] A = {1, 2, 2, 3, 3};
//        int[] B = {2, 3, 3, 4, 5};

        System.out.println("answer: "+ solution(A, B));
    }

    static class Graph {

        private int vertices;   // total vertices
        private LinkedList<Integer>[] edges;

        public Graph(int size) {
            this.vertices = size;
            this.edges = new LinkedList[size];

            for(int i=0; i<size; i++) {
                this.edges[i] = new LinkedList<>();
            }
        }

        public LinkedList<Integer>[] getEdges() {
            return edges;
        }

        public void addEdge(int first, int second) {
            edges[first-1].add(second-1);
        }

        public int getVertices() {
            return vertices;
        }
    }
}



