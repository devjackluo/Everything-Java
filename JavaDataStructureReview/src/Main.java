import MyBinaryTree.BinaryTree;
import MyBinaryTree.BinaryTreeNode;

import java.util.Iterator;

public class Main {

    public static void main(String[] args){

        Integer[] i = new Integer[51];
        for(int x = 0; x < i.length; x++){
            i[x] = x;
        }

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.set_head(createNodeFromSorted(i, 0, i.length-1));
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
        binaryTree.Add(1);
        */

        //System.out.println(binaryTree.Contains(6));
        //System.out.println(binaryTree.Contains(9));

        //binaryTree.Remove(2);
        System.out.println(binaryTree.Contains(9));

        for(BinaryTreeNode b: binaryTree){
            System.out.println(b.get_value());
        }

        //binaryTree.InOrderTraversal();
        //binaryTree.Remove(6);

    }

    public static BinaryTreeNode createNodeFromSorted(Integer[] array, int start, int end){

        //start and end will converge once it divides enough
        //then because end is subtracted one from left side and start is added on right side, eventually they offset
        if(start > end)
            return null;

        //midpoint is start position plus end postion divided by 2 ROUNDED DOWN.
        int mid = (start + end)/2;

        //create a node with that position's value
        BinaryTreeNode root = new BinaryTreeNode(array[mid]);

        //recursive call create for the left side of mid and subtracting one end value.
        root.setLeft(createNodeFromSorted(array, start, mid-1));
        //recursive call create for the right side if mid and subtract one starting value
        root.setRight(createNodeFromSorted(array, mid+1, end));

        return root;

    }

}
