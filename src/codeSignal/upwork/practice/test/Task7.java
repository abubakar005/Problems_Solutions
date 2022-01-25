package codeSignal.upwork.practice.test;


/**
 *
 *      You are given an array of strings arr. Your task is to construct a string from the words in arr, starting with the 0th character from each word (in the order they appear in arr), followed by the 1st character, then the 2nd character, etc. If one of the words doesn't have an ith character, skip that word.
 *
 * Return the resulting string.
 *
 * Example
 *
 * For arr = ["Daisy", "Rose", "Hyacinth", "Poppy"], the output should be solution(arr) = "DRHPaoyoisapsecpyiynth".
 *
 * First, we append all 0th characters and obtain string "DRHP";
 * Then we append all 1st characters and obtain string "DRHPaoyo";
 * Then we append all 2nd characters and obtain string "DRHPaoyoisap";
 * Then we append all 3rd characters and obtain string "DRHPaoyoisapaecp";
 * Then we append all 4th characters and obtain string "DRHPaoyoisapaecpyiy";
 * Finally, only letters in the arr[2] are left, so we append the rest characters and get "DRHPaoyoisapaecpyiynth";
 * example
 *
 * For arr = ["E", "M", "I", "L", "Y"], the output should be solution(arr) = "EMILY".
 *
 * Since each of these strings have only one character, the answer will be concatenation of each string in order, so the answer is EMILY.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] array.string arr
 *
 * An array of strings containing alphanumeric characters.
 *
 * Guaranteed constraints:
 * 1 ≤ arr.length ≤ 100,
 * 1 ≤ arr[i].length ≤ 100.
 *
 * [output] string
 *
 * Return the resulting string.
 *
 *
 * */
public class Task7 {

    public static void main(String[] args) {

        Task7 task7 = new Task7();
        String[] arr = {"hello", "java", "my", "teck"};
        String str = task7.solution(arr);
        System.out.println(str);
    }

    String solution(String[] arr) {

        int maxLength = 0;
        StringBuilder builder = new StringBuilder();

        for(int i=0; i< arr.length; i++) {

            if(arr[i].length() > maxLength)
                maxLength = arr[i].length();
        }

        for(int j=0; j<maxLength; j++) {

            for(int k=0; k<arr.length; k++) {

                if(arr[k].length() > j)
                    builder.append(arr[k].charAt(j));
            }
        }


        return builder.toString();
    }

}
