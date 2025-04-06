// Given a string s, split s into substrings where every substring is a palindrome. Return all possible lists of palindromic substrings.
// You may return the solution in any order.

class Solution {
  
    public List<List<String>> partition(String s) {
        
        List<List<String>> subPalindromes = new ArrayList<>();

        recurse( subPalindromes, new ArrayList<>(), s, 0, 1 );

        return subPalindromes;

    }

    public void recurse( List<List<String>> subPalindromes, List<String> temp, String s, int start, int iter ){

        if( start >= s.length() ){
            subPalindromes.add( new ArrayList<>(temp) );
            return;
        }

        if( iter >= s.length() + 1 )
            return;

        if( checkPal( s, start, iter ) ){
        
            temp.add( new String( s.substring(start,iter) ) );
            recurse( subPalindromes, temp, s, iter, iter+1 );
            temp.remove(temp.size() - 1);
            
        }
      
        recurse( subPalindromes, temp, s, start, iter+1 );
       
        return;
      
    }


    public boolean checkPal( String s, int i, int j ){

        j = j-1;

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
