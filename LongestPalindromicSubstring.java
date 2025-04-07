// Given a string s, return the longest substring of s that is a palindrome.
// A palindrome is a string that reads the same forward and backward.
// If there are multiple palindromic substrings that have the same length, return any one of them.
  
class Solution {
  
    public String longestPalindrome(String s) {
        
        int maxLen = 0;

        String pal = "";

        for( int i = 0 ; i < s.length() ; i++ ){

            for( int j = i + maxLen ; j < s.length() ; j++ ){
                
                if( checkPal( s, i, j ) ){
                    
                    maxLen = j - i + 1;
                    pal = s.substring(i, j+1);
                    
                }
                
            }

        }

        return pal;

    }

    public boolean checkPal( String s, int i, int j ){

        if( j >= s.length() )
            return false;

        while( i < j ){
            
            if( s.charAt(i) != s.charAt(j) )
                return false;

            i++;
            j--;

        }

        return true;

    }
    
}
