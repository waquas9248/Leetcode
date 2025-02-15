//Neetcode - 150 
//You are given two strings s1 and s2.
//Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
//Both strings only contain lowercase letters.

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if( s1.equals(s2) )
            return true;
        
        if( s1.length() > s2.length() )
            return false;

        int[] charCounts = new int[26];

        //maintain char frequency count
        for( char c : s1.toCharArray() ){
            charCounts[ (int)c % 97 ] += 1;
        }

        int l = 0;

        //find valid starting index
        while ( l < s2.length() && charCounts[(int)s2.charAt(l) % 97] == 0 )
            l++;
      
        //window right pointer
        int r = l + 1;

        //no valid start index
        if( l == s2.length() )
            return false;
        
        charCounts[(int)s2.charAt(l) % 97] -= 1;
        
        while( r < s2.length() ){

            //expand window until valid
            while( r < s2.length() && charCounts[(int)s2.charAt(r) % 97] > 0 ){
                charCounts[(int)s2.charAt(r) % 97] -= 1;
                r++;
            }

            //if equal to or exceeds max window size
            if( r - l >= s1.length() )
                return true;
            
            //shrink window from the left until valid again
            while( r < s2.length() && s2.charAt(l) != s2.charAt(r) ){
                charCounts[(int)s2.charAt(l) % 97] += 1;
                l++;
            } 

            // if no valid left index until r
            if( r == l ){          

                //find new valid left index from r
                while ( l < s2.length() && charCounts[(int)s2.charAt(l) % 97] == 0 )
                    l++;
                
                if( l == s2.length() )
                    return false;

                r = l + 1;

                charCounts[(int)s2.charAt(l) % 97] -= 1;
    
            }else{
                //check again from a previous valid left index
                l++;
                r++;
            }

        }


        return false;
    }
}
