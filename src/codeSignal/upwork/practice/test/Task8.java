package codeSignal.upwork.practice.test;


import java.util.Arrays;

/**
 *
 *
 *      You're developing a new programming language with some unusual features for strings!
 *      Among these is a method that returns the longest palindrome that can be formed with the characters of a given string.
 *
 * Given a string s, your task is to find this longest possible palindrome. You may use any number of the characters from s,
 * and arrange them in any order (so long as it results in a palindrome).
 *
 * If there are multiple longest palindromes that can be formed, return the one among them that's lexicographically smallest.
 *
 * Example
 *
 * For s = "aaabb", the output should be solution(s) = "ababa".
 *
 * There are two possible palindromes of length 5 that can be obtained ("ababa" and "baaab"), but "ababa" is lexicographically smaller,
 * thus it is the answer.
 *
 * For s = "aaabbbcc", the output should be solution(s) = "abcacba".
 *
 * It's not possible to form a palindrome of length 8, but from several palindromes of length 7, "abcacba" is the lexicographically smallest,
 * thus it is the answer.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] string s
 *
 * The given string.
 *
 * Guaranteed constraints:
 * 1 ≤ s.length ≤ 105.
 *
 * [output] string
 *
 * The lexicographically smallest palindrome with maximal length that can be built from the given string s.
 *
 *
 *
 * */
public class Task8 {

    public static void main(String[] args) {

        Task8 task8 = new Task8();
        String s = "bzaaabb";
        String str = task8.solution(s);
        //System.out.println(str);
    }

    String solution(String s) {

        System.out.println(s.charAt(0));

        char[] array = s.toCharArray();
        System.out.println(array[0]);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        StringBuilder part1 = new StringBuilder();
        StringBuilder part2 = new StringBuilder();



        return null;
    }
}
