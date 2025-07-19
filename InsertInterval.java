// You are given an array of non-overlapping intervals intervals where intervals[i] = [start_i, end_i] represents the start and the end time of the ith interval. intervals is initially sorted in ascending order by start_i.
// You are given another interval newInterval = [start, end].
// Insert newInterval into intervals such that intervals is still sorted in ascending order by start_i and also intervals still does not have any overlapping intervals. You may merge the overlapping intervals if needed.
// Return intervals after adding newInterval.
// Note: Intervals are non-overlapping if they have no common point. For example, [1,2] and [3,4] are non-overlapping, but [1,2] and [2,3] are overlapping.
  
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0){
            return new int[][]{ newInterval };
        }

        ArrayList<int[]> outputList = new ArrayList<>(Arrays.asList(intervals));

        int searchStart = newInterval[0];
        int searchEnd = newInterval[1];

        //find the first interval where newInterval[1] < intervals[i][0] 
        int low = 0;
        int high = intervals.length-1;
        int mid = (low+high)/2;

        while(low <= high){
            
            mid = (low+high)/2;

            int val = intervals[mid][0];

            if(val > searchEnd){
                high = mid-1;
            }else if(val < searchEnd){
                low = mid+1;
            }else{
                break;
            }

        }

        int rangeEnd = -1;

        if( intervals[mid][0] == searchEnd){
            rangeEnd = mid+1;
            newInterval[1] = intervals[mid][1]; 
        }else{    
            if( low == intervals.length ){
                //not found one
                //will be last interval
                rangeEnd = low;

            }else{
                //found one
                if( low == 0 ){
                    
                    outputList.add(0, newInterval);
                    
                    return outputList.toArray(new int[0][]);

                }

                rangeEnd = low;

            }
            if(searchEnd <= intervals[low-1][1]){
                newInterval[1] = intervals[low-1][1];
            }
        }

                                   
        //find interval where newInterval[0] fits
        //find first interval where intervals[i][0] >= newInterval[0]
        low = 0;
        high = rangeEnd-1;
        mid = (low+high)/2;

        while(low <= high){

            mid = (low+high)/2;
            
            int val = intervals[mid][0];

            if(val > searchStart){
                high = mid-1;
            }else if(val < searchStart){
                low = mid+1;
            }else{
                break;
            }

        }

        int rangeStart = -1;

        if( intervals[mid][0] == searchStart ){
            rangeStart = mid;
        }else {
            if( high == -1 ){
                //handle newInterval collapse from 0 to rangeEnd
                if(rangeEnd == intervals.length){
                    outputList.subList(0,outputList.size()).clear();
                    outputList.add(newInterval);
                    return outputList.toArray(new int[0][]);

                }else{
                    outputList.subList(0,rangeEnd).clear();
                    outputList.add(0,newInterval);
                    return outputList.toArray(new int[0][]);

                }            
            }else{
                if(high == intervals.length - 1 ){
                    if(searchStart > intervals[high][1]){
                        outputList.add( outputList.size(), newInterval );
                        return outputList.toArray(new int[0][]);
                    }else
                        newInterval[0] = outputList.remove(high)[0];
                        outputList.add( outputList.size(), newInterval );
                        return outputList.toArray(new int[0][]);
                }

                rangeStart = high;

            }
        }
           
        //if newInterval[0] is between intervals[i][0] and intervals[i][1]
        if( newInterval[0] <= intervals[rangeStart][1] ){
            
            newInterval[0] = intervals[rangeStart][0];

            //collapse intervals[i][0] to endInterval
            if(rangeEnd == intervals.length){
                outputList.subList(rangeStart, outputList.size()).clear();
                outputList.add(newInterval);
            }else{
                System.out.println(rangeStart + " " + rangeEnd);
                outputList.subList(rangeStart, rangeEnd).clear();
                outputList.add(rangeStart, newInterval);
            }

        }else{
            //if not 
            //collapse newInterval[0] from i+1 interval to endInterval with end val newInterval[1]
            if(rangeEnd == intervals.length){
                outputList.subList(rangeStart+1, outputList.size()).clear();
                outputList.add(newInterval);
            }else{
                outputList.subList(rangeStart+1, rangeEnd).clear(); 
                outputList.add(rangeStart+1, newInterval);
            }
        }
             
        return outputList.toArray(new int[0][]);

    }
}
