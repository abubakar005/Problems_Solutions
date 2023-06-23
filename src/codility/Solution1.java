package codility;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Solution1 {

    public int findUniqueCount(String s) {
        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++)
            set.add(s.charAt(i));

        return set.size();
    }

    public int solution02(String P, String Q) {
        List<String> list = new ArrayList<>();
        AtomicInteger count = new AtomicInteger(26);

        for (int i = 0; i < P.length(); i++) {
            char charP = P.charAt(i);
            char charQ = Q.charAt(i);

            if (list.isEmpty()) {
                list.add(String.valueOf(charP));
                list.add(String.valueOf(charQ));
            } else {
                List<String> temp = new ArrayList<>();

                list.forEach(s -> {
                    temp.add(s + charP);
                    temp.add(s + charQ);
                });

                list = temp;
            }
        }

        list.forEach(s -> count.updateAndGet(val -> Math.min(val, findUniqueCount(s))));

        return count.get();
    }

    public int solution2(String P, String Q) {
        Set<Character> distinctLetters = new HashSet<>();
        List<String> list = new ArrayList<>();
        int count = 26;

        for (int i = 0; i < P.length(); i++) {
            char charP = P.charAt(i);
            char charQ = Q.charAt(i);

            if(!distinctLetters.contains(charP)) {
                distinctLetters.add(charP);
                list.add(String.valueOf(charP));
            }

            if(!distinctLetters.contains(charQ)) {
                distinctLetters.add(charQ);
                list.add(String.valueOf(charQ));
            }
        }

        for(String s : list) {
            System.out.println(s);
            count = Math.min(count, findUniqueCount(s));
        }

        return count;
    }

    public static void main(String[] args) {

        Solution1 piChallenge = new Solution1();

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

        int x, y, z;

        x=9; y=10;

        z=++x+y++;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
       // System.out.println(piChallenge.solutionj(P0, Q0)); // 1
        //System.out.println(piChallenge.solutionj(P, Q)); // 2
        //System.out.println(piChallenge.solutionj(P1, Q1)); // 2
       // System.out.println(piChallenge.solutionj(P2, Q2)); // 1
        //System.out.println(piChallenge.solutionj(P3, Q3)); // 3
    }

    public int solution0(String P, String Q) {
        int bitmask = 0;

        for (char c : P.toCharArray()) {
            bitmask |= (1 << (c - 'a'));
        }

        for (char c : Q.toCharArray()) {
            bitmask |= (1 << (c - 'a'));
        }

        int count = 0;
        while (bitmask > 0) {
            bitmask &= (bitmask - 1);
            count++;
        }

        return count;
    }

    public int solution(String P, String Q) {
        int minDistinctCount = 26;

        for (char c = 'a'; c <= 'z'; c++) {
            String S = P.replace(c, ' ').concat(Q.replace(c, ' '));
            int distinctCount = countDistinctLetters(S);
            minDistinctCount = Math.min(minDistinctCount, distinctCount);
        }

        return minDistinctCount;
    }

    private int countDistinctLetters(String str) {
        boolean[] seen = new boolean[26];
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z' && !seen[c - 'a']) {
                seen[c - 'a'] = true;
                count++;
            }
        }

        return count;
    }




        private void dfs(int have, int now, int state, boolean[][] mark, int num, int[] ans) {
            if (num >= ans[0]) {
                return;
            }
            int mask = 1 << now;
            if (mask > have) {
                ans[0] = num;
                return;
            }
            if ((mask & have) == 0) {
                dfs(have, now + 1, state, mark, num, ans);
            } else {
                int temp = 0, d = 0;
                for (int i = now + 1; i < 26; ++i) {
                    if (mark[i][now] && (have & (1 << i)) > 0) {
                        temp |= 1 << i;
                        ++d;
                    }
                }
                dfs(have ^ temp, now + 1, state | temp, mark, num + d, ans);
                dfs(have, now + 1, state | mask, mark, num + 1, ans);
            }
        }

        public int solutionj2(String P, String Q) {
            boolean[][] mark = new boolean[26][26];
            int n = P.length();
            for (int i = 0; i < n; ++i) {
                int p = P.charAt(i) - 'a';
                int q = Q.charAt(i) - 'a';
                mark[p][q] = mark[q][p] = true;
            }
            int temp = 0;
            for (int i = 0; i < 26; ++i) {
                if (mark[i][i]) {
                    ++temp;
                    for (int j = 0; j < 26; ++j) {
                        mark[i][j] = mark[j][i] = false;
                    }
                }
            }
            int have = 0;
            for (int i = 0; i < 26; ++i) {
                for (int j = 0; j < 26; ++j) {
                    if (mark[i][j]) {
                        have |= 1 << i;
                        break;
                    }
                }
            }
            int[] ans = { n };
            dfs(have, 0, 0, mark, temp, ans);
            return ans[0];
        }

    private static int solutionj(String P, String Q) {
        HashMap<Character,Boolean> existsInOtherString =new HashMap<>();
        int min = 0;
        for(int i = 0; i< P.length(); i++){
            if(!existsInOtherString.containsKey(P.charAt(i))){
                existsInOtherString.put(P.charAt(i), Q.contains(String.valueOf((P.charAt(i)))));
                if(Q.contains(String.valueOf((P.charAt(i))))) {
                    min++;
                }
            }
        }
        return min;
    }




}


