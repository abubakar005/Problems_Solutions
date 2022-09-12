package andela;

public class ReversSubString {

    /*
    input -  abcd(efg)hijk
    output - abcd(gfe)hijk

    input -  abcd(efg)hijk(lmn)opq
    output - abcd(gfe)hijk(nml)opq

    input -  abcd
    output - abcd

    input -  (abcd)
    output - (dcba)

    There will be no nested parenthesis
    For every '(' there will be a ')'

*/

    public static void main(String[] args) {

        String input =  "abcd(efg)hijk(lmn)opq";
        String input2 = "(abcd)";
        System.out.println(reversSubStrings(input));
    }

    public static String reversSubStrings(String input) {

        StringBuilder sb = new StringBuilder(input);
        int count = 0;
        int start;
        int end;

        while (count < input.length()) {

            if(input.charAt(count) == '(') {

                start = ++count;

                while (input.charAt(count) != ')') {
                    count++;
                }

                end = count-1;

                while (start < end) {
                    char temp = input.charAt(start);
                    sb.setCharAt(start, input.charAt(end));
                    sb.setCharAt(end, temp);
                    start++;
                    end--;
                }

                input = sb.toString();
            }

            count++;
        }

        return sb.toString();
    }

    // Not working for more than one substrings
    public static String reversSubString(String input) {

        int start = 0;
        int end = input.length()-1;
        StringBuilder sb = new StringBuilder(input);

        while(start < end) {

            if(input.charAt(start) == '(' && input.charAt(end) == ')') {

                start++;
                end--;

                while(start < end) {
                    char temp = input.charAt(start);
                    sb.setCharAt(start, input.charAt(end));
                    sb.setCharAt(end, temp);
                    start++;
                    end--;
                }

                if(input.contains("(")) {
                    input = sb.toString();
                }

            } else if(input.charAt(start) == '('){
                end--;
            } else if(input.charAt(end) == ')') {
                start++;
            } else {
                start++;
                end--;
            }
        }

        return sb.toString();
    }
}
