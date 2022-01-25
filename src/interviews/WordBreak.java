package interviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].


public class WordBreak {


    public static void main(String args[]){

        Set<String> wordDict = new HashSet<>();
        wordDict.add("leet");
        wordDict.add("code");

        String s = "leetcode";

        boolean result = wordBreak(s, wordDict);
        System.out.println("Result: " + result);
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                System.out.println("====: " + s.substring(j, i));
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }

            System.out.println("------------------------------------------");
        }

        System.out.println("Array: " + Arrays.toString(dp));
        return dp[s.length()];
    }

    @Override
    public String toString() {
        return "WordBreak{}";
    }
}
