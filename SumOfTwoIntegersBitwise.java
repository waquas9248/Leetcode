// Given two integers a and b, return the sum of the two integers without using the + and - operators.

class Solution {
    public int getSum(int a, int b) {

        int sum = 0;

        int carry = 0;

        for( int i = 0 ; i < 32 ; i++ ){
            
            //get bits
            int bit_a = (a >> i) & 1;  

            int bit_b = (b >> i) & 1;

            int bit_sum = bit_a ^ bit_b ^ carry;

            //set carry
            if( bit_a + bit_b + carry > 1 )
                carry = 1;
            else
                carry = 0;

            //set bit
            if( bit_sum == 1 )
                sum = sum | (1 << i);              

        }

        return sum;
        
    }
}
