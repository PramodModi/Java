package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {
    public static int[][] intervalIntersection(int[][] list1, int[][] list2){
        List<int[]> result = new ArrayList<>();
        int i = 0, j =0;
        while(i< list1.length && j < list2.length){
            if(list1[i][0] <= list2[j][1] && list2[j][0] <= list1[i][1] ){
                int first = Math.max(list1[i][0], list2[j][0]);
                int second = Math.min(list1[i][1], list2[j][1]);
                result.add(new int[]{first, second});
            }
            if(list1[i][1] < list2[j][1])
                    i++;
            else
                j++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] list1 = {{0,2}, {5,10}, {13, 23}, {24,25}};
        int[][] list2 = {{1,5}, {8,12}, {15,24}, {25,26}};
        int [][] result = intervalIntersection(list1, list2);
        for(int[] interval : result){
            System.out.println(Arrays.toString(interval));
        }
    }
}
