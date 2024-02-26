/*
Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.

Example 1:

    Input: [3, -1, 4, 5, 5], k=3
    Output: [1, 2, 6]
    Explanation: The smallest missing positive numbers are 1, 2 and 6.
Example 2:

    Input: [2, 3, 4], k=3
    Output: [1, 5, 6]
    Explanation: The smallest missing positive numbers are 1, 5 and 6.
* */
package CyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindKMissingPositiveNumbers {
    public static List<Integer> firstKMissingNumber(int[] nums, int k ){
        int n = nums.length;
        int i = 0;
        while(i < n){
            int j = nums[i]-1;
            if(j < n && nums[i] > 0 && nums[i] != nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            else i++;
        }

        List<Integer> result = new ArrayList<>();
        Set<Integer> numbers = new HashSet<>();
        for(i = 0; i < n; i++){
            if(nums[i] != i+1){
                if(result.size() < k) {
                    result.add(i + 1);
                    numbers.add(nums[i]);
                }
            }
        }

        int j = n+1;
        while(result.size() < k){
            if(!numbers.contains(j)) {
                result.add(j);
                numbers.add(j);
            }
            j++;

        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums = {3,-1,4,5,5};
        int[] nums = {2,3,4};
        List<Integer> missingNumbers = firstKMissingNumber(nums, 3);
        System.out.println(missingNumbers);
    }
}
