package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[] {69})));
    }

    public static int[] sort(int[] array) {

        int temp;
        int j;
        boolean swapped;

        for(int i=0; i<array.length-1; i++) {

            j = 0;
            swapped = false;

            while (j<array.length-i-1) {

                if(array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }

                j++;
            }

            if (!swapped)
                break;
        }

        return array;
    }
}
