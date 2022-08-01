package test;

import java.util.HashSet;
import java.util.Set;

public class LongestString {


    public static void main(String args[]){

        System.out.println(getStringLength("abcabcdb"));
    }

    // n2 and wrong implementation
    public static int getStringLength(String input) {

        StringBuilder result = new StringBuilder("");
        int longestLength = 0;

        for(int i=0; i<input.length()-1; i++) {

            for(int j=i; j<input.length(); j++) {

                if(result.toString().contains(String.valueOf(input.charAt(j)))) {

                    if(result.length() > longestLength) {
                        longestLength = result.length();
                        result = new StringBuilder("");
                    }
                }
                else {
                    result.append(input.charAt(j));
                }
            }

        }

       // length = result.length();


        return longestLength;
    }

    public static int longestSubstring(String str) {

        int maxLength = 0;

        if(str == null || str.isEmpty())
            return maxLength;

        Set<Character> set = new HashSet<>();

        int start = 0;
        int end = 0;

        for(; end < str.length(); end++) {

            if(set.contains(str.charAt(end))) {

            }

            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }
}
