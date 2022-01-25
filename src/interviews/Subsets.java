package interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {

    public static void main(String args[]){

        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println("Result: " + result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        recurse(result, nums, new Stack<>(), 0);

        return result;
    }


    private void recurse(List<List<Integer>> result, int[] nums, Stack path, int position) {
        if(position == nums.length) {
            result.add(new ArrayList<>(path));
            System.out.println("Result===: " + result);
            return;
        }

        path.push(nums[position]);

        recurse(result, nums, path, position + 1);

        path.pop();

        recurse(result, nums, path, position + 1);
    }
}
