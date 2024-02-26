package TwoPointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static int tripletSumCloseToTarget(int[] nums, int target){
        Arrays.sort(nums);
        int closest = nums[0]+ nums[1] + nums[2];
        if(closest == target)
            return closest;
        for(int i = 0; i < nums.length -2; i++){
            int j = i+1;
            int t = nums.length -1;
            int sum = nums[i] + nums[j]+ nums[t];
            if(sum  == target){
                return sum;
            }
            if(Math.abs(closest-target) > Math.abs(sum-target)){
                closest = sum;
            }
            if(sum > target)
                t -= 1;
            else{
                j += 1;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int [] nums = {-1,2,1,-4};
        int target = 1;
        int closest = tripletSumCloseToTarget(nums, target);
        System.out.println(closest);
    }
}
