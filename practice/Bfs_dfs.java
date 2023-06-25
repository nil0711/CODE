package practice;

import java.util.*;

public class Bfs_dfs {
    private Map<String, LinkedList<HashMap<String,Integer>>> Graph;

    public Bfs_dfs(){
        Graph=new HashMap<>();
    }

    public void addNodes(String source,String destination, int weight){
        Scanner sc = new Scanner(System.in);
        LinkedList<HashMap<String, Integer>> Edge=Graph.getOrDefault(source,new LinkedList<>());
        HashMap<String,Integer>CheckLinkList=new HashMap<>();
        CheckLinkList.put(destination,weight);
        for (HashMap<String,Integer> hashMap: Edge){
            if(hashMap.keySet().equals(CheckLinkList.keySet())){

                    Edge.remove(hashMap);
                    Edge.add(addEdge(destination,weight));
                    Graph.put(source,Edge);
                    return;
            }
        }
        Edge.add(addEdge(destination,weight));
        Graph.put(source,Edge);
        Edge.add(addEdge(source,weight));
        Graph.put(destination,Edge);

    }
    public HashMap addEdge(String destination, int weight){
        HashMap<String,Integer> vertices=new HashMap<>();

        vertices.put(destination,weight);
        return vertices;
    }
    void BFS(String startNode){
        Map<String,Boolean> visited= new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        visited.put(startNode,true);
        queue.add(startNode);
        if(!queue.isEmpty()){
            String node = queue.poll();
            System.out.print(node+" ");
            LinkedList<HashMap<String,Integer>> edges = Graph.get(node);
            for (HashMap<String,Integer> edge :edges){
                String neighbor = edge.keySet().iterator().next();
                if(!visited.containsKey(neighbor)){
                    System.out.print(neighbor+" ");
                    visited.put(neighbor,true);
                    queue.add(neighbor);
                }
            }
        }
    }

    void DSF(String startNode){
        Set<String> visited= new HashSet<>();
        dFShelper(startNode,visited);

    }
    private void dFShelper(String node, Set<String> visited){
        visited.add(node);
        System.out.print(node+" ");
        LinkedList<HashMap<String,Integer>> neighbors= Graph.get(node);
        if(neighbors!=null){
            for (HashMap<String,Integer> neighbor : neighbors){
                String nextNode = neighbor.keySet().iterator().next();
                if(!visited.contains(nextNode)){
                    dFShelper(nextNode,visited);
                }
            }
        }
    }
    int minimumSpanningTree(String A,Map<String, LinkedList<HashMap<String,Integer>>> Graph){
        Map<String, Boolean> visited = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(A,0));
        int answer = 0;
        while (!pq.isEmpty()){
            Pair current = pq.poll();
            String vertice = current.vertices;
            if (visited.containsKey(vertice)){
                continue;
            }
            System.out.print(current.vertices+" ");
            answer+=current.weight;
            visited.put(vertice,true);
            LinkedList<HashMap<String,Integer>> neighbors = Graph.get(vertice);

            for (Map<String,Integer> neighbor : neighbors){
                String vertex = null;
                int weight = 0;
                for(Map.Entry<String, Integer> entry : neighbor.entrySet()) {
                    vertex = entry.getKey();
                    weight = entry.getValue();
                }
                if(!visited.containsKey(vertex)){
                    pq.add(new Pair(vertex,weight));
                }

            }
        }
        return answer;
    }
    public Map<String, Integer> dijkstra(Map<String, LinkedList<HashMap<String, Integer>>> graph, String startNode) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Set<String> visited = new HashSet<>();

        // initialize distances to all nodes as infinity except start node
        for (String node : graph.keySet()) {
            distances.put(node, 0);
        }
        distances.put(startNode, 0);
        pq.add(new Pair(startNode,0));

        while (!pq.isEmpty()) {
            Pair currNode = pq.poll();
            String curr = currNode.vertices;
            System.out.println(curr);
            int distance = currNode.weight;
            System.out.println(distance);
            if(visited.contains(curr)){
                continue;
            }
            visited.add(curr);
            System.out.println(curr);
            LinkedList<HashMap<String, Integer>> neighbors = graph.get(curr);
            for (HashMap<String, Integer> neighbor : neighbors) {
                for (String nextNode : neighbor.keySet()) {
                    int weight = neighbor.get(nextNode);
                    System.out.println(nextNode);
                    System.out.println(weight);
                    int newDist = distance+weight;
                    System.out.println(newDist);
                    if(newDist>distances.get(nextNode)){
                        distances.put(nextNode,newDist);
                        pq.add(new Pair(nextNode,newDist));
                    }

                }
            }
        }

        return distances;
    }



    class Pair implements Comparable<Pair>{
        String vertices;
        int weight;
        Pair(String vertices,int weight){
            this.vertices=vertices;
            this.weight=weight;
        }

        @Override
        public int compareTo(Pair that) {
            return this.weight-that.weight;
        }
    }
    public void printGraph(){
        System.out.println(Graph);

    }

    public static void main(String[] args) {
        Bfs_dfs graph=new Bfs_dfs();
//        Scanner sc = new Scanner(System.in);
//        boolean direction=false;
//        System.out.println("Is the graph directed...? y/n");
//        String choice = sc.next();
//        if (choice.equalsIgnoreCase("y"))direction=true;
//        while (true){
//            System.out.println("Enter source");
//            String source=sc.next();
//            while (true){
//                System.out.println("Enter destination");
//                String destination=sc.next();
//                System.out.println("Enter weight");
//                int weight = sc.nextInt();
//                graph.addNodes(source,destination,weight);
//                if(!direction)graph.addNodes(destination,source,weight);
//                graph.printGraph(direction);
//                System.out.println("Do you want to add new Edge...? y/n");
//                String input2= sc.next();
//                if(input2.equalsIgnoreCase("n"))break;
//            }
//            System.out.println("press any key to continue press x to exit");
//            String input = sc.next();
//            if(input.equalsIgnoreCase("x"))break;
//        }
        graph.addNodes("A","B",1);
        graph.addNodes("A","D",8);
        graph.addNodes("A","F",10);
        graph.addNodes("B","C",2);
        graph.addNodes("B","E",7);
        graph.addNodes("C","F",11);
        graph.addNodes("C","G",3);
        graph.addNodes("D","B",5);
        graph.addNodes("D","E",6);
        graph.addNodes("D","C",7);
        graph.addNodes("E","F",5);
        graph.addNodes("E","A",9);
        graph.addNodes("F","G",4);

        graph.printGraph();
        System.out.println("Bfs");
        for (Map.Entry<String, LinkedList<HashMap<String,Integer>>> entry: graph.Graph.entrySet()  ){
            graph.BFS(entry.getKey());
            System.out.println();
        }
        System.out.println("dfs");
        for (Map.Entry<String, LinkedList<HashMap<String,Integer>>> entry: graph.Graph.entrySet()  ){
            graph.DSF(entry.getKey());
            System.out.println();
        }
        System.out.println("Minimum spanning tree");
        for (Map.Entry<String, LinkedList<HashMap<String,Integer>>> entry: graph.Graph.entrySet()  ){
            System.out.println(graph.minimumSpanningTree(entry.getKey(), graph.Graph));
        }
        System.out.println("Dikjstra's Algorithm");
        for (Map.Entry<String, LinkedList<HashMap<String,Integer>>> entry: graph.Graph.entrySet()  ){
            System.out.println(graph.dijkstra(graph.Graph, entry.getKey()));
        }
    }
}
