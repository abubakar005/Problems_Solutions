package hacker.rank.ventureDive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimizeArrayCost {

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1,3,5,2,10);
        List<Integer> arr2 = Arrays.asList(4,7,1,4);
        List<Integer> arr3 = Arrays.asList(4,7,7);
        System.out.println(getMinimumCost(arr3));
    }

    public static long getMinimumCost(List<Integer> arr) {

        long cost = findCost(arr);
        List<Integer> newArray;

        for(int i=0; i<arr.size()-1; i++) {
            newArray = new ArrayList<>(arr);
            int newVal = (arr.get(i) + arr.get(i+1))/2;
            newArray.add(i+1, newVal);

            cost = Math.min(cost, findCost(newArray));
        }

        return cost;
    }

    private static long findCost(List<Integer> arr) {
        long cost = 0;

        for(int i=0; i<arr.size()-1; i++) {
            long val = arr.get(i) - arr.get(i+1);
            cost += val*val;
        }

        return cost;
    }
}
