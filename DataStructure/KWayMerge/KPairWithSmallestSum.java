package KWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KPairWithSmallestSum {
    List<int[]> kPairSmallestSum(int[] nums1, int[] nums2, int k){
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        for(int i =0; i < Math.min(nums1.length, k); i++){
            int n1 = nums1[i];
            int n2 = nums2[0];
            minHeap.add(new int[]{n1+n2, i, 0});
        }

        List<int[]> result = new ArrayList<>();
        int count = k;
        while(!minHeap.isEmpty() && count > 0){
            int [] output = minHeap.poll();
            int index1 = output[1];
            int index2 = output[2];
            result.add(new int[]{nums1[index1], nums2[index2]});
            count -= 1;
            index2 += 1;
            if(index2 < nums1.length && index2 < k){
                int n = nums1[index1] + nums2[index2];
                minHeap.add(new int[]{n, index1, index2});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int [] nums2 = {2,4,6};
        int k = 3;
        KPairWithSmallestSum myClass = new KPairWithSmallestSum();
        List<int[]> result  = myClass.kPairSmallestSum(nums1, nums2, k);
        for(int[] pair: result){
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}
