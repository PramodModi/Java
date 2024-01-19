/*
Given an unsorted array of numbers, find the ‘K’ largest numbers in it.

Example 1:
    Input: [3, 1, 5, 12, 2, 11], K = 3
    Output: [5, 12, 11]
Example 2:
    Input: [5, 12, 11, -1, 12], K = 3
    Output: [12, 11, 12]
* */
package topKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKNumber {
    List<Integer> topkNumber(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n : nums){
            minHeap.add(n);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            int n = minHeap.poll();
            result.add(n);
        }
        return result;
    }

    public static void main(String [] args){
        TopKNumber myClass = new TopKNumber();
        int [] nums = {3,1,5,12,2,11};
        List<Integer> result  = myClass.topkNumber(nums, 3);
        for(int n : result){
            System.out.println(n);
        }
    }

}

