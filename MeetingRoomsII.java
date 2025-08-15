// Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all meetings without any conflicts.
// Note: (0,8),(8,10) is not considered a conflict at 8.

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
    public int minMeetingRooms(List<Interval> intervals) {

        if( intervals.size() == 0 || intervals == null )
            return 0;

        intervals.sort( Comparator.comparing( (Interval i) -> i.end ) );

        //list of end values of last intervals on each day -> will be sorted on insertion by default
        List<Integer> dayEnd = new ArrayList<>();

        int dayCount = 0;

        dayEnd.add(intervals.get(0).end);

        dayCount++;

        int i = 1;

        while(i < intervals.size() ){
            
            int iStart = intervals.get(i).start;
            int iEnd = intervals.get(i).end;

            int index = Collections.binarySearch(dayEnd,iStart);

            if(index >= 0){
                dayEnd.remove(index);
                dayEnd.add(iEnd);
            }else{
                int ins = -(index+1);
                if(ins == 0 || ins == intervals.size()){
                    dayEnd.add(iEnd);
                    dayCount++;
                }else{
                    dayEnd.remove(ins-1);
                    dayEnd.add(iEnd);
                }

            }

            i++;

        }

        return dayCount;

    }

}
