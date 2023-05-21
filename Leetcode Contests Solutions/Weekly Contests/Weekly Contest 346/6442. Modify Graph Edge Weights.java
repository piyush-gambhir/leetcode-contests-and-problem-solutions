/*
Problem Link: https://leetcode.com/contest/weekly-contest-346/problems/modify-graph-edge-weights/
*/

import java.util.*;

class Solution {

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {

        // Create a graph data structure to store the edges.
        Graph graph = new Graph(n);

        // Add all the edges to the graph.
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1], edge[2]);
        }

        // Find the shortest path from the source node to the destination node.
        int[] shortestPath = graph.shortestPath(source, destination);

        // If the shortest path does not exist, then return an empty array.
        if (shortestPath == null) {
            return new int[0][0];
        }

        // Find the difference between the desired target distance and the actual shortest path distance.
        int difference = target - shortestPath[destination];

        // For each edge with a weight of -1, add the difference to the weight.
        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] += difference;
            }
        }

        // Return the modified edges.
        return edges;
    }

}

class Graph {

    private int n;
    private List<List<Edge>> adjList;

    public Graph(int n) {
        this.n = n;
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int w) {
        adjList.get(u).add(new Edge(u, v, w));
        adjList.get(v).add(new Edge(v, u, w));
    }

    public int[] shortestPath(int source, int destination) {

        // Create a distance array to store the distances from the source node to all other nodes.
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Create a visited array to store whether a node has been visited or not.
        boolean[] visited = new boolean[n];

        // Create a queue to store the nodes that are currently being processed.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {

            // Get the next node from the queue.
            int u = queue.poll();

            // If the current node is the destination node, then return the distance array.
            if (u == destination) {
                return distance;
            }

            // Mark the current node as visited.
            visited[u] = true;

            // For each neighbor of the current node, update the distance if necessary.
            for (Edge edge : adjList.get(u)) {
                if (!visited[edge.v] && distance[edge.v] > distance[u] + edge.w) {
                    distance[edge.v] = distance[u] + edge.w;
                    queue.add(edge.v);
                }
            }
        }

        // The destination node is not reachable from the source node.
        return null;
    }

}

class Edge {

    int u;
    int v;
    int w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

}
