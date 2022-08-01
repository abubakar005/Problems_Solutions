package generic.problems;

public class ReverseStringWithoutSpecialCharacters {

    public static void main(String[] args) {

        ReverseStringWithoutSpecialCharacters obj = new ReverseStringWithoutSpecialCharacters();
        String str = "A,c,de!$";
        System.out.println("Output: " + obj.reverse(str));

    }

    public String reverse(String s) {

        if(s == null || s.isEmpty())
            return null;

        StringBuilder reverse = new StringBuilder(s);

        int left = 0;
        int right = s.length()-1;

        while (left < right) {

            if(Character.isAlphabetic(s.charAt(left)) && Character.isAlphabetic(s.charAt(right))) {
                char temp = s.charAt(left);
                reverse.setCharAt(left, s.charAt(right));
                reverse.setCharAt(right, temp);
                left++;
                right--;
            } else if(Character.isAlphabetic(s.charAt(left))) {
                right--;
            } else {
                left++;
            }
        }

        return reverse.toString();
    }


}
