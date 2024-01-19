/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest
element in the matrix. Note that it is the kth smallest element in the sorted order, not the kth distinct element.
You must find a solution with a memory complexity better than O(n2).

Example 1:
    Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
    Output: 13
    Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
* */
package KWayMerge;

public class KthSmallestInSortedMatrix {
    int kthSmallest(int[][] matrix, int k){
        int n = matrix.length;
        int m = matrix[0].length;
        int start = matrix[0][0];
        int end = matrix[n-1][m-1];

        while(start < end){
            int mid = (start + end)/2;
            int [] result;
            result = countSmallerLarger(matrix, mid, start, end);
            int count = result[0];
            int smaller = result[1];
            int larger = result[2];
            if(count == k){
                return smaller;
            }
            if(count > k){
                end = smaller;
            }
            else{
                start = larger;
            }

        }
        return start;
    }

    int [] countSmallerLarger(int[][]matrix, int mid, int smaller, int larger){
        int count = 0;
        int row = matrix.length-1;
        int col = 0;
        while(row>= 0 && col < matrix[0].length){
            if(mid < matrix[row][col]){
                larger = Math.min(larger, matrix[row][col]);
                row -= 1;
            }
            else{
                smaller = Math.max(smaller, matrix[row][col]);
                col += 1;
                count += row+1;
            }
        }
        return new int[]{count, smaller, larger};

    }

    public static void main(String[] args) {
        KthSmallestInSortedMatrix myClass = new KthSmallestInSortedMatrix();
        int[][] matrix = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        int k = 8;
        int result = myClass.kthSmallest(matrix, k);
        System.out.println(result);
    }
}
