package MyBinaryTree;


public class BinaryTreeNode implements Comparable<Integer>{

    private Integer _value;

    private BinaryTreeNode Left;
    private BinaryTreeNode Right;

    public BinaryTreeNode(Integer value){
        _value = value;
    }

    @Override
    public int compareTo(Integer o) {
        return _value.compareTo(o);
    }


    public Integer get_value() {
        return _value;
    }

    public void set_value(Integer _value) {
        this._value = _value;
    }

    public BinaryTreeNode getLeft() {
        return Left;
    }

    public void setLeft(BinaryTreeNode left) {
        Left = left;
    }

    public BinaryTreeNode getRight() {
        return Right;
    }

    public void setRight(BinaryTreeNode right) {
        Right = right;
    }




}
