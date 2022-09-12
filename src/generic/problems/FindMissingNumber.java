package generic.problems;

public class FindMissingNumber {

    public static void main(String[] args) {

        int[] a = { 1, 5, 2, 3, 4, 7, 8};
        int[] a2 = {-1, -3};

        System.out.println(findDisappearedNumbers(a2));
    }

    public static int findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        int sum = ((n+1)*(n+2))/2;

        for(int i=0; i<n; i++)
            sum -= nums[i];

        return sum;
    }
}
