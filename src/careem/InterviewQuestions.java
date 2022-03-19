package careem;

import java.util.*;

public class InterviewQuestions {

    public static void main(String[] ags) {

        InterviewQuestions careem = new InterviewQuestions();
        String str = "A quick brown fox jumped over the lazy dog";

        Map<Character, Integer> result = careem.getCountCharacters(str);

        System.out.println(result);
        // careem.getPrimeFactors (24);
        careem.getCountCharacters2(str);

    }

    public Map<Character, Integer> getCountCharacters(String str) {

        Map<Character, Integer> chars = new HashMap<>();

        for(int i=0; i<str.length(); i++) {

            char ch = str.charAt(i);    // n
            if(chars.containsKey(ch)) { // n
                chars.put(ch, chars.get(ch)+1);
            } else {
                chars.put(ch, 1);
            }
        }

        return chars;
    }

    public char[] getCountCharacters2(String str) {

        char[] chars = new char[26];

        // Create an array of size 256
        // i.e. ASCII_SIZE
        int count[] = new int[256];

        int len = str.length();

        // Initialize count array index
        for (int i = 0; i < len; i++) {
            System.out.println(str.charAt(i));
            int ch = str.charAt(i);
            System.out.println(ch);
            count[str.charAt(i)]++;
        }

        System.out.println(Arrays.toString(count));
        return chars;
    }


    /** Find Prime numbers of a number */
    public int[] getPrimeFactors (int num) {

        int[] array = new int[0];
        List<Integer> list = new ArrayList<>();


        for(int i=2; i<num; i++) {

            while (num%i == 0) {
                list.add(i);
                num = num/i;
            }
        }

        if(num > 1)
            list.add(num);

        System.out.println(list);
        return array;
    }



    /**
     *


     You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

     Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
     Return the maximum number of points you can earn by applying the above operation some number of times.


     You are given an integer
     Example 1:

     Input: nums = [3,4,2]
     Output: 6
     Explanation: You can perform the following operations:
     - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
     - Delete 2 to earn 2 points. nums = [].
     You earn a total of 6 points.
     Example 2:

     Input: nums = [2,2,3,3,3,4]
     Output: 9
     Explanation: You can perform the following operations:
     - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
     - Delete a 3 again to earn 3 points. nums = [3].
     - Delete a 3 once more to earn 3 points. nums = [].
     You earn a total of 9 points.



     Input: nums = [2,2,3,3,3,4,4,5]

     [4,9,8,5]

     [4]
     Input: nums = [2, 3,4, 10]  => [2]
     points = 4 +2 = 6

     points = 10 + 6 = 16

     * */

    public int getSum() {

        int greaterSum = 0;
        int[] sumArray = {};

        /*for(int i=1; i<sumArray.length-1; i++) {

            if(sumArray[i-1] + sumArray[i+1] > sumArray[i])
                sumArray = sumArray[i-1] + sumArray[i+1];
        }*/

        return 0;
    }
}
