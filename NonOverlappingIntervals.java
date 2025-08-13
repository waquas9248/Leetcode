// Given an array of intervals intervals where intervals[i] = [start_i, end_i], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
// Note: Intervals are non-overlapping even if they have a common point. For example, [1, 3] and [2, 4] are overlapping, but [1, 2] and [2, 3] are non-overlapping.

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int i = 0;
        
        while (i < intervals.length) {
            int currentEnd = intervals[i][1];
            int j = i + 1;
            
            while (j < intervals.length && intervals[j][0] < currentEnd) {
                count++; 
                j++;
            }
            
            i = j; 
        }
        
        return count;
    }
}
