/*
LeetCode: https://leetcode.com/problems/employee-free-time/

We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

Example 1:

    Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
    Output: [[3,4]]
Explanation:
    There are a total of three employees, and all common
    free time intervals would be [-inf, 1], [3, 4], [10, inf].
    We discard any intervals that contain inf as they aren't finite.
* */
package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
    public static int[][] freeTime(int[][][] schedule){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i = 0; i<schedule.length; i++){
            pq.add(new int[]{schedule[i][0][0], 0, i});
        }
        List<int[]> result = new ArrayList<>();
        int[] prev = null;
        while(!pq.isEmpty()){
            int[] element = pq.poll();
            int sIndex = element[2];
            int pos = element[1];
            int[] interval = schedule[sIndex][pos];

            if(prev == null)
                prev = interval;
            else{
                if(prev[1] < interval[0])
                    result.add(new int[]{prev[1], interval[0]});
                if(prev[0] == interval[0] && interval[1] < prev[1])
                {
                    // do not do anything
                }
                else
                    prev= interval;
            }
            pos += 1;
            if(pos < schedule[sIndex].length){
                pq.add(new int[]{schedule[sIndex][pos][0], pos, sIndex});
            }

        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][][] schedule = {{{1,3},{6,7}}, {{2,4}}, {{2,5},{9,12}}};
        int[][] result  = freeTime(schedule);
        for(int[] interval : result){
            System.out.println(Arrays.toString(interval));
        }

    }
}
