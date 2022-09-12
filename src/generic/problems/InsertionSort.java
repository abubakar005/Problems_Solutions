package generic.problems;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String args[]){

        int arr[] = { 12, 11, 13, 5, 6 };

        InsertionSort ob = new InsertionSort();
        ob.sort2(arr);

        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {

        for(int i=1; i<arr.length; i++) {

            int value = arr[i];
            int index = i;

            for(int j=i-1; j>=0; j--) {

                if(arr[j] > value) {
                    arr[j+1] = arr[j];
                    index = j;
                }

            }

            arr[index] = value;
        }
    }

    // Better approach
    private void sort2(int[] arr) {

        for(int i=1; i<arr.length; i++) {

            int value = arr[i];
            int j = i-1;

            while(j>=0 && arr[j] > value) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = value;
        }
    }
}
