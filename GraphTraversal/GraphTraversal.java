package GraphTraversal;

import java.util.*;

public class GraphTraversal {

    // Implementation of a weighted directed graph using a HashMap
    private HashMap<String, HashMap<String, Integer>> graph;

    public GraphTraversal() {
        this.graph = new HashMap<String, HashMap<String, Integer>>();
    }

    // Method to add a node to the graph
    public void addNode(String node) {
        graph.put(node, new HashMap<String, Integer>());
    }

    // Method to add a weighted edge between two nodes in the graph
    public void addEdge(String node1, String node2, int weight) {
        graph.get(node1).put(node2, weight);
    }

    // Breadth-first search algorithm
    public void bfs(String start) {
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.remove();
            System.out.print(current + " ");

            for (String neighbor : graph.get(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Depth-first search algorithm
    public void dfs(String start) {
        HashSet<String> visited = new HashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            System.out.print(current + " ");

            for (String neighbor : graph.get(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
    }

    // Dijkstra's shortest path algorithm
    public void dijkstra(String start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        HashMap<String, Integer> dist = new HashMap<String, Integer>();

        for (String node : graph.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(start, 0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.remove();

            for (String neighbor : graph.get(current.label).keySet()) {
                int distance = dist.get(current.label) + graph.get(current.label).get(neighbor);
                if (distance < dist.get(neighbor)) {
                    dist.put(neighbor, distance);
                    pq.add(new Node(neighbor, distance));
                }
            }
        }

        for (String node : graph.keySet()) {
            System.out.println("Shortest distance from " + start + " to " + node + ": " + dist.get(node));
        }
    }

    // Helper class for Dijkstra's algorithm
    private class Node implements Comparable<Node> {
        private String label;
        private int distance;

        public Node(String label, int distance) {
            this.label = label;
            this.distance = distance;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "E", 3);
        graph.addEdge("D", "E", 4);

//        System.out.print("BFS traversal: ");
//        graph.bfs("A");
//        System.out.println();
//
//        System.out.print("DFS traversal: ");
//        graph.dfs("A");
//        System.out.println();

        System.out.println("Shortest paths from A using Dijkstra's algorithm:");
        graph.dijkstra("A");
    }
}
