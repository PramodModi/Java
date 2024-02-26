package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static int[][] insertInterval(int[][] intervals, int[] newInterval){
        List<int[]> result = new ArrayList<>();
        int index = binarySearch(intervals, newInterval);
        int i = 0;
        while(i< index){
            result.add(intervals[i]);
            i++;
        }
        //Add new interval
        //Merge, if needed
        int pos = result.size()-1;
        if(pos >= 0 && result.get(pos)[1] >= newInterval[0]){
            result.get(pos)[1] = Math.max(result.get(pos)[1], newInterval[1]);
        }
        else{
            result.add(newInterval);
            pos ++;
        }


        while(i < intervals.length && result.get(pos)[1] >= intervals[i][0]){
            result.get(pos)[1]  = Math.max(result.get(pos)[1] , intervals[i][1]);
            i++;
        }
        while(i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static int binarySearch(int[][]intervals, int []newInterval){
        int left = 0, right = intervals.length-1;
        while(left <= right){
            int mid = left + (right -left)/2;
            if(intervals[mid][0] > newInterval[0]){
                right = mid-1;
            }
            else if(intervals[mid][0] < newInterval[0]){
                left = mid+1;
            }
            else{
                left = mid;
                break;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {6,9}};
        int[] newInterval = {2,5};
//        int[][] intervals = {{4,6}, {6,9}};
//        int[] newInterval = {2,5};
        int[][]result = insertInterval(intervals, newInterval);
        for(int[] interval: result){
            System.out.println(Arrays.toString(interval));
        }


    }
}
