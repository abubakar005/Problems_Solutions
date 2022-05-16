package codility;

import java.util.Arrays;

public class AverageOfKLengthArrayElements {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,9,15};
        int k = 3;
        System.out.println(Arrays.toString(getAvgArray(arr, k)));
    }

    private static double[] getAvgArray(int[] arr, int k) {

        double[] res = new double[arr.length-(k-1)];
        int start = 0;
        double sum = 0;

        for(int end=0; end<arr.length; end++) {

            if(end > k-1) {
                double d = sum/k;
                res[start] = d;
                sum -= arr[start];
                start++;
            }

            sum += arr[end];
        }

        res[start] = sum/k;

        return res;
    }
}
