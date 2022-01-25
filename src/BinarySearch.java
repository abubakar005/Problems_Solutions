public class BinarySearch {

    public static void main(String args[]){

        int[] array = {1,2,3,4,5,5,5,5,6,7,8,9};
        int result = findNumber(1, array, 0, array.length);
        System.out.println("result: " + result);
    }

    public static int findNumber(int num, int[] array, int start, int end){

        if(start < end) {

            int mid = (end+start)/2;
            System.out.println("mid: " + mid);

            if(array[mid] == num)
                return mid;

            if(num > array[mid])
                return findNumber(num, array, mid+1, end);

            else
                return findNumber(num, array, start, mid-1);
        }

        return -1;
    }
}
