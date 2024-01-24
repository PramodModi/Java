/*
Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.

Example 1:

    Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
    Output: 23
    Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum of numbers coming
    between 5 and 15 is 23 (11+12).
* */
package topKElements;

import java.util.PriorityQueue;

public class SumOfElements {
    public static int sumOfElements(int[] nums, int k1, int k2){
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)-> b-a);
        for(int n: nums){
            pq.add(n);
            if(pq.size() > k2){
                pq.poll();
            }
        }
        pq.poll();
        int sum = 0;
        int numElements = k2-k1-1;
        while(!pq.isEmpty() && numElements > 0 ){
            sum += pq.poll();
            numElements -= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,12,5,15,11};
        int k1 = 3;
        int k2 = 6;
        int sum = sumOfElements(nums, k1, k2);
        System.out.println(sum);
    }
}
