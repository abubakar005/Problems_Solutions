package codility;

import java.math.BigInteger;

public class Problems {

    public static void main(String[] args) {
        //solution();

        System.out.println(maxSubstringCount("ababa"));
    }

    public static void  solution() {

        StringBuilder builder = new StringBuilder("");

        for(int i=1; i<=400000; i++)
            builder.append("1");


        long V = new BigInteger(builder.toString(), 2).longValue();
        long count = 0;

        while (V != 0) {
            count++;
            if(V%2 == 0)
                V = V/2;
            else
                --V;
        }

        System.out.println(count);
    }



    static int maxSubStrings(String str) {

        // To store the count of 0s and 1s
        int count_a = 0, count_b = 0;


        // To store the count of maximum
        // substrings str can be divided into
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'a')
            {
                count_a++;
            }
            else
            {
                count_b++;
            }
            if (count_a == count_b)
            {
                cnt++;
            }
        }

        // It is not possible to
        // split the string
        if (count_a != count_b)
        {
            return -1;
        }

        return cnt;
    }


    static int splitstring(String s)
    {
        int n = s.length();

        // Calculating the total
        // number of zeros
        int count_a = 0;

        for(int i = 0; i < n; i++)
            if (s.charAt(i) == 'a')
                count_a++;

        // Case1
        // If total count of zeros is not
        // divisible by 3
        if (count_a % 3 != 0)
            return 0;

        // Case2
        // if total count of zeros
        // is zero
        if (count_a == 0)
            return ((n - 1) * (n - 2)) / 2;

        // Case3
        // General case

        // Number of zeros in each substring
        int zerosInEachSubstring = count_a / 3;

        // Initialising zero to the number of ways
        // for first and second cut
        int waysOfFirstCut = 0;
        int waysOfSecondCut = 0;

        // Initializing the count
        int count = 0;

        // Traversing from the beginning
        for(int i = 0; i < n; i++)
        {

            // Incrementing the count
            // if the element is '0'
            if (s.charAt(i) == 'a')
                count++;

            // Incrementing the ways for the
            // 1st cut if count is equal to
            // zeros required in each substring
            if (count == zerosInEachSubstring)
                waysOfFirstCut++;

                // Incrementing the ways for the
                // 2nd cut if count is equal to
                // 2*(zeros required in each substring)
            else if (count == 2 * zerosInEachSubstring)
                waysOfSecondCut++;
        }

        // Total number of ways to split is
        // multiplication of ways for the 1st
        // and 2nd cut
        return waysOfFirstCut * waysOfSecondCut;
    }

    static int maxSubstringCount(String s) {

        int noOfSubstrings = 3;
        int length = s.length();
        int count_a;
        int aInEachSubstring;
        int countFirst = 0, countSecond = 0, countOfA = 0;

        count_a = (int) s.chars().filter(c-> c == 'a').count();

        if (count_a % noOfSubstrings != 0)
            return 0;

        if (count_a == 0)
            return ((length - 1) * (length - 2)) / 2;

        aInEachSubstring = count_a/noOfSubstrings;

        int index = 0;
        while (index < length) {
            countOfA = s.charAt(index)=='a'? ++countOfA:countOfA;
            countFirst = countOfA == aInEachSubstring? ++countFirst: countFirst;
            countSecond = countOfA == 2 * aInEachSubstring ? ++countSecond: countSecond;

            index++;
        }

        return countFirst * countSecond;
    }




}
