/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
* */
package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static List<int[]> mergeIntervals(int[][] intervals){
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] interval = intervals[0];
        for(int i = 1; i < intervals.length; i++ ){
            if(interval[1] >= intervals[i][0]){
                interval[1] = Math.max(interval[1], intervals[i][1]);
            }
            else{
                result.add(interval);
                interval = intervals[i];
            }
        }
        result.add(interval);
        return result;

    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10},{15,18}};
        List<int[]> mergedIntervals = mergeIntervals(intervals);
        for(int[] interval : mergedIntervals){
            System.out.println(Arrays.toString(interval));
        }
    }
}
