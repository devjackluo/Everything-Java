package MyBinaryTree;

import javafx.util.Pair;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTree implements Iterable<BinaryTreeNode>{

    private BinaryTreeNode _head;
    private int _count;

    public void Add(Integer value){

        if(_head == null){
            _head = new BinaryTreeNode(value);
        }else{

            AddTo(_head, value);

        }

        _count++;

    }

    public void AddTo(BinaryTreeNode node, Integer value){

        //Recursively traverse tree until empty slot to add it.

        if(value.compareTo(node.get_value()) < 0) {

            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode(value));
            } else {
                AddTo(node.getLeft(), value);
            }

        }else{

            if(node.getRight() == null){
                node.setRight(new BinaryTreeNode(value));
            }else{
                AddTo(node.getRight(), value);
            }

        }


    }

    public boolean Contains(Integer value){
        Pair<BinaryTreeNode, BinaryTreeNode> parent = FindWithParent(value);
        return parent.getKey() != null;
    }

    private Pair<BinaryTreeNode, BinaryTreeNode> FindWithParent(Integer value){

        BinaryTreeNode current = _head;
        BinaryTreeNode parent = null;

        while(current != null){
            int result = current.compareTo(value);
            if(result > 0){
                parent = current;
                current = current.getLeft();
            }else if(result < 0){
                parent = current;
                current = current.getRight();
            }else{
                break;
            }
        }

        return new Pair<>(current, parent);

    }

    public boolean Remove(Integer value){


        Pair<BinaryTreeNode, BinaryTreeNode> childWithParent = FindWithParent(value);
        BinaryTreeNode current = childWithParent.getKey();
        BinaryTreeNode parent = childWithParent.getValue();

        if(current == null){
            return false;
        }

        _count--;

        if(current.getRight() == null){

            if(parent == null){
                _head = current.getLeft();
            }else {
                //figure out to put on left or right side of parent
                int result = parent.compareTo(current.get_value());
                if(result > 0){
                    parent.setLeft(current.getLeft());
                }else if(result < 0){
                    parent.setRight(current.getLeft());
                }
            }

        }else if(current.getRight().getLeft() == null){

            current.getRight().setLeft(current.getLeft());

            if(parent == null){
                _head = current.getRight();
            }else{

                int result = parent.compareTo(current.get_value());
                if(result > 0){
                    parent.setLeft(current.getRight());
                }else if(result < 0){
                    parent.setRight(current.getRight());
                }

            }

        }else{

            BinaryTreeNode leftMost = current.getRight().getLeft();
            BinaryTreeNode leftMostParent = current.getRight();

            while(leftMost.getLeft() != null){
                leftMostParent = leftMost;
                leftMost = leftMost.getLeft();
            }

            //if leftmost has any right, move those up to where leftmost is
            leftMostParent.setLeft(leftMost.getRight());

            leftMost.setLeft(current.getLeft());

            //critical to move the current's right side over after we shifted leftmost out
            leftMost.setRight(current.getRight());

            if(parent == null){
                _head = leftMost;
            }else{
                int result = parent.compareTo(current.get_value());
                if(result > 0){
                    parent.setLeft(leftMost);
                }else if(result < 0){
                    parent.setRight(leftMost);
                }
            }

        }


        return true;
    }


    public BinaryTreeQueue<BinaryTreeNode> InOrderTraversalQueue(){

        BinaryTreeQueue binaryTreeQueue = new BinaryTreeQueue();

        if (_head != null) {

            Stack<BinaryTreeNode> stack = new Stack<>();

            BinaryTreeNode current = _head;
            boolean goLeftNext = true;
            stack.push(current);

            while(stack.size() > 0){

                if(goLeftNext){
                    while(current.getLeft() != null){
                        stack.push(current);
                        current = current.getLeft();
                    }
                }

                //System.out.println(current.get_value());
                binaryTreeQueue.Enqueue(current);

                if(current.getRight() != null){
                    current = current.getRight();
                    goLeftNext = true;
                }else{
                    current = stack.pop();
                    goLeftNext = false;
                }

            }

        }


        return binaryTreeQueue;

    }


    public int get_count() {
        return _count;
    }

    public void set_head(BinaryTreeNode head){
        _head = head;
    }

    @Override
    public Iterator<BinaryTreeNode> iterator() {
        return new Iterator<BinaryTreeNode>() {

            BinaryTreeQueue binaryTreeQueue = InOrderTraversalQueue();

            @Override
            public boolean hasNext() {
                return binaryTreeQueue.getCount() > 0;
            }

            @Override
            public BinaryTreeNode next() {
                return (BinaryTreeNode) binaryTreeQueue.Dequeue();
            }

        };
    }


}
