import java.util.*;
class Graph{
    HashMap<String,List<String>> adjList = new HashMap<>();

    void  addEdge(String src, String dest, boolean dir){
        List<String> adjVertices = adjList.getOrDefault(src, new ArrayList<>());
        adjVertices.add(dest);
        adjList.put(src, adjVertices);
        if (!dir){
            List<String> reverseAdjVertices = adjList.getOrDefault(dest, new ArrayList<>());
            reverseAdjVertices.add(src);
            adjList.put(dest, reverseAdjVertices);
        }
    }


    void printAdjList(){
        System.out.println(adjList);
        System.out.println();
        for (SortedMap.Entry<String,List<String>> e: adjList.entrySet()){
            Collections.sort(e.getValue());
            System.out.print(e.getKey()+" -> "+e.getValue());
            System.out.println();
        }
    }
}
public class graph {
    public static void main(String[] args) {
        Graph g = new Graph();
        Scanner sc = new Scanner(System.in);
        String choice;boolean dir;
//        System.out.println("Enter the number of nodes...!");
//        n=sc.nextInt();
//        System.out.println("Enter the number of edges...!");
//        m=sc.nextInt();
//        System.out.println("Is the graph directed...? Press y/n...!");
//        o=sc.next();
//        dir= Objects.equals(o, "y");
//        System.out.println(dir ?"Creating directed graph": "Creating undirected graph");
//        for(int i =0; i<m;i++){
//            int src , dest;
//            System.out.println("Enter source");
//            src=sc.nextInt();
//            System.out.println("Enter destination");
//            dest=sc.nextInt();
////            creating graph
//            g.addEdge(src,dest,dir);
//        }
//        printing graph

        System.out.println("Is the graph directed...? Press y/n...!");
        choice=sc.next();
        dir= Objects.equals(choice, "y");
        System.out.println(dir ?"Creating directed graph": "Creating undirected graph");

        while (true){
            System.out.println("Enter <exit> to exit or any other key to continue");
            String exit= sc.next();
            if(Objects.equals(exit,"exit"))break;
           String src , dest;
            System.out.println("Enter source");
            src=sc.next();
            System.out.println("Enter destination");
            dest=sc.next();
//            creating graph
            g.addEdge(src,dest,dir);
            g.printAdjList();
        }

    }
}
