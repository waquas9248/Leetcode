//Neetcode-150
//Given a string s, find the length of the longest substring without duplicate characters.
// A substring is a contiguous sequence of characters within a string.

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap();

        int maxLength = 0;
        int currLength = 0;
        int threshold = -1;

        for(int i = 0 ; i < s.length() ; i++){

            char c = s.charAt(i);

            int index = map.getOrDefault(c,-1);

            if( index < threshold )
                index = -1;

            if( index == -1 ){
                map.put(c,i);
                currLength += 1;
            }else{
                int diff = i - index;
                threshold = index;
                
                if( currLength > maxLength )
                    maxLength = currLength;
                
                currLength = diff;
                
              map.put(c,i);
            }

        }

        if( currLength > maxLength )
            maxLength = currLength;

        return maxLength;
        
    }
}
