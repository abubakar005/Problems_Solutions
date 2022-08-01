public class Practice {

    public static void main(String[] args) {

        String str = "abcdefgh";
        int[] arr = {4, -4, 5, -1, -3, 4, -4};
        int[] test = {1, -2, 3, 4};

       System.out.println(maxProduct(test));
    }


    public static int maxProduct(int[] arr) {

        int result = arr[0];
        int min = 1;
        int max = 1;

        for(int i=0; i < arr.length; i++) {
            int temp = max*arr[i];
            max = Math.max(temp, min*arr[i]);
            min = Math.min(temp, min*arr[i]);

            result = Math.max(result, max);
        }


        return result;
    }

}
