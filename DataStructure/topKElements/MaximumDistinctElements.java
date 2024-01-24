/*
Given an array of numbers and a number ‘K’, we need to remove ‘K’ numbers from the array such that
we are left with maximum distinct numbers.

Example 1:
    Input: [7, 3, 5, 8, 5, 3, 3], and K=2
    Output: 3
    Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8], we have
    to skip 5 because it is not distinct and occurred twice.
    Another solution could be to remove one instance of '5' and '3' each to be left with three distinct numbers [7, 5, 8], in this case, we have to skip 3 because it occurred twice.
 */
package topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctElements {
    public static int maximumDistinctElements(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->a.getValue() - b.getValue());
        pq.addAll(map.entrySet());
        int count = 0;
        while(!pq.isEmpty() && k> 0){
            Map.Entry<Integer, Integer> entry = pq.poll();
            int freq = entry.getValue();
            if(freq> 1){
                freq -= 1;
                k -= 1;
            }
            if(freq == 1){
                count += 1;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {7,3,5,8,5,3,3};
        int k = 2;
        int count = maximumDistinctElements(nums, k);
        System.out.println(count);
    }
}
