package hacker.rank.careem;

import java.util.*;

/**
 *  Problem statement: Remove duplicate by incrementing that duplicate number by 1 and return sum that should be minimum sum
 *  Initial array {1,2,3,2,6,7}
 *  Unique Array {1,2,3,4,6,7}    and sum is = 23
 */
public class SumOfUniqueArray {

    public static void main(String[] ags) {

        SumOfUniqueArray sumOfUniqueArray = new SumOfUniqueArray();

        List<Integer> arr = Arrays.asList(1,2,3,2,6,7);

        int result = sumOfUniqueArray.uniqueSum(arr);
        System.out.println(result);
    }

    public int uniqueSum(List<Integer> arr) {

        int sum = 0;
        Set<Integer> set = new HashSet();

        for(int i=0; i<arr.size(); i++) {

            int number = arr.get(i);
            while(set.contains(number))
                number += 1;

            set.add(number);
            sum += number;
        }

        return sum;
    }
}
