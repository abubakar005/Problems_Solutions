package amazon;

import java.util.Arrays;
import java.util.List;

public class ShipmentImbalance {

    public static void main(String[] args) {

        // 3,5,8,2

        /** 3,5=2    3,5,8=5    3,5,8,2=6     5,8=3    5,8,2=6    8,2=6      */
        List<Integer> weight = Arrays.asList(4,4,4,4,4);
        List<Integer> weight1 = Arrays.asList(1,2,3);
        List<Integer> weight2 = Arrays.asList(1,3,2);
        List<Integer> weight3 = Arrays.asList(3,5,8,2);
        System.out.println(getTotalImbalance2(weight1));

        int[] nums = {1,2,3};
        int[] nums1 = {3,2,3};
        int[] nums2 = {1,3,2};
        int[] nums3 = {3,5,8,2};
        amazonShipping(nums1);
    }


    public static long getTotalImbalance(List<Integer> weight) {

        long sumImbalance = 0;
        int minWeight = 0;
        int maxWeight = 0;

        if(weight == null || weight.isEmpty() || weight.size() == 1)
            return sumImbalance;

        minWeight = Math.min(weight.get(0), weight.get(1));
        maxWeight = Math.max(weight.get(0), weight.get(1));

        sumImbalance += maxWeight-minWeight;

        if(weight.size() == 2)
            return sumImbalance;

        //int startIndex = 2;

        for(int endIndex =2; endIndex < weight.size(); endIndex++) {

            minWeight = Math.min(minWeight, weight.get(endIndex));
            maxWeight = Math.max(maxWeight, weight.get(endIndex));

            sumImbalance += maxWeight-minWeight;
        }

        return sumImbalance;
    }

    public static long getTotalImbalance2(List<Integer> weight) {

        long sumImbalance = 0;
        int minWeight = Integer.MAX_VALUE;
        int maxWeight = Integer.MIN_VALUE;

        if(weight == null || weight.isEmpty())
            return sumImbalance;

        for(int i=0; i<weight.size(); i++) {

            for(int j=i; j<weight.size(); j++) {

                minWeight = Math.min(minWeight, weight.get(j));
                maxWeight = Math.max(maxWeight, weight.get(j));

                sumImbalance += maxWeight-minWeight;
            }

            minWeight = Integer.MAX_VALUE;
            maxWeight = Integer.MIN_VALUE;
        }

        return sumImbalance;
    }

    // 1,2,3          1,2=1     1,2,3=2      2,3=1
    public static void amazonShipping(int[] nums) {

        int size = 0;
        int prev = 0;
        int next = 1;
        int sum = 0;
        int i = 0;

        while (i < nums.length) {
            i++;
            int max = Math.max(nums[prev], nums[next]);
            int min = Math.min(nums[prev], nums[next]);
            sum += max - min;
            prev++;
            next++;

            if (next == nums.length) {
                size += 1;
                prev = 0;
                next = prev + 1 + size;
            }
        }

        System.out.println(sum);
    }
}
