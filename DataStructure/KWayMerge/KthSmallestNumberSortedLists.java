/*
* Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
* Example:
    Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
    Output: 4
    Explanation: The 5th smallest number among all the arrays is 4, this can be verified from
    the merged list of all the arrays: [1, 2, 3, 3, 4, 6, 6, 7, 8]
* */
package KWayMerge;

import java.util.PriorityQueue;

public class KthSmallestNumberSortedLists {
    int getKthSmallestNumber(int[][] lists, int k){
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        for(int i = 0; i < lists.length; i++){
            int [] num = {lists[i][0], 0, i};
            minHeap.add(num);
        }
        int kthSmallest = 0;
        while(!minHeap.isEmpty() && k >0){
            int [] num = minHeap.poll();
            kthSmallest = num[0];
            k -= 1;
            int pos = num[1] + 1;
            int index = num[2];
            if(pos < lists[index].length){
                minHeap.add(new int[]{lists[index][pos], pos, num[2]});
            }
        }
        return kthSmallest;
    }

    public static void main(String[] args) {
        KthSmallestNumberSortedLists myclass = new KthSmallestNumberSortedLists();
        int[][] lists = {
                {1,3,5},
                {2,4,6},
                {0, 9, 10, 11}
        };
        int result = myclass.getKthSmallestNumber(lists, 3);
        System.out.println(result);
    }
}
