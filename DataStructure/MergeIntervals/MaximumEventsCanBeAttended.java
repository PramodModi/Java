/*
LeetCode: 1353. Maximum Number of Events That Can Be Attended

https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/

You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.

Example:
    Input: events = [[1,2],[2,3],[3,4]]
    Output: 3
    Explanation: You can attend all the three events.
    One way to attend them all is as shown.
    Attend the first event on day 1.
    Attend the second event on day 2.
    Attend the third event on day 3.

* */
package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumEventsCanBeAttended {
    public static int maxEvents(int[][] events){
        int count = 0;
        Arrays.sort(events, Comparator.comparingInt(a-> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int totalDays = 0;
        for(int[] event : events){
            totalDays = Math.max(totalDays, event[1]);
        }
        int eventIndex = 0;
        for(int d = 1; d < totalDays; d++){
            while(eventIndex < events.length  && events[eventIndex][0] == d ){
                minHeap.add(events[eventIndex][1]);
                eventIndex ++;
            }
            while(!minHeap.isEmpty()){
                int lastDay = minHeap.poll();
                if(lastDay >= d){
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] events = {{1,2}, {2,3}, {3,4}, {1,2}};
        int count = maxEvents(events);
        System.out.println(count);
    }
}
