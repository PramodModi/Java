/*
LeetCode: 448. Find All Numbers Disappeared in an Array

https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.

Example :
    Input: nums = [4,3,2,7,8,2,3,1]
    Output: [5,6]
* */
package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class MissingAllNumbers {
    public static List<Integer> missingAllNums(int[] nums){
        int n = nums.length;
        int i = 0;
        while (i < n){
            int j = nums[i]-1;
            if(j < n && nums[i] != nums[j]){
                int temp = nums[i];
                nums[i]  = nums[j];
                nums[j] = temp;
            }
            else i++;
        }

        List<Integer> result = new ArrayList<>();
        for(i = 0; i<n; i++){
            if(nums[i] != i+1){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = missingAllNums(nums);
        System.out.println(result);
    }
}
