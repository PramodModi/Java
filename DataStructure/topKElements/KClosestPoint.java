/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
Example:
    Input: points = [[1,3],[-2,2]], k = 1
    Output: [[-2,2]]
    Explanation:
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

*/
package topKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoint {
    public static List<int[]> kClosestPoint(int[][] points, int k){
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        for(int i = 0; i < points.length; i++){
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            maxHeap.add(new int[]{x*x + y*y, i});
            if(maxHeap.size() >k ){
                maxHeap.poll();
            }
        }
        List<int[]> result = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            int[] output = maxHeap.poll();
            int index = output[1];
            result.add(points[index]);
        }
        return result;

    }

    public static void main(String[] args) {
        int[][]points= {
                {3,3}, {5, -1},{-2,4}
        };
        int k = 2;
        List<int[]> result = kClosestPoint(points, k);
        for(int[] point: result){
            System.out.println(point[0] + " "+ point[1]);
        }
    }
}
