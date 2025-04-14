// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of dictionary words.
// You are allowed to reuse words in the dictionary an unlimited number of times. You may assume all dictionary words are unique.

class Solution {

    private Map<Integer, Boolean> status;

    public boolean wordBreak(String s, List<String> wordDict) {

        status = new HashMap<>();            

        status.put(s.length(), true);

        return check( 0, s, wordDict );

    }

    public boolean check( int start, String s, List<String> wordDict ){

        if( status.containsKey(start) )
            return status.get(start);

        for( String word: wordDict){

            if( ( start + word.length() <= s.length() ) && word.equals( s.substring( start, start + word.length() ) ) ){
               
                if( check( start + word.length(), s, wordDict ) ){
                    //save work done
                    status.put(start, true);
                    return true;
                }

            }

        }

        status.put(start, false);

        return false;
    }

}
