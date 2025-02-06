//Neetcode - 150
//Recommended Time & Space Complexity:
//You should aim for a solution with O(nlogm) time and O(1) space, where n is the size of the input array, and m is the maximum value in the array.


class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);

        int rate = 0;

        int max = piles[piles.length - 1];
        
        long sum = Arrays.stream(piles).asLongStream().sum();

        //lowest probable rate - 1, when h > sum of items
        if ( h >= sum )
            return 1;

        //highest probable rate - max, when h == length
        if ( h == piles.length )
            return max;
     
        //any other possible rate will be between 1 and max
        int low = 1;
        int high = max;

        while (low <= high){
            int mid = (low + high) / 2;
            
            if ( isValid(mid, piles, h) ){
                rate = mid;
                high = mid - 1;
                continue;
            }else{
                low = mid + 1;
                continue;
            }
        }

        return rate;

    }

    public boolean isValid(int rate, int[] piles, int h){

        int attempts = 0;

        for( int i = 0 ; i < piles.length ; i++ ){

            attempts += (int) Math.ceil( (double) piles[i] / rate );

            if(attempts > h)
                return false;

        }

        return true;

    }
}
