package DFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

    private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

    public static class Node{
        private int id;
        LinkedList<Node> adjacent = new LinkedList<Node>();
        private Node(int id){
            this.id = id;
        }
    }

    private Node getNode(int id){
        return nodeLookup.get(id);
    }

    private void addEdge(int source, int destination){

    }


    //depth first search recursively calls every single node and their paths until it returns false or true.
    //basically breath first is better 10x unless you want to check for multiple paths or whatever
    public boolean hasPathDFS(int source, int destination){
        Node startNode = getNode(source);
        Node destinationNode = getNode(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(startNode,destinationNode,visited);
    }


    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited){

        if(visited.contains(source.id))
            return false;

        visited.add(source.id);

        if(source == destination)
            return true;

        for(Node child: source.adjacent){
            if(hasPathDFS(child, destination, visited)){
                return true;
            }
        }

        return false;
    }



    //breath first search uses a queue to do one node at a time and instantly returning true if it find a path
    public boolean hasPathBFS(int source, int destination){
        return hasPathBFS(getNode(source), getNode(destination));
    }


    private boolean hasPathBFS(Node source, Node destination){
        LinkedList<Node> nextToVisit = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.addFirst(source);
        while(!nextToVisit.isEmpty()){
            Node node = nextToVisit.removeFirst();
            if(node == destination){
                return true;
            }
            if(visited.contains(node.id)){
                continue;
            }
            visited.add(node.id);

            for(Node child : node.adjacent){
                nextToVisit.addLast(child);
            }
        }

        return false;

    }

}
