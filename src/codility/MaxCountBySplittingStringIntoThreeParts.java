package codility;

public class MaxCountBySplittingStringIntoThreeParts {



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
