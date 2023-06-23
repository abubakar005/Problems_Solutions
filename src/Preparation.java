import jpMorgan.Palindrome;

import java.util.List;
import java.util.stream.IntStream;

public class Preparation {

    public static void main(String[] args) {

        String str = "abba1";
        //System.out.println(isPalindrome2(str));
       // System.out.println(checkString("b"));

       /* List<String> list = List.of("1", "2");

        for(final String l: list) {
            final String a = l;
        }*/

        int[] A = { -1, 6, 3, 1, -2, 3, 3 };
        int[] A2 = {0, 4, -1, 0, 3 };
        // divide the array into two non-empty subarrays with equal sum
       // System.out.println(findBreakPoint(A2));
    }

    public static boolean isPalindrome(String str) {

        if(str.isEmpty())
            return false;

        int start = 0;
        int end = str.length()-1;

        while (start < end) {

            if(str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }

    public static boolean isPalindrome2(String str) {
        return IntStream.range(0, str.length() / 2)
                .noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
    }

    public static boolean checkString(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start < end){
            if(s.charAt(start) == 'b' && s.charAt(end) == 'a')
                return false;

            if(s.charAt(start) == 'a')
                start++;

            if(s.charAt(end) == 'b')
                end--;
        }

        return true;
    }


    public static int countIndex(int[] A)  {
        int count = 0;

        if (A.length == 0) {
            return 0;
        }

        int total = IntStream.of(A).sum();
        int left_sum = A[0];

        for (int i = 1; i < A.length - 1; i++) {
            if (left_sum == total - (A[i] + left_sum)) {
                count++;
            }

            left_sum += A[i];
        }

        return count;
    }

    static int countPairs(int arr[], int n)
    {
        int ans = 0;

        // for each index i and j
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)

                // finding the index with same
                // value but different index.
                if (arr[i] == arr[j])
                    ans++;
        return ans;
    }

}
