// Given an integer n, return the least number of perfect square numbers that sum to n.
// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

class Solution {
    public int numSquares(int n) {
      
        ArrayList<Integer> p_squares = new ArrayList<>();

        int[] arr = new int[n+1];

        arr[0] = 0;
        arr[1] = 1;
      
        //arr[1] => 1
        //arr[2] => arr[1] + arr[1] => 1 + 1
        //arr[3] => arr[1] + arr[2] => 1 + 2 = 3
        //arr[4] => 1
        //arr[5] => arr[4] + arr[1] => 1 + 1 = 2
        //arr[6] => arr[4] + arr[2] => 1 + 2 = 3

        //arr[n] = arr[perf squaare] + arr[n-perf square]
      
        for (int i = 1 ; i <= n ; i++){
            
            int min = Integer.MAX_VALUE;

            p_squares.add(i*i);

            for(int j = 0 ; j < p_squares.size() ; j++){
                
                int square = p_squares.get(j);

                if(square > i)
                    continue;
                
                min = Math.min( min, 1 + arr[i - square] );

            }

            arr[i] = min;

        }

        return arr[n];

    }

}
