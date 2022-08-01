package generic.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestUniqueSubstring {

    public static void main(String args[]){

        LongestUniqueSubstring longestUniqueSubstring = new LongestUniqueSubstring();
        String s = "abcbfghabb";
        int length = longestUniqueSubstring.getLongestUniqueSubstringLength(s);
        System.out.println("Length 1: " + length);

        System.out.println("Length 2: " + longestUniqueSubstring.lengthOfLongestSubstring(s));
    }

    public int getLongestUniqueSubstringLength(String str) {

        int length = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap();

        for(int end=0; end<str.length(); end++) {

            if(map.containsKey(str.charAt(end)))
                start = Math.max(start, map.get(str.charAt(end))+1);

            map.put(str.charAt(end), end);
            length = Math.max(length, end-start+1);
        }

        return length;
    }

    public int lengthOfLongestSubstring(String str) {

        int a = 0;
        int b = 0;
        int max = 0;

        Set<Character> set = new HashSet<>();

        while (b < str.length()) {

            if(!set.contains(str.charAt(b))) {
                set.add(str.charAt(b));
                b++;
                max = Math.max(max, set.size());
            } else {
                set.remove(str.charAt(a));
                a++;
            }
        }

        return max;
    }
}
