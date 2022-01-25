// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

import java.util.Comparator;
import java.util.PriorityQueue;

public class HouseRobber {

    public static void main(String[] args) {


        int[] nums = {44, 5, 55, 100};
        int res = rob(nums);
        System.out.println("Result: " + res);
        System.out.println("Result: " + rob2(nums));
    }

    public static int rob(int[] nums) {

        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        
        return dp[dp.length - 1];
    }


    public static int rob2(int[] nums) {

        if(nums.length == 0)
            return 0;

        if(nums.length  == 1)
            return nums[0];

        int[] arr = new int[nums.length];

        arr[0] = nums[0];
        arr[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for(int i=2; i< nums.length; i++)
            arr[i] = Math.max((arr[i-2] + nums[i]), arr[i-1]);

        return arr[arr.length-1];
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) {
            return null;
        }

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val) {
                    return -1;
                } else if (o1.val==o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists) {
            if (node!=null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null) {
                queue.add(tail.next);
            }

        }
        return dummy.next;

    }
}
