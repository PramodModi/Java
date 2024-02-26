/*
LeetCode: 739. Daily Temperatures

https://leetcode.com/problems/daily-temperatures/

Given an array of integers temperatures represents the daily temperatures, return an array answer such that
answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example:

    Input: temperatures = [73,74,75,71,69,72,76,73]
    Output: [1,1,4,2,1,1,0,0]
* */
package MonotonicStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DailyTemperature {
    public static int[] dailyTemperature(int[] tempratures){
        int len = tempratures.length;
        int[] result = new int[len];
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = len-1; i>= 0; i--){
            int e = tempratures[i];
            while(!stack.isEmpty() && e > stack.peek()[0]){
                stack.pop();
            }
            if(!stack.isEmpty()) {
                int[] next = stack.peek();
                result[i] =  (next[1] - i);
            }
            else result[i] = 0;
            stack.push(new int[]{e, i});
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = dailyTemperature(temperatures);
        for (int e : result) {
            System.out.print(e);
            System.out.print(",");
        }
    }
}
