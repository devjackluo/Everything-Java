public class BubbleSort {


    public static void main(String[] args){

        int[] arr = {73,9,276,1,72,97,29,5,8,72,3,7826,279,4,7173,652,5,789,27,2,372,6,279,723,24,7,735,2769,91,42,76};

        bubbleSort(arr);

        for(int i : arr){
            System.out.println(i);
        }

    }


    public static void bubbleSort(int[] array){
        boolean isSorted = false;
        int lastSorted = array.length-1;
        while (!isSorted){
            isSorted = true;
            for(int i = 0; i < lastSorted; i++){
                if(array[i] > array[i+1]){
                    swap(array, i, i+1);
                    isSorted = false;
                }
            }
            //because if we iterate front to end swapping,
            // the end will always be the biggest therefore, we don't need to recheck it
            lastSorted--;
        }
    }

    public static void swap(int[] array, int front, int back){
        int temp = array[front];
        array[front] = array[back];
        array[back] = temp;

    }



}
