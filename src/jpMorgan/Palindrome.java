package jpMorgan;

public class Palindrome {

    public static void main(String[] args) {

        String str = "abb";
        System.out.println(new Palindrome().isPalindrome(str));
    }

    public boolean isPalindrome(String str) {

        //if(str != null)

        try {

            char[] arr = str.toCharArray();
            int start = 0;
            int end = str.length()-1;

            while (start<end) {

                if(arr[start] != arr[end]) {
                    return false;
                }

                start++;
                end--;

            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
