package generic.problems;

public class MaximumSubArraySum {

    public static void main(String[] args) {

        int[] array = {4,3,8,5,1,2,-5,4,3,8,5};
        System.out.println(findMaximumSubArraySum(array));
    }

    public static int findMaximumSubArraySum(int[] array) {

        int maxSum = array[0];
        int sum = array[0];

        for(int i=1; i<array.length; i++) {

            if(sum < 0)
                sum = array[i];
            else
                sum += array[i];

            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
