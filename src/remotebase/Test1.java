package remotebase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author abubakar
 **/

public class Test1 {


    /**
     *
     *  Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     * Example 1:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     * Example 2:
     *
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     * Example 3:
     *
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     *
     *
     *
     *  Solution
     *
     *  Input: nums = [-1,0,1,2,-1,-4]
     *
     *  List<Integer[]> output = new arraylist;
     *  int[] arr = new int[3];
     *
     *  step 1 : I will sort this array to check and avoid duplication
     *
     *  step 1 output: [-4,-1,-1,0,1,2]
     *
     *  Step 2: I will 3 pointers like  i=0; j=1; k=length-1;
     *
     *  for(j < length) {
     *
     *
     *      i = -4
     *      j = -1
     *      k = 2
     *
     *      int sum = i+j+k;
     *
     *      if(sum > 0) {
     *
     *      }
     *
     *      if(sum == 0) {
     *          I will add in the output list/array
     *
     *
     *      }
     *
     *      j++;  if (next number is the same as previous then i will skip and again j++)
     *      k--;  if (if the current number is the same as next then it will skip and again k--)
     *  }
     *
     * */



    /**
     *  Overall Complexity
     *
     *  Time Complexity: O(nlog(n)) + O(n^2) =  O(n^2)
     *  Space Complexity: O(n)
     *
     * */

    public static void main(String[] args) {

        Test1 obj = new Test1();
        int[] test1 = {-1,0,1,2,-1,-4};
        int[] test2 = {0,1,1};
        int[] test3 = {0,0,0};

        System.out.println(obj.getTriplets(test1));
    }

    public List<List<Integer>> getTriplets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        // Sorting array here
        Arrays.sort(nums);                                          // Time complexity: O(nlog(n))

        ArrayList<Integer> temp;
        int j;
        int k;
        int sum;

        for (int i = 0; i < nums.length - 2; i++) {                             // Time complexity: O(n-1) = O(n)

            // Check if the previous element was the same
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            j = i + 1;
            k = nums.length - 1;

            while (j < k) {                                                     // Time complexity: n-2.. n-3 .... n-length-1 = O(n) which make n*n = O(n^2)

                // Adding all the three indices of array
                sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    temp = new ArrayList<>();

                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    result.add(temp);

                    j++;
                    k--;

                    // Checking duplicates for increasing index [if exists then it will skip]
                    while (j < k && nums[j] == nums[j - 1])
                        j++;

                    // Checking duplicates for decreasing index [if exists then it will skip]
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else if (sum > 0)
                    k--;
                else
                    j++;
            }
        }
        return result;
    }
}
