import javafx.util.Pair;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] n = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};

        threeSum(n);

    }


    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for(int i = 0; i < nums.length; i++){
            for(int n = 0; n < nums.length; n++){
                for(int m = 0; m < nums.length; m++){
                    if(i != n && i != m && n != m) {
                        int value = nums[i] + nums[n] + nums[m];
                        if (value == 0) {
                            List<Integer> set = new ArrayList<Integer>();
                            set.add(nums[i]);
                            set.add(nums[n]);
                            set.add(nums[m]);
                            Collections.sort(set);

                            if(!ret.contains(set))
                                ret.add(set);

                        }
                    }
                }
            }
        }


        return ret;

    }

}
