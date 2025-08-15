// Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all meetings to their schedule without any conflicts.

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        
        intervals.sort(Comparator.comparing( (Interval i) -> i.end ));

        int i = 0;

        while( i < intervals.size() ){
            int iStart = intervals.get(i).start;
            int iEnd = intervals.get(i).end;

            int j = i+1;

            while( j < intervals.size() ){
                int jStart = intervals.get(j).start;
                int jEnd = intervals.get(j).end;

                if( (jStart < iStart) || ( (jStart >= iStart) && (jStart < iEnd) ) ){
                    return false;
                }else{
                    break;
                }

            }

            i++;
        }
        return true;
    }
}
