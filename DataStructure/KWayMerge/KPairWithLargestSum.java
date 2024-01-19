/*
Given two sorted arrays in descending order, find ‘K’ pairs with the largest sum where each pair consists
of numbers from both the arrays.
Example 1:

    Input: L1=[9, 8, 2], L2=[6, 3, 1], K=3
    Output: [9, 3], [9, 6], [8, 6]
    Explanation: These 3 pairs have the largest sum. No other pair has a sum larger than any of these.
Example 2:

    Input: L1=[5, 2, 1], L2=[2, -1], K=3
    Output: [5, 2], [5, -1], [2, 2]
* */
package KWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairWithLargestSum {
    List<int[]> kPairLargestSum(int[] nums1, int[] nums2, int k){
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b)-> b[0]-a[0]);
        for(int i =0; i< Math.min(nums1.length, k); i++){
            int n1 = nums1[i];
            int n2 = nums2[0];
            maxHeap.add(new int[]{n1+n2, i, 0});
        }
        List<int[]> result = new ArrayList<>();
        int count = k;
        while(!maxHeap.isEmpty() && count>0){
            count -= 1;
            int[] output = maxHeap.poll();
            int index1 = output[1];
            int index2 = output[2];
            result.add(new int[]{nums1[index1], nums2[index2]});
            index2 += 1;
            if(index2 < nums2.length && index2 < k){
                int n = nums1[index1] + nums2[index2];
                maxHeap.add(new int[]{n, index1, index2});
            }

        }
        return result;
    }

    public static void main(String [] args){
        KPairWithLargestSum myClass = new KPairWithLargestSum();
        int nums1 [] = {9,8,2};
        int nums2 [] = {6,3,1};
        List<int[]> result = myClass.kPairLargestSum(nums1, nums2, 3);
        for(int[] pair : result){
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}
