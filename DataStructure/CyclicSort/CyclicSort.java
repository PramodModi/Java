/*
We are given an array containing n objects. Each object, when created, was assigned a unique number from 1 to n
based on their creation sequence. This means that the object with sequence number 3 was created just before the
object with sequence number 4.

Write a function to sort the objects in-place on their creation sequence number in O(n) and without any extra space.
Example:

    nums: [3, 1, 5, 4, 2]
    output: [1,2,3,4,5]
* */
package CyclicSort;

import java.util.Arrays;

public class CyclicSort {
    public static void cyclicSort(int[] nums){
        int i = 0;
        while(i < nums.length){
            int j = nums[i]-1;
            if(nums[j] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            else{
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,5,6,4,3,2};
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
