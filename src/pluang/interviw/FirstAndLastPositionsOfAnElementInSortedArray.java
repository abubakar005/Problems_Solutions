package pluang.interviw;

import java.util.Arrays;

public class FirstAndLastPositionsOfAnElementInSortedArray {

    public static void main(String args[]){

        int[] array = {1,1,2,3,4,5,5,5,5,6,7,8,9,9,9,9};
    //    int arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}
        int findNumber = 9;
        int[] result = {-1, -1};

        int firstOccurrence = findFirstOccurrence(findNumber, array, 0, array.length);
        int lastOccurrence = findLastOccurrence(findNumber, array, 0, array.length);

        // It will give the result if a number have two occurrences in the array
        if(firstOccurrence != -1 && firstOccurrence!=lastOccurrence) {
            result[0] = firstOccurrence;
            result[1] = lastOccurrence;
        }

        System.out.println("Indices Found: " + Arrays.toString(result));
    }

    public static int findFirstOccurrence(int num, int[] array, int start, int end){

        if(end > start) {

            int mid = (end+start)/2;

            if(array[mid] == num && (mid == 0 || num > array[mid - 1]))
                return mid;

            if(num > array[mid])
                return findFirstOccurrence(num, array, (mid+1), end);
            else
                return findFirstOccurrence(num, array, start, (mid-1));
        }

        return -1;
    }

    public static int findLastOccurrence(int num, int[] array, int start, int end){

        if(end > start) {

            int mid = (end+start)/2;

            if(array[mid] == num && (mid == array.length-1 || num < array[mid+1]))
                return mid;

            if(num < array[mid])
                return findLastOccurrence(num, array, start, (mid-1));
            else
                return findLastOccurrence(num, array, (mid+1), end);
        }

        return -1;
    }
}
