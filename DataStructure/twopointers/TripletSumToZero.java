/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.
*/
package TwoPointers;

import java.util.*;

public class TripletSumToZero {
    public static Set<List<Integer>> tripletSumToZero(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> output = new HashSet<>();
        for(int i  = 0; i < len-2; i++){
            int j = i+1;
            int end = len-1;
            while(j < end) {
                int sum = nums[i] + nums[j] + nums[end];
                if(sum > 0){
                    end -= 1;
                }
                else if(sum < 0){
                    j += 1;
                }
                else{
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[end]);
                    output.add(triplet);
                    j += 1;
                    end -= 1;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int [] nums = {1,-1,0, -1,2,-3};
        Set<List<Integer>> result = tripletSumToZero(nums);
        System.out.println(result);
    }
}
