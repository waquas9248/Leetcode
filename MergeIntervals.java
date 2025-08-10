// Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
// You may return the answer in any order.
// Note: Intervals are non-overlapping if they have no common point. For example, [1, 2] and [3, 4] are non-overlapping, but [1, 2] and [2, 3] are overlapping.
  
class Solution {
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> intervalsList = new ArrayList<List<Integer>>();

        for (int[] interval : intervals) {
            List<Integer> innerList = new ArrayList<>();
            for (int val : interval) {
                innerList.add(val);
            }
            intervalsList.add(innerList);
        }

        //sort by index 0 asc first then index 1 desc as tie-breaker for easy list subsumption iterating forward
        intervalsList.sort(Comparator.comparing( (List<Integer> row) -> row.get(0))
                                    .thenComparing(row -> row.get(1), Comparator.reverseOrder() ) );
        
        
        for(int i = 0 ; i < intervalsList.size() ; i++){
            
            int j = i+1;

            while( j < intervalsList.size() ){
                
                int jFirst = intervalsList.get(j).get(0);
                int jLast = intervalsList.get(j).get(1);
                int iFirst = intervalsList.get(i).get(0);
                int iLast = intervalsList.get(i).get(1);

                if( ( jFirst >= iFirst) && ( jFirst <= iLast ) ){
                    
                    // keep updating intervals[index][1] based on intervals[consumed][1]
                    intervalsList.get(i).set(1, Math.max(jLast, iLast));    

                    // keep subsuming further indices until non-overlapping start element  
                    intervalsList.remove(j);
                    
                    continue;

                }else{
                    break;
                }
               
            }

        }
        
        return intervalsList.stream()
                        .map(list -> list.stream().mapToInt(i -> i).toArray())
                        .toArray(int[][]::new);

    }
}
