public class MergeSort {


    public static void main(String[] args){

        int[] arr = {73,9,276,1,72,97,29,5,8,72,3,7826,279,4,7173,652,5,789,27,2,372,6,279,723,24,7,735,2769,91,42,76};

        mergeSort(arr);

        //System.out.println(arr);

        for(int i : arr){
            System.out.println(i);
        }

    }


    public static void mergeSort(int[] array){
        //init merge sort with array, temp array, start position and end position
        mergeSort(array, new int[array.length], 0, array.length-1);
    }

    private static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {

        //if no more elements to split, return
        if(leftStart >= rightEnd)
            return;

        //get middle of section
        int middle = (leftStart+rightEnd)/2;

        //recursively half both the left and right side of each sections
        //until it reaches the end
        mergeSort(array, temp, leftStart, middle);
        mergeSort(array, temp, middle+1, rightEnd);

        //recursively call back and merge the left and right halves
        mergeHalves(array, temp, leftStart, rightEnd);

    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {

        //leftend aka the middle of the section
        int leftEnd = (rightEnd+leftStart)/2;
        //right start, aka the middle of section plus one
        int rightStart = leftEnd + 1;
        //how many elements was in this section
        int size = rightEnd - leftStart + 1;

        //temp values to use for looping across both sides
        int left = leftStart;
        int right = rightStart;
        //we want to place sorted items starting at the left side
        int index = leftStart;

        //while we haven't reached the end of leftend and rightend
        while(left <= leftEnd && right <= rightEnd){
            //if left side was smaller
            if(array[left] <= array[right]){
                //then assign the left value to be added
                temp[index] = array[left];
                //increment left side
                left++;
            }else{
                //if left side was bigger, then assign right side to be added
                temp[index] = array[right];
                //increment right side
                right++;
            }
            //always increment index to know where to put next value
            index++;
        }


        //once one side is all added, we can add the remaining elements from the side that haven't finished
        if(right <= rightEnd){
            //if right side didn't finished, loop across the remaining right side and add them all
            while(right <= rightEnd){
                temp[index] = array[right];
                right++;
                index++;
            }
        }else{
            //if left side didn't finished, loop across the remaining left side and add them all
            while(left <= leftEnd){
                temp[index] = array[left];
                left++;
                index++;
            }
        }

        //once temp is merge sorted,
        //we'll loop thru temp starting at the left side and adding the amount of elements combined
        for(int i = leftStart; i < size+leftStart; i++){
            //since array is shallow copy, this will constantly update it.
            array[i] = temp[i];
        }

        //System.arraycopy(array, left, temp, index, leftEnd-left+1);
        //System.arraycopy(array, right, temp, index, rightEnd-right+1);
        //System.arraycopy(temp, leftStart, array, leftStart, size);

    }


}
