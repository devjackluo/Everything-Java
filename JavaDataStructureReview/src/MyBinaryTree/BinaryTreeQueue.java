package MyBinaryTree;

import java.util.LinkedList;

public class BinaryTreeQueue<BinaryTreeNode> {

    LinkedList<BinaryTreeNode> btLinkedList = new LinkedList<>();

    public void Enqueue(BinaryTreeNode node){
        btLinkedList.addLast(node);
    }

    public BinaryTreeNode Dequeue(){
        if(btLinkedList.size() == 0){
            throw new NullPointerException("None Left");
        }

        BinaryTreeNode value = btLinkedList.getFirst();
        btLinkedList.removeFirst();

        return value;

    }

    public BinaryTreeNode Peek(){

        if(btLinkedList.size() == 0){
            throw new NullPointerException("None Left");
        }

        return btLinkedList.getFirst();
    }

    public int getCount() {
        return btLinkedList.size();
    }

    public void Clear(){
        btLinkedList.clear();
    }
}
