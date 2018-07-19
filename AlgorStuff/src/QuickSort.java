public class QuickSort {


    public static void main(String[] args){

        int[] arr = {73,9,276,1,72,97,29,5,8,72,3,7826,279,4,7173,652,5,789,27,2,372,6,279,723,24,7,735,2769,91,42,76};
        //int[] arr = {1,2,3,4,6,11,12,2,3,4};
        //int[] arr = {11,11,2,3,1,5,6,1,3,12};

        quickSort(arr);

        for(int i : arr){
            System.out.println(i);
        }

    }

    public static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left >= right)
            return;

        //pivot will be middle
        int pivot = array[(left+right)/2];

        //index is the partition point/last swap
        int index = partition(array, left, right, pivot);
        //since it was last swap, we still
        quickSort(array, left, index-1);
        //inclusive of partition point because left/right could potentially get pass pivot sometimes twice
        quickSort(array, index, right);

    }

    public static int partition(int[] array, int left, int right, int pivot){
        //while left is less than right
        while(left <= right){
            //move left pointer until it finds something bigger than pivot
            //will stop at pivot because same
            while (array[left] < pivot){
                left++;
            }
            //move right pointer until it finds something smaller than pivot
            //will stop at pivot because same
            while (array[right] > pivot){
                right--;
            }

            //if left is still on left side and right on right or same spot
            //same spot will increment not move anything but increment left and right to end loop
            //because left or right will always spot at pivot, it it gets swapped, that means partition is basically done
            //so the most left/right can get pass is one or two
            if(left<=right){
                swap(array,left,right);
                left++;
                right--;
            }
        }

        //return the last position where you swapped
        return left;
    }

    public static void swap(int[] array, int front, int back){
        int temp = array[front];
        array[front] = array[back];
        array[back] = temp;

    }

}
