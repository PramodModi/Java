/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the
sorted order, not the kth distinct element.
Implement KthLargest class:
KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest
element in the stream.

Example 1:
    Input
    ["KthLargest", "add", "add", "add", "add", "add"]
    [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
    Output
    [null, 4, 5, 5, 8, 8]
* */
package topKElements;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    PriorityQueue<Integer>pq = new PriorityQueue<>();
    int k;
    public KthLargestElementInStream(int[] nums, int k){
        for(int n : nums){
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        this.k = k;
    }
    public int add(int n){
        pq.add(n);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
        int k =3;
        KthLargestElementInStream myClass = new KthLargestElementInStream(nums, k);
        System.out.println(myClass.add(3));
        System.out.println(myClass.add(5));
        System.out.println(myClass.add(10));
        System.out.println(myClass.add(9));
        System.out.println(myClass.add(4));
    }
}
