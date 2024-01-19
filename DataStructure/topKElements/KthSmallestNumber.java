/*
Given an unsorted array of numbers, find Kth smallest number in it.
Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.
Note: For a detailed discussion about different approaches to solve this problem, take a look at Kth Smallest Number.
Example 1:
    Input: [1, 5, 12, 2, 11, 5], K = 3
    Output: 5
    Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].

* */
package topKElements;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestNumber {
    public static int kthSmallestNumber(List<Integer> nums, int k){
        int pivot = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int n: nums){
            if(n < pivot){
                left.add(n);
            }
            else if(k > pivot){
                right.add(n);
            }
            else{
                mid.add(n);
            }
        }
        int l = left.size();
        int m = mid.size();
        if(k < l){
            return kthSmallestNumber(left, k);
        }
        else if(k > l+m){
            return kthSmallestNumber(right, k -(l+m));
        }
        else{
            return mid.get(0);
        }

    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(3,1,4,4,2,2,5);
        int k = 4;
        int result = kthSmallestNumber(nums, k);
        System.out.println(result);
    }
}
