package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments {
    public static boolean conflictingAppointments(int[][] appointments){
        Arrays.sort(appointments, Comparator.comparingInt(a->a[0]));
        for(int i = 1; i<appointments.length; i++){
            if(appointments[i-1][1] > appointments[i][0])
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] appointments = {{1,4}, {2,5}, {7,9}};
        boolean result = conflictingAppointments(appointments);
        System.out.println(result);
    }
}
