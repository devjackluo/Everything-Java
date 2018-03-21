import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanEncoder {


    private static final int ALPHABET_SIZE = 256;

    public HuffmanEncodedResult compress(final String data){

        //make a frequency table with ASCII value for int[256]
        final int[] freq = buildFrequencyTable(data);

        // create a hufffmantree with the freqencies that we have.
        final Node root = buildHuffmanTree(freq);

        //pass in huffmantree to create lookup table
        //recursively creates binary string to character nodes in tree
        final Map<Character, String> lookupTable = buildLookupTable(root);

        //return a result object
        //generated the binary string and pass in the huffmantree with it.
        return new HuffmanEncodedResult(generateEncodedData(data, lookupTable), root);
    }

    private static String generateEncodedData(String data, Map<Character, String> lookupTable) {

        //creates a string by going thru each char in data, match to lookuptable and append that binary string.
        final StringBuilder builder = new StringBuilder();
        for(final char character : data.toCharArray()){
            builder.append(lookupTable.get(character));
        }
        // pass completed binary string.
        return builder.toString();
    }

    private static Map<Character, String> buildLookupTable(final Node root){

        final Map<Character, String> lookupTable = new HashMap<>();

        // pass in huffmantree, empty string, empty lookup table.
        buildLookupTableImpl(root, "", lookupTable);

        return lookupTable;
    }

    private static void buildLookupTableImpl(Node node, String s, Map<Character, String> lookupTable) {

        //if left and right isn't null
        if(!node.isLeaf()){
            // left is 0, right is 1
            // then it calls recursively with that left/right node, adds to string, pass lookuptable.
            buildLookupTableImpl(node.leftChild, s + '0', lookupTable);
            buildLookupTableImpl(node.rightChild, s+ '1', lookupTable);
        }else{
            // if it is leaf, then we add that node's char and binary string to table.
            lookupTable.put(node.character, s);
        }

    }

    private static Node buildHuffmanTree(int[] freq){

        // create a priority queue poll thingy
        final PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        // for all freq ASCII values
        for(char i = 0; i < ALPHABET_SIZE; i++){
            // if that value is greater than 0
            if(freq[i] > 0){
                //create a empty node
                priorityQueue.add(new Node(i, freq[i], null, null));
            }
        }

        //if priority queue has only one, add an empty node to make two at least.
        if(priorityQueue.size() == 1){
            priorityQueue.add(new Node('\0', 1, null, null));
        }

        // keeps adding to self and combining until only one item is left(completed tree)
        //while priority queue still ahs more than 1 item. (completed tree)
        while(priorityQueue.size() > 1){
            // we grab the first and second value, combine into a single node and all back to queue
            final Node left = priorityQueue.poll();
            final Node right = priorityQueue.poll();
            final Node parent = new Node('\0', left.frequency + right.frequency, left, right);
            priorityQueue.add(parent);
        }

        // return the completed tree
        return priorityQueue.poll();

    }

    private static int[] buildFrequencyTable(final String data){
        final int[] freq = new int[ALPHABET_SIZE];
        for(final char character : data.toCharArray()){
            //ASCII value of 'char' and increment that position
            freq[character]++;
        }

        return freq;
    }




    // TO DECOMPRESS
    public String decompress(final HuffmanEncodedResult result){

        final StringBuilder resultBuilder = new StringBuilder();

        // get the huffmantree from the result object
        Node current = result.getRoot();

        //while i less than length of binary string
        int i = 0;
        while(i < result.getEncodedData().length()){

            //while not leaf in tree yet.
            while(!current.isLeaf()){

                //get binary digit coressponding to i position
                char bit = result.getEncodedData().charAt(i);

                // if 1 - right node, if 0 - left node
                //set current as this node.
                if(bit == '1'){
                    current = current.rightChild;
                }else if (bit == '0'){
                    current = current.leftChild;
                }else{
                    throw new IllegalArgumentException("Invalid bit! " + bit);
                }
                //increment i++
                i++;
                //if current still not leaf, keep looping thru until it is.
            }

            // append that leaf node character to string builder
            resultBuilder.append(current.character);
            // reset current back to top of tree
            current = result.getRoot();

        }

        //once i reached the end of binary string, should be completed and return the completed decompress string.
        return resultBuilder.toString();
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////
    // The classes for node and result object/////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    static class Node implements Comparable<Node>{
        private final char character;
        private final int frequency;
        private final Node leftChild;
        private final Node rightChild;

        private Node(final char character, final int frequency, final Node leftChild, final Node rightChild){
            this.character = character;
            this.frequency = frequency;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        boolean isLeaf(){
            return this.leftChild == null && this.rightChild == null;
        }

        @Override
        public int compareTo(Node that) {

            final int frequencyComparison = Integer.compare(this.frequency, that.frequency);
            if(frequencyComparison != 0){
                return frequencyComparison;
            }
            return Integer.compare(this.character, that.character);
        }
    }

    static class HuffmanEncodedResult{

        final Node root;
        final String encodedData;

        HuffmanEncodedResult(final String encodedData, final Node root){
            this.encodedData = encodedData;
            this.root = root;
        }

        public Node getRoot(){
            return this.root;
        }

        public String getEncodedData(){
            return this.encodedData;
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////




    public static void main(String[] args){

        final String test = "hello world! wtf is this madness";
        final HuffmanEncoder encoder = new HuffmanEncoder();
        final HuffmanEncodedResult result = encoder.compress(test);

        System.out.println(result.encodedData);
        System.out.println(encoder.decompress(result));

    }

}
