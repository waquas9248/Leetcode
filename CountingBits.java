// Given an integer n, count the number of 1's in the binary representation of every number in the range [0, n].
// Return an array output where output[i] is the number of 1's in the binary representation of i.

class Solution {
    public int[] countBits(int n) {
        
        int[] bitCount = new int[n+1];

        int curr = 1;

        bitCount[0] = 0;

        if( n == 0 )
            return bitCount;

        bitCount[1] = 1;

        if( n == 1 )
            return bitCount;

        int next = 2;

        for( int i = 2 ; i <= n ; i++ ){

            if( i == next ){
                bitCount[i] = 1;
                curr = next;
                next *= 2;
            }

            bitCount[i] = bitCount[curr] + bitCount[i - curr];  
            
        }

        return bitCount;

    }

}
