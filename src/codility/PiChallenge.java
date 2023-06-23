package codility;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 We are given two strings P and Q, each consisting of N lowercase English letters. For each position in the strings, we have to choose one letter from either P or Q, in order to construct a new string S, such that the number of distinct letters in S is minimal. Our task is to find the number of distinct letters in the resulting string S.

 For example, if P = "ca" and Q = "ab", S can be equal to: "ca", "cb", "aa" or "ab". String "aa" has only one distinct letter ('a'), so the answer is 1 (which is minimal among those strings).

 Write a function:

 class Solution { public int solution(String P, String Q); }

 that, given two strings P and Q, both of length N, returns the minimum number of distinct letters of a string S, that can be constructed from P and Q as described above.

 Examples:

 1. Given P = "abc", Q = "bcd", your function should return 2. All possible strings S that can be constructed are: "abc", "abd", "acc", "acd", "bbc", "bbd", "bcc", "bcd". The minimum number of distinct letters is 2, which be obtained by constructing the following strings: "acc", "bbc", "bbd", "bcc".

 2. Given P = "axxz", Q = "yzwy", your function should return 2. String S must consist of at least two distinct letters in this case. We can construct S = "yxxy", where the number of distinct letters is equal to 2, and this is the only optimal solution.

 3. Given P = "bacad", Q = "abada", your function should return 1. We can choose the letter 'a' in each position, so S can be equal to "aaaaa".

 4. Given P = "amz", Q = "amz", your function should return 3. The input strings are identical, so the only possible S that can be constructed is "amz", and its number of distinct letters is 3.

 Write an efficient algorithm for the following assumptions:

 N is an integer within the range [1..200,000];
 strings P and Q are both of length N;
 strings P and Q are made only of lowercase letters (a−z);
 strings P and Q contain a total of at most 20 distinct letters.
 */
public class PiChallenge {

    public int solution0(String P, String Q) {
        Set<Character> distinctLetters = new HashSet<>();
        List<String> list = new ArrayList<>();
        AtomicInteger count = new AtomicInteger(26);

        for (int i = 0; i < P.length(); i++) {
            char charP = P.charAt(i);
            char charQ = Q.charAt(i);

            if(list.size() == 0) {
                list.add(String.valueOf(charP));
                list.add(String.valueOf(charQ));
            } else {
                List<String> temp = new ArrayList<>();

                for(int j=0; j<list.size(); j++) {
                    temp.add(list.get(j)+ charP);
                    temp.add(list.get(j)+ charQ);
                }

                list = temp;
            }
        }

        list.forEach(s -> {
            int val = findUniqueCount(s);
            count.set(val < count.get() ? val : count.get());
        });

        return count.get();
    }

    public int findUniqueCount(String s) {
        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++)
            set.add(s.charAt(i));

        return set.size();
    }

    public static void main(String[] args) {

        PiChallenge piChallenge = new PiChallenge();

        String P = "abc";
        String Q = "bcd";

        String P0 = "ca";
        String Q0 = "ab";

        String P1 = "axxz";
        String Q1 = "yzwy";

        String P2 = "bacad";
        String Q2 = "abada";

        String P3 = "amz";
        String Q3 = "amz";

        System.out.println(piChallenge.solution0(P0, Q0)); // 1
        System.out.println(piChallenge.solution0(P, Q)); // 2
        System.out.println(piChallenge.solution0(P1, Q1)); // 2
        System.out.println(piChallenge.solution0(P2, Q2)); // 1
        System.out.println(piChallenge.solution0(P3, Q3)); // 3
    }


        // working for 1, 2, 5 lines
    public int solution2(String P, String Q) {
        Set<Character> commonLetters = new HashSet<>();
        int minDistinctCount = 26; // Initialize with the maximum possible value

        // Find common letters between P and Q
        for (char c = 'a'; c <= 'z'; c++) {
            if (P.indexOf(c) != -1 && Q.indexOf(c) != -1) {
                commonLetters.add(c);
            }
        }

        // Update minDistinctCount with the size of commonLetters
        minDistinctCount = Math.min(minDistinctCount, commonLetters.size());

        return minDistinctCount;
    }

    // working for 2, 3 lines
    public int solution3(String P, String Q) {
        Set<Character> distinctLetters = new HashSet<>();
        int minDistinctCount = 26; // Initialize with the maximum possible value

        for (int i = 0; i < P.length(); i++) {
            char charP = P.charAt(i);
            char charQ = Q.charAt(i);

            distinctLetters.add(charP);
            distinctLetters.add(charQ);

            minDistinctCount = Math.min(minDistinctCount, distinctLetters.size());
        }

        return minDistinctCount;
    }

    public int solution(String P, String Q) {
        Set<Character> distinctLetters = new HashSet<>();
        int count = 0;

        for (int i = 0; i < P.length(); i++) {
            char charP = P.charAt(i);
            char charQ = Q.charAt(i);

            if (!distinctLetters.contains(charP)) {
                distinctLetters.add(charP);
                count++;
            }

            if (!distinctLetters.contains(charQ)) {
                distinctLetters.add(charQ);
                count++;
            }
        }

        return count;
    }

    public int solution4(String P, String Q) {
        int minDistinctCount = 26; // Initialize with the maximum possible value

        for (int i = 0; i < P.length(); i++) {
            int countP = getCountOfDistinctLetters(P, Q, i);
            int countQ = getCountOfDistinctLetters(Q, P, i);

            minDistinctCount = Math.min(minDistinctCount, Math.min(countP, countQ));
        }

        return minDistinctCount;
    }

    private int getCountOfDistinctLetters(String str1, String str2, int index) {
        Set<Character> distinctLetters = new HashSet<>();

        for (int i = 0; i < str1.length(); i++) {
            if (i == index) {
                distinctLetters.add(str1.charAt(i));
            } else {
                distinctLetters.add(str2.charAt(i));
            }
        }

        return distinctLetters.size();
    }

    public static int solution5(String P, String Q) {
        // Create a map to store the frequency of each letter in P and Q.
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : P.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        for (char c : Q.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Initialize the minimum number of distinct letters to the number of letters in P and Q.
        int minDistinctLetters = frequencyMap.size();

        // Iterate over all possible combinations of letters from P and Q.
        // This can be done using a bitmask, where each bit represents a different letter.
        for (int i = 0; i < (1 << frequencyMap.size()); i++) {
            // Create a new string S from the current combination of letters.
            String S = "";
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                if (((i >> entry.getValue()) & 1) != 0) {
                    S += entry.getKey();
                }
            }

            // Update the minimum number of distinct letters if S has fewer distinct letters than the current minimum.
            minDistinctLetters = Math.min(minDistinctLetters, getDistinctLetters(S));
        }

        // Return the minimum number of distinct letters.
        return minDistinctLetters;
    }

    private static int getDistinctLetters(String S) {
        // Create a set to store the distinct letters in S.
        Set<Character> distinctLetters = new HashSet<>();
        for (char c : S.toCharArray()) {
            distinctLetters.add(c);
        }

        // Return the size of the set, which is the number of distinct letters in S.
        return distinctLetters.size();
    }
}
