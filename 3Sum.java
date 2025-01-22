// Neetcode 150

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
// The output should not contain any duplicate triplets. You may return the output and the triplets in any order.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        //helps reduce search time
        Arrays.sort(nums);
        
        Map<Integer, Integer> map = new HashMap<>();

        for( int i = 2 ; i < nums.length ; i++ ){
            map.put(nums[i],i);
        }

        List<List<Integer>> list = new ArrayList<>();

        int i = 0;

        while ( i < nums.length - 2 ){

            if ( nums[i] > 0 )
                break;
        
            int j = i+1;

            while( j < nums.length - 1 ){
                    
                int req = 0 - nums[i] - nums[j];

                if( req < nums[j] ){
                    break;
                }

                if ( map.getOrDefault(req,0) > j ){

                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(req);
                    list.add(temp);

                    //prevents duplicate tuples
                    while( (j < nums.length - 1) && (nums[j] == nums[j+1]) ){
                        j++;
                        continue;
                    }
                }
                j++;
            }

            //prevents duplicate tuples
            while( (i < nums.length - 1) && (nums[i] == nums[i+1]) ){
                i++;
                continue;
            }
            i++;
        }
        return list;
    }
}
