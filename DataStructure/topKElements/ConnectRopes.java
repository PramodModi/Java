/*
Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
The cost of connecting two ropes is equal to the sum of their lengths.
Example 1:
    Input: [1, 3, 11, 5]
    Output: 33
    Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)

* */
package topKElements;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectRopes {
    public static int connectRopes(int[] ropes){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : ropes){
            pq.add(i);
        }

        int totalCost = 0;
        while(!pq.isEmpty()){
            int cost = 0;
            int r1 = pq.poll();
            cost += r1;
            if(!pq.isEmpty()){
                int r2 = pq.poll();
                cost += r2;
                totalCost += cost;
                pq.add(cost);
            }
        }
        return totalCost;
    }
    public static void main(String[] args){
        int[] ropes = {1,3,11,5};
        int result = connectRopes(ropes);
        System.out.println(result);
    }
}
