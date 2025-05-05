// You are given an array of integers stones where stones[i] represents the weight of the ith stone.
// We want to run a simulation on the stones as follows:
// At each step we choose the two heaviest stones, with weight x and y and smash them togethers
// If x == y, both stones are destroyed
// If x < y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
// Continue the simulation until there is no more than one stone remaining.
// Return the weight of the last remaining stone or return 0 if none remain.

class Solution {

    PriorityQueue<Integer> maxHeap;

    public int lastStoneWeight(int[] stones) {
        
        maxHeap = new PriorityQueue<>( (a,b) -> Integer.compare(b,a) );

        for(int weight: stones)
            maxHeap.offer(weight);

        while( maxHeap.size() > 1 ){

            int firstWeight = maxHeap.poll();

            int secondWeight = maxHeap.poll();

            if( firstWeight == secondWeight)
                continue;
            else
                maxHeap.offer( Math.abs(firstWeight - secondWeight) );

        }

        if( maxHeap.size() == 0 )
            return 0;
        
        return maxHeap.peek();

    }
  
}
