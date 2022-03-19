package generic.problems;

public class MaxSumOfSubarray {

    public static void main(String args[]){

        MaxSumOfSubarray maxSumOfSubarray = new MaxSumOfSubarray();
        int[] arr = {5,4,7,1,8,4,5,3,7,2};
        int subArrayLength = 4;

        System.out.println(maxSumOfSubarray.getSumOfSubarray(arr, subArrayLength));
    }

    public int getSumOfSubarray(int[] arr, int k) {

        int sumSubarray = 0;
        int windowSum = 0;
        int startIndex = 0;

        for(int endIndex =0; endIndex<arr.length; endIndex++) {

            windowSum += arr[endIndex];

            if(endIndex >= k-1) {
                sumSubarray = Math.max(sumSubarray, windowSum);
                windowSum -= arr[startIndex];
                startIndex++;
            }
        }

        return sumSubarray;
    }
}
