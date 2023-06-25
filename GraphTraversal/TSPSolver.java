package GraphTraversal;

import java.util.HashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class TSPSolver {

    private LinkedHashMap<String, HashMap<String, Integer>> graph;

    public TSPSolver(LinkedHashMap<String, HashMap<String, Integer>> graph) {
        this.graph = graph;
    }

    public int solveTSP(String startNode) {
        if (!graph.containsKey(startNode)) {
            throw new IllegalArgumentException("Starting node not found in graph.");
        }
        int n = graph.size();
        int[][] dp = new int[n][(1 << n)];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = -1;
            }
        }
        return tsp(startNode, 1 << new ArrayList<>(graph.keySet()).indexOf(startNode), dp);
    }

    private int tsp(String currentNode, int visited, int[][] dp) {
        if (visited == ((1 << graph.size()) - 1)) {
            if (graph.get(currentNode).containsKey("0")) {
                return graph.get(currentNode).get("0");
            }
            if (dp[new ArrayList<>(graph.keySet()).indexOf(currentNode)][visited] != -1) {
                return dp[new ArrayList<>(graph.keySet()).indexOf(currentNode)][visited];
            }
            int minCost = Integer.MAX_VALUE;
            for (String neighbor : graph.keySet()) {
                int neighborIndex = new ArrayList<>(graph.keySet()).indexOf(neighbor);
                if ((visited & (1 << neighborIndex)) == 0) {
                    int cost = graph.get(currentNode).get(neighbor) + tsp(neighbor, visited | (1 << neighborIndex), dp);
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[new ArrayList<>(graph.keySet()).indexOf(currentNode)][visited] = minCost;
            return minCost;
        } else {
            int minCost = Integer.MAX_VALUE;
            for (String neighbor : graph.keySet()) {
                int neighborIndex = new ArrayList<>(graph.keySet()).indexOf(neighbor);
                if ((visited & (1 << neighborIndex)) == 0) {
                    int cost = graph.get(currentNode).get(neighbor) + tsp(neighbor, visited | (1 << neighborIndex), dp);
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[new ArrayList<>(graph.keySet()).indexOf(currentNode)][visited] = minCost;
            return minCost;
        }

    }

    public static void main(String[] args) {
        // Example usage
        LinkedHashMap<String, HashMap<String, Integer>> graph = new LinkedHashMap<>();
        HashMap<String, Integer> a = new HashMap<>();
        a.put("B", 10);
        a.put("C", 15);
        a.put("D", 20);
        graph.put("A", a);
        HashMap<String, Integer> b = new HashMap<>();
        b.put("A", 10);
        b.put("C", 35);
        b.put("D", 25);
        graph.put("B", b);
        HashMap<String, Integer> c = new HashMap<>();
        c.put("A", 15);
        c.put("B", 35);
        c.put("D", 30);
        graph.put("C", c);
        HashMap<String, Integer> d = new HashMap<>();
        d.put("A", 20);
        d.put("B", 25);
        d.put("C", 30);
        graph.put("D", d);
        TSPSolver solver = new TSPSolver(graph);
        int minCost = solver.solveTSP("A");
        System.out.println("Minimum cost: " + minCost); // Expected output: 80
    }
}
