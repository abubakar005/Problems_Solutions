package generic.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

    public static void main(String args[]){

        LongestUniqueSubstring longestUniqueSubstring = new LongestUniqueSubstring();
        int length = longestUniqueSubstring.getLongestUniqueSubstringLength("abscarfscg");
        System.out.println("Length: " + length);
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
}
