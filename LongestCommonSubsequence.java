// Given two strings text1 and text2, return the length of the longest common subsequence between the two strings if one exists, otherwise return 0.
// A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the relative order of the remaining characters.
// For example, "cat" is a subsequence of "crabt".
// A common subsequence of two strings is a subsequence that exists in both strings.

class Solution {

    //to save work done per string length-pair
    int[][] length;

    public int longestCommonSubsequence(String text1, String text2) {

        length = new int[text1.length()][text2.length()];

        //initially not visited
        for( int[] arr : length){
            Arrays.fill(arr,-1);
        }

        return recurse( 0, 0, text1, text2 );
        
    }

    public int recurse( int i, int j, String text1, String text2 ){
        
        if( i >= text1.length() || j >= text2.length() || i < 0 || j < 0 )
            return 0;

        if( length[i][j] != -1 )
            return length[i][j];

        //if char match, move 1 index ahead together 
        if( text1.charAt(i) == text2.charAt(j) ){

            length[i][j] = 1 + recurse( i+1, j+1, text1, text2 );

        }else{

            //if no char match, max of 1 index ahead of each alone
            length[i][j] = Math.max( recurse( i, j+1, text1, text2 ),
                         recurse( i+1, j, text1, text2 ) );

        }

        return length[i][j];
    
    }

}
