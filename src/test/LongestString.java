package test;

public class LongestString {


    public static void main(String args[]){

        System.out.println(getStringLength("abcabcdb"));
    }

    public static int getStringLength(String input) {

        StringBuilder result = new StringBuilder("");
        int longestLength = 0;

        for(int i=0; i<input.length()-1; i++) {

            for(int j=i; j<input.length(); j++) {

                if(result.toString().contains(String.valueOf(input.charAt(j)))) {

                    if(result.length() > longestLength) {
                        longestLength = result.length();
                        result = new StringBuilder("");
                    }
                }
                else {
                    result.append(input.charAt(j));
                }
            }

        }

       // length = result.length();


        return longestLength;
    }
}
