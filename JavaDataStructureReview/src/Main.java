import MyBinaryTree.BinaryTree;
import MyBinaryTree.BinaryTreeNode;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args){

        Integer[] i = new Integer[101];
        for(int x = 0; x < i.length; x++){
            i[x] = x;
        }

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.set_head(createBalancedNodeFromSorted(i, 0, i.length-1));

        /*
        binaryTree.Add(5);
        binaryTree.Add(6);
        binaryTree.Add(2);
        binaryTree.Add(4);
        binaryTree.Add(4);
        binaryTree.Add(4);
        binaryTree.Add(3);
        binaryTree.Add(3);
        binaryTree.Add(3);
        binaryTree.Add(1);*/


        //System.out.println(binaryTree.Contains(6));
        //System.out.println(binaryTree.Contains(9));

        //binaryTree.Remove(2);
        System.out.println(binaryTree.Contains(9));

        for(BinaryTreeNode b: binaryTree){
            System.out.println(b.get_value());
        }

        //binaryTree.InOrderTraversal();
        //binaryTree.Remove(6);


        //really stupid to implement depth and breath first search to binary tree but just wanted to see it
        //well now i can know what is inside the subtree of something else
        System.out.println("  ");
        System.out.println(hasPathBFS(2, 3, binaryTree));
        System.out.println(hasPathBFS(2, 5, binaryTree));
        System.out.println(hasPathBFS(5, 2, binaryTree));
        System.out.println(hasPathBFS(50, 90, binaryTree));
        System.out.println(hasPathBFS(40, 38, binaryTree));
        System.out.println(hasPathBFS(60, 99, binaryTree));
        System.out.println("  ");
        System.out.println(hasPathDFS(2, 3, binaryTree));
        System.out.println(hasPathDFS(2, 5, binaryTree));
        System.out.println(hasPathDFS(5, 2, binaryTree));
        System.out.println(hasPathDFS(50, 90, binaryTree));
        System.out.println(hasPathDFS(40, 38, binaryTree));
        System.out.println(hasPathDFS(60, 99, binaryTree));




    }

    public static BinaryTreeNode createBalancedNodeFromSorted(Integer[] array, int start, int end){

        //start and end will converge once it divides enough
        //then because end is subtracted one from left side and start is added on right side, eventually they offset
        if(start > end)
            return null;

        //midpoint is start position plus end postion divided by 2 ROUNDED DOWN.
        int mid = (start + end)/2;

        //create a node with that position's value
        BinaryTreeNode root = new BinaryTreeNode(array[mid]);

        //recursive call create for the left side of mid and subtracting one end value.
        root.setLeft(createBalancedNodeFromSorted(array, start, mid-1));
        //recursive call create for the right side if mid and subtract one starting value
        root.setRight(createBalancedNodeFromSorted(array, mid+1, end));

        return root;

    }



    private static BinaryTreeNode getNode(int id, BinaryTree bt){
        //bt.FindWithParent(id);
        return bt.FindWithParent(id).getKey();

    }


    //depth first search recursively calls every single node and their paths until it returns false or true.
    //basically breath first is better 10x unless you want to check for multiple paths or whatever
    public static boolean hasPathDFS(int source, int destination, BinaryTree bt){
        BinaryTreeNode startNode = getNode(source,bt);
        BinaryTreeNode destinationNode = getNode(destination,bt);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(startNode,destinationNode,visited);
    }


    private static boolean hasPathDFS(BinaryTreeNode source, BinaryTreeNode destination, HashSet<Integer> visited){

        if(visited.contains(source.get_value()))
            return false;

        visited.add(source.get_value());

        if(source.get_value().equals(destination.get_value()))
            return true;

        for(BinaryTreeNode child: source.getAdjacent()){
            if(hasPathDFS(child, destination, visited)){
                return true;
            }
        }

        return false;
    }



    //breath first search uses a queue to do one node at a time and instantly returning true if it find a path
    public static boolean hasPathBFS(int source, int destination, BinaryTree bt){
        return hasPathBFS(getNode(source, bt), getNode(destination, bt));
    }


    private static boolean hasPathBFS(BinaryTreeNode source, BinaryTreeNode destination){
        LinkedList<BinaryTreeNode> nextToVisit = new LinkedList<BinaryTreeNode>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.addFirst(source);
        while(!nextToVisit.isEmpty()){
            BinaryTreeNode node = nextToVisit.removeFirst();
            if(node.get_value().equals(destination.get_value())){
                return true;
            }
            if(visited.contains(node.get_value())){
                continue;
            }
            visited.add(node.get_value());

            for(BinaryTreeNode child : node.getAdjacent()){
                nextToVisit.addLast(child);
            }
        }

        return false;

    }

}
