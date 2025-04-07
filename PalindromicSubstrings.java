// Given a string s, return the number of substrings within s that are palindromes.
// A palindrome is a string that reads the same forward and backward.

class Solution {
    public int countSubstrings(String s) {

        int i = 0;
        int palindromes = 0;

        while( i < s.length() ){        

            //odd length
            int l = i;
            int r = i;
            while( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ){
                palindromes++;
                l--;
                r++;
            }         
            
            //even length
            l = i;
            r = i+1;
            while( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ){
                palindromes++;
                l--;
                r++;
            }         
  
            i++;

        }

        return palindromes;

    }
}
