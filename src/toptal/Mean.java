package toptal;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Mean {

    // you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    class Solution {
        public int solution(int[] A, int S) {
            // write your code in Java SE 8
            HashMap<Integer, Integer> prefixes = new HashMap<Integer, Integer>();
            int result = 0;
            int[] P = new int[A.length + 1];
            prefixes.put(0, 1);

            int[] Q = new int[A.length + 1];
            P[0] = 0;
            Q[0] = 0;

            for (int i = 1; i < A.length + 1; i++) {
                P[i] = P[i - 1] + A[i - 1];
                Q[i] = P[i] - S * i;

                if (!prefixes.containsKey(Q[i])) {
                    prefixes.put(Q[i], 1);
                } else {
                    Integer temp=prefixes.get(Q[i]);
                    temp++;
                    prefixes.put(Q[i],temp);
                }
            }

            for (Map.Entry<Integer, Integer> entry : prefixes.entrySet()) {
                int value = entry.getValue();
                result += value * (value - 1) / 2;
            }

            return result > 1000000000 ? 1000000000 : result;
        }
    }

}
