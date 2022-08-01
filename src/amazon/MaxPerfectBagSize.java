package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxPerfectBagSize {

    public static void main(String[] args) {

        int[] test = {3,9,4,2,16};
        List<Integer> list = Arrays.asList(3,9,4,2,16);
        List<Integer> list1 = Arrays.asList(625, 4, 2, 5, 25);
        List<Integer> list2 = Arrays.asList(7, 4, 8, 9);
        System.out.println(maxSetSize(list1));
    }

    public static int maxSetSize(List<Integer> riceBags) {
        // Write your code here
        System.out.println(riceBags);
        if(riceBags == null || riceBags.size() == 1)
            return -1;

        Set<Integer> set = new HashSet<>(riceBags);

        //Collections.sort(riceBags);
        int count;
        int res = 0;
        //int maxValue = riceBags.get(riceBags.size()-1);
        Integer maxValue = riceBags.stream().max(Integer::compare).get();

        for(int i=0; i<riceBags.size(); i++) {

            int temp = riceBags.get(i);
            count = 0;

            while (temp <= maxValue) {
                count++;

                if(set.contains(temp*temp)) {
                    temp = temp*temp;
                } else
                    break;
            }

            res = Math.max(res, count);
        }

        return res == 1 ? -1 : res;
    }



}
