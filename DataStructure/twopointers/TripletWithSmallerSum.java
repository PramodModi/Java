/*
Given an array of distinct integers and a target value.
Find count of triplets with sum smaller than given target value. The expected Time Complexity is O(n2).
Example:
    Input : nums = [-2, 0, 1, 3]
    target = 2.
    Output : 2
    Explanation :  Below are triplets with sum less than 2
               (-2, 0, 1) and (-2, 0, 3)

* */
package TwoPointers;


import java.util.Arrays;

public class TripletWithSmallerSum {
    public static int tripletCount(int[] nums, int target){
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length-2; i++){
            int j = i+1;
            int  t = nums.length-1;
            while(j < t){
                int sum = nums[i] + nums[j] + nums[t];
                if(sum >= target){
                    t -= 1;
                }
                else{
                    count += (t-j);
                    j += 1;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,3};
        int target =2;
        int count = tripletCount(nums, target);
        System.out.println(count);

    }
}
