import java.util.*;

public class Practice {

    public static void main(String[] args) {

        String str = "abcdefgh";
        int[] arr = {4, -4, 5, -1, -3, 4, -4};
        int[] test = {1, -2, 3, 4};

        //test();

        int[] array = {1,2,3,4,5,5,5,5,6,7,8,9,9};
        System.out.println(findNum(9, 0, array.length-1, array));

       //System.out.println(maxProduct(test));
       // System.out.println(wordBreak("leetcode", new HashSet<>(Arrays.asList("leet", "code2", "leetcode"))));
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

    public static boolean wordBreak(String s, Set<String> wordDict) {
        return false;
    }

   public static void test() {

       int[] array = {1,2,3,4,5,5,5,5,6,7,8,9,9};
       int searchNum = 9;
       int start = 0;
       int last = array.length-1;
       int firstindex = -1;
       int lstindex = -1;

       /*while (start <= last && (array[start] != searchNum || array[last] != searchNum)) {

           if(array[start] == searchNum)
               last--;
           else if (array[last] == searchNum)
               start++;
           else {
               start++;
               last--;
           }
       }

       if(array[start] == searchNum && array[last] == searchNum) {
           firstindex = start;
           lstindex = last;
       }*/





       /*for(int i=0; i<array.length; i++) {

           if(array[i] == searchNum) {

               boolean b = i + 1 == array.length || array[i + 1] != searchNum;

               if(first == -1) {
                   first = i;

                   if(b) {
                       last = i;
                       break;
                   }
               } else if(b) {
                   last = i;
                   break;
               }
           }
       }*/

       System.out.println("first: " + firstindex + " last: " + lstindex);
   }

   public static int findNum(int num, int start,int end, int[] array) {

       int mid = (start+end)/2;

       if(array[mid] == num && (mid == 0 || array[mid-1] != num))
           return mid;

       if(num > array[mid])
           return findNum(num, mid+1, end, array);
       else
           return findNum(num, start, mid-1, array);
   }

    public static int findMaxIndex(int num, int start,int end, int[] array) {

        int mid = (start+end)/2;

        if(array[mid] == num && (mid == array.length-1 || array[mid+1] != num))
            return mid;

        if(num < array[mid])
            return findMaxIndex(num, start, mid-1, array);
        else
            return findMaxIndex(num, mid+1, end, array);
    }
}
