/*
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.
Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
Example 2:
    Input: nums = [1], k = 1
    Output: [1]
* */
package topKElements;

import java.util.*;

public class TopKFrequentNumbers {
    public static List<Integer> topKElements(int[] nums, int k){
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int n : nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq =  new PriorityQueue<>(
                Comparator.comparing(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            int n = pq.poll().getKey();
            result.add(n);
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        List<Integer> result = topKElements(nums, k);
        System.out.println(result);
    }
}
