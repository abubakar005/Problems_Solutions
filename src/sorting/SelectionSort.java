package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sort(new int[] {69, 14, 1, 50, 59})));
    }

    public static int[] sort(int[] input) {

        int minIndex;

        for(int i=0; i<input.length-1; i++) {

            minIndex = i;

            for(int j=i+1; j<input.length; j++) {

                if(input[j] < input[minIndex])
                    minIndex = j;
            }

            // swapping
            int temp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = temp;
        }

        return input;
    }
}
