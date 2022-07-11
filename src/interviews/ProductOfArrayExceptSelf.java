package interviews;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String args[]){

        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        // For example, given [1,2,3,4], return [24,12,8,6].
        int[] nums = {1,2,3,4,5};

        int[] result = productOfArrayExceptSelf.productExceptSelfMyImpl(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 1;

        for(int i = 0; i < nums.length; i++) {
            if(i > 0) {
                left *= nums[i - 1];
            }

            result[i] = left;
        }

        int right = 1;

        for(int i = n - 1; i >= 0; i--) {
            if(i < n - 1) {
                right *= nums[i + 1];
            }

            result[i] *= right;
        }

        return result;
    }

    public int[] productExceptSelf2(int[] nums) {

        int length = nums.length;
        int[] result = new int[length];

        for(int i = 0; i < length; i++) {

            int value = 1;

            for(int j = 0; j < length; j++) {

                if(i != j)
                    value *= nums[j];

            }

            result[i] = value;
        }

        return result;
    }

    public int[] productExceptSelfMyImpl(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int prefix = 1;
        for (int i=0; i<n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i=n-1; i>=0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}
