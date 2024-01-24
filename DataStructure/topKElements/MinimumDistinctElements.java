/*
Given an array of integers arr and an integer k. Find the least number of unique
integers after removing exactly k elements.

Example 1:
    Input: arr = [5,5,4], k = 1
    Output: 1
    Explanation: Remove the single 4, only 5 is left.

Example 2:
    Input: arr = [4,3,1,1,3,3,2], k = 3
    Output: 2
    Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.

*/
package topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumDistinctElements {
    public static int minimumDistinctElements(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)-> a.getValue() - b.getValue());
        pq.addAll(map.entrySet());

        int count = 0;
        while(!pq.isEmpty() && k > 0){
            Map.Entry<Integer, Integer> entry = pq.poll();
            int freq = entry.getValue();
            while(freq > 0 && k> 0){
                freq -= 1;
                k -= 1;
            }
            count += freq;
        }
        return count + pq.size();
    }

    public static void main(String[] args){
        int [] nums = {4,3,1,1,3,3,2};
        int k =3;
        int count = minimumDistinctElements(nums, k);
        System.out.println(count);
    }
}
