/*
496. Next Greater Element I

https://leetcode.com/problems/next-greater-element-i/

The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element
of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.



Example 1:

    Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
    Output: [-1,3,-1]
    Explanation: The next greater element for each value of nums1 is as follows:
    - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
    - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
    - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
* */
package MonotonicStack;

import java.util.*;

public class NextGreaterElement {
    public static List<Integer> nextGreaterElement(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int length2 = nums2.length;
        for(int i = length2-1; i>=0 ; i--){
            int e = nums2[i];
            while(!stack.isEmpty() && e > stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty())
                map.put(e, stack.peek());
            else map.put(e, -1);
            stack.push(e);
        }
        int length1 = nums1.length;
        List<Integer> result = new ArrayList<>(length1);
        for(int i =0; i < length1; i++){
            result.add(i, map.get(nums1[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums1 = {4,1,2};
        //int[] nums2 = {1,3,4,2};
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};

        List<Integer> result = nextGreaterElement(nums1, nums2);
        System.out.println(result);
    }
}
