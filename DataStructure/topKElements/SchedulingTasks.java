/*
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
Tasks could be done in any order. Each task is done in one unit of time.
For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between
two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

Example 1:

    Input: tasks = ["A","A","A","B","B","B"], n = 2
    Output: 8
    Explanation:
    A -> B -> idle -> A -> B -> idle -> A -> B
    There is at least 2 units of time between any two same tasks.
* */
package topKElements;

import java.util.*;

public class SchedulingTasks {
    public static int schedulingTasks(char[] tasks, int n){
        Map<Character, Integer> map = new HashMap<>();
        for(Character c: tasks){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        maxHeap.addAll(map.values());

        int totalTime = 0;
        LinkedList<int[]> q =  new LinkedList<>();
        while (!q.isEmpty() || !maxHeap.isEmpty()){
            totalTime += 1;
            if(!maxHeap.isEmpty()){
                int freq = maxHeap.poll();
                freq -= 1;
                if(freq > 0){
                    q.addLast(new int[]{freq, totalTime +n});
                }
            }
            if(!q.isEmpty() && q.peekFirst()[1] == totalTime){
                maxHeap.add(q.pollFirst()[0]);
            }
        }
        return totalTime;

    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int output = schedulingTasks(tasks, n);
        System.out.println(output);
    }
}
