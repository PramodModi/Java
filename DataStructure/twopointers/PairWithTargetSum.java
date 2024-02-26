/*
Given an array of numbers sorted in ascending order and a target sum,
find a pair in the array whose sum is equal to the given target.
Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
Example 1:
    Input: [1, 2, 3, 4, 6], target=6
    Output: [1, 3]
    Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
* */
package TwoPointers;

public class PairWithTargetSum {
    public static int[] pairWithTargetSum(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum > target){
                r -= 1;
            }
            else if (sum < target){
                l += 1;
            }
            else{
                return new int[]{l, r};
            }

        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6};
        int target = 6;
        int[] result = pairWithTargetSum(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }
}
