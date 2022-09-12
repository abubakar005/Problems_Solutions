package amazon;

import java.util.Arrays;
import java.util.List;

public class MaxProductOfSubarray {


    public static void main(String[] args) {

        List<Integer> badges = Arrays.asList(1,-1,-1,1,1,-1);
        List<Integer> badges1 = Arrays.asList(1,-1,-1,-1,1,1);

        int[] test = {1, -2, -3, 4};
        int[] test1 = {0, 1, -2, -3, -4};
        int[] test2 = {1,-1,-1,1,1,-1};
       // int result = maxSubarrayLength(test2);
        System.out.println(getMaxLen(test2));
    }

    public static int maxSubarrayLength(List<Integer> badges) {

        int maxLength = 0;
        int product;

        if(badges == null || badges.isEmpty())
            return maxLength;

        for(int i=0; i<badges.size(); i++) {

            product = 1;

            for(int j=i; j<badges.size(); j++) {

                product *= badges.get(j);

                if(product == 1) {
                    System.out.println("i: " + i + " j: " + j);
                    maxLength = Math.max(maxLength, (j-i)+1);
                }
            }
        }

        return maxLength;
    }


    public static int maxSubarrayLength1(List<Integer> badges) {

        int maxLength = 0;
        int product = 1;
        int start = 0;
        int end;

        if(badges == null || badges.isEmpty())
            return maxLength;

        for(end=0; end<badges.size(); end++) {

            product *= badges.get(end);

            if(product == 1) {
                System.out.println("start: " + start + " end: " + end);
            //    maxLength = Math.max(maxLength, (j-i)+1);
            }
        }

        return maxLength;
    }

    // 1,-1,-1,1,1,-1
    public static int getMaxLen(int[] nums) {
        int positive = 0;
        int negative = 0;
        int res = 0;

        for(int i = 0;i< nums.length;i++){
            int temp = nums[i];

            if(temp == 0){
                positive = 0;
                negative = 0;
            }else if(temp > 0){
                positive++;
                negative = negative == 0 ? 0 : negative+1;
            }else{
                int x = positive;
                positive = negative == 0 ? 0 : negative + 1;
                negative = x + 1;
            }

            res = Math.max(res,positive);
        }

        return res;
    }
}
