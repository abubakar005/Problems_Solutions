package codility;

import java.util.HashSet;
import java.util.Set;

public class MissingPositiveNumber {

    public static void main(String[] args) {

        int[] a = {1, 3, 6, 4, 1, 2};
        int[] a2 = {-1, -3};

        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        Set<Integer> set = new HashSet<>();
        int n = A.length;
        int missing = 1;

        for(int i=0; i<A.length; i++)
            set.add(A[i]);

        for(int i=0; i<set.size(); i++) {
            if(!set.contains(missing))
                return missing;

            missing++;
        }

        return missing;
    }
}
