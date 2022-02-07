package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortestReachInGraph_HackerRank {

    public static class Graph {

        private LinkedList<Integer>[] adjacencyList;
        private int edges;
        private int nodes;

        public Graph(int size) {
            this.nodes = size;
            this.adjacencyList = new LinkedList[size];

            for(int i=0; i<size; i++)
                adjacencyList[i] = new LinkedList<>();
        }

        public void addEdge(int first, int second) {
            adjacencyList[first].add(second);
            adjacencyList[second].add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed

            int[] response = new int[nodes];
            Arrays.fill(response, -1);

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[nodes];
            int distance = 6;

            queue.offer(startId);
            visited[startId] = true;

            Queue<Integer> temp = new LinkedList<>();

            while(!queue.isEmpty()) {

                int u = queue.poll();

                for(int v : adjacencyList[u]) {
                    if(!visited[v]) {
                        temp.offer(v);
                        visited[v] = true;
                        response[v] = distance;
                    }
                }

                if(queue.isEmpty()) {
                    queue = temp;
                    distance += 6;
                    temp = new LinkedList<>();
                }
            }

            return response;
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
