import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        int i = 0;
        int n = intervals.length;

        // Add all intervals before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge the new interval with overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add all intervals after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = solution.insert(intervals, newInterval);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
        // Output: [[1, 5], [6, 9]]
    }
}


//You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] 
//represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. 
//You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals 
//still does not have any overlapping intervals (merge overlapping intervals if necessary).

//Return intervals after the insertion.