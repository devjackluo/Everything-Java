
public class SimpleLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int listSize;

    public void delete(int position){

        if(position < 0 || position > listSize-1){
            throw new NullPointerException("out of bounds");
        }

        Node<E> current = this.head;
        int i = 1;

        if(position == 0){
            current = this.head.getNext();
            i++;
        }

        if(listSize > 1) {

            Node<E> statNode = new Node<>(current.getData());
            Node<E> newHead = statNode;
            Node<E> newTail = statNode;

            while (current != null) {

                if (current.getNext() == null) {
                    break;
                }

                current = current.getNext();

                if (position != i) {
                    final Node<E> newNode = new Node<>(current.getData());
                    newTail.setNext(newNode);
                    newTail = newNode;
                }
                i++;

            }

            this.head = newHead;

        }else{

            this.head = null;

        }

    }

    public void add(E data){

        //creates new node with that data.
        final Node<E> newNode = new Node<>(data);

        //if empty, set head and tail as this node
        if(this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else {

            // if not empty, set tail's next as new node.
            // we can reset tail because head contains everything.
            this.tail.setNext(newNode);
            // set new node as the current tail
            this.tail = newNode;
        }

        //increment listsize
        this.listSize++;

    }

    @Override
    public String toString(){
        //get the head
        Node<E> current = this.head;
        final StringBuilder output = new StringBuilder();
        //while head not null
        while(current != null){
            //append data to builder
            output.append("[");
            output.append(current.getData());
            output.append("]");
            //set current as current's next
            current = current.getNext();
        }
        return output.toString();
    }

    public boolean isEmpty(){
        return this.listSize == 0;
    }



    static class Node<E> {
        private E data;
        private Node next;

        Node(final E data){
            this.data = data;
        }

        Node<E> getNext(){
            return this.next;
        }

        E getData(){
            return this.data;
        }

        void setNext(final Node<E> node){
            this.next = node;
        }

        @Override
        public String toString(){
            return this.data.toString();
        }

    }

    public static void main(String[] args){

        //create a list
        final SimpleLinkedList<String> linkedList = new SimpleLinkedList<>();
        //add stuff
        linkedList.add("see");
        linkedList.add("me");
        linkedList.add("when");
        linkedList.add("ok");

        linkedList.delete(3);

        System.out.println(linkedList);


    }


}
