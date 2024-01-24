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
* */
package topKElements;

import java.util.ArrayList;
import java.util.List;

public class KClosesetElements {
    public static List<Integer> kClosestElements(int[] nums, int k, int x){
        int l = 0;
        int r = nums.length - k;
        while (l < r){
            int mid = l + (l-r)/2;
            if(Math.abs(x -nums[mid]) > Math.abs(nums[mid+k] - x)){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = l ; i < l+k; i++){
            list.add(nums[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k =4;
        int x = 3;
        List<Integer> kList = kClosestElements(nums, k, x);
        System.out.println(kList);
    }
}
