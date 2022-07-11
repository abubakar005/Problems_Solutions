package generic.problems;

public class FindMissingNumber {

    public static void main(String[] args) {

        int[] a = { 1, 5, 2, 3, 4, 7, 8};

        System.out.println(findDisappearedNumbers(a));
    }

    public static int findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        int sum = ((n+1)*(n+2))/2;

        for(int i=0; i<n; i++)
            sum -= nums[i];

        return sum;
    }
}
