//Neetcode - 150
//O(log n)

class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        int min = 0;

        //mid num can be less than or greater than first num
        if ( nums[mid] < nums[low] ){

            //if lesser, min lies between 0 and mid or could be mid
            
            min = nums[mid];
            high = mid - 1;
        
            while( low <= high ){
                mid = (low + high) / 2;
                if ( nums[mid] < min ){
                    min = nums[mid];
                    high = mid - 1;
                    continue;
                }else{
                    low = mid + 1;
                    continue;
                }
            }

        }else{
        
            //if greater, min lies between mid and end or could be nums[0]
    
            min = nums[0];
            low = mid + 1;
        
            while( low <= high ){
                mid = (low + high) / 2;
                if ( nums[mid] < min ){
                    min = nums[mid];
                    high = mid - 1;
                    continue;
                }else{
                    low = mid + 1;
                    continue;
                }
            }


        }

        return min;
        
    }
}
