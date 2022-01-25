import java.util.Arrays;
import java.util.HashMap;

public class ArrayQuestion {


    public static void main(String[] ags) {


       int[] nums = {2,7,11,15};

        System.out.println("Result: " + Arrays.toString(getArrayIndeces(nums)));

    }

    public static int[] getArrayIndeces(int[] array) {

        int[] response = new int[2];
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int target = 9;

        for(int i=0; i<array.length; i++) {


            if(hashmap.containsKey(target-array[i])) {

                response[1] = i;
                response[0] = hashmap.get(target-array[i]);
                return response;
            } else {
                hashmap.put(array[i], i);
            }
        }

        return response;
    }
}
