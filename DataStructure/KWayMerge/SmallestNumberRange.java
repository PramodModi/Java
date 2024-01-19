package KWayMerge;

import java.util.PriorityQueue;

public class SmallestNumberRange {
    int[] smallestRange(int[][]nums){
        int maxNum = Integer.MIN_VALUE;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[0]-b[0]);
        for(int i = 0; i<nums.length;i++){
            int n = nums[i][0];
            maxNum = Math.max(maxNum, n);
            minHeap.add(new int[]{n, 0, i});
        }

        int startRange = 0;
        int endRange = Integer.MAX_VALUE;

        while(!minHeap.isEmpty()){
            int[] out = minHeap.poll();
            int minVal = out[0];
            if(maxNum - minVal < endRange-startRange){
                endRange = maxNum;
                startRange = minVal;
            }
            int pos = out[1] + 1;
            int index = out[2];
            if(pos >= nums[index].length){
                break;
            }
            maxNum = Math.max(maxNum, nums[index][pos]);
            minHeap.add(new int[]{nums[index][pos], pos, index});
        }
        return new int[]{startRange, endRange};
    }

    public static void main(String[] args) {
        SmallestNumberRange myClass =  new SmallestNumberRange();
        int[][] nums = {
                {4,10,15,24,26 },{0,9,12,20},{5,18,22,30}
        };
        int[] result = myClass.smallestRange(nums);
        System.out.println(result[0] + " " +  result[1]);
    }
}
