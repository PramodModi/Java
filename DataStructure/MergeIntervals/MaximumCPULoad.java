/*
We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.

Example 1:

Jobs: [[1,4,3], [2,5,4], [7,9,6]]
Output: 7
Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be
when both the jobs are running at the same time i.e., during the time interval (2,4).

*/
package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumCPULoad {
    public static int maximumCPULoad(int[][] jobs){
        Arrays.sort(jobs, Comparator.comparingInt(a->a[0]));
        int[] job = jobs[0];
        int maxCPU = 0;
        for(int i = 1; i<jobs.length; i++){
            if(job[1] > jobs[i][0]){
                job[1] = Math.max(job[1], jobs[i][1]);
                job[2] = job[2] + jobs[i][2];
            }
            else{
                maxCPU = Math.max(maxCPU, job[2]);
                job = jobs[i];
            }
        }
        maxCPU = Math.max(maxCPU, job[2]);
        return maxCPU;
    }

    public static void main(String[] args) {
        int[][] jobs = {{1,4,3}, {2,5,4}, {7,9,6}};
        int maxcpu = maximumCPULoad(jobs);
        System.out.println(maxcpu);
    }
}
