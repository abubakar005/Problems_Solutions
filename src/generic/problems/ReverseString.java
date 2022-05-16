package generic.problems;

public class ReverseString {

    public static void main(String args[]) {

        String input = "tu";
        int start = 0;
        int end = input.length()-1;
        char[] arr = input.toCharArray();

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        System.out.println(arr);
    }

}
