// You are given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize.
// You want to rearrange the cards into groups so that each group is of size groupSize, and card values are consecutively increasing by 1.
// Return true if it's possible to rearrange the cards in this way, otherwise, return false.

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if ( hand.length % groupSize != 0)
            return false;
        
        int n = hand.length / groupSize;

        HashMap<Integer, Integer> counts = new HashMap<>();

        for(int num: hand){
            int count = counts.getOrDefault(num,0);
            //count cannot be more than no. of groups
            if( count > n )
                return false;
            counts.put(num, count + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(counts.keySet());

        while(!minHeap.isEmpty()){

            int start = minHeap.peek();

            for(int i = start ; i < start + groupSize; i++ ){

                int count = counts.getOrDefault(i,0);

                if( count == 0 )
                    return false;

                counts.put(i,count-1);

                if( count == 1 ){
                     
                    if( i != minHeap.peek() )
                        return false;
                    
                    minHeap.poll();

                }

            }

        }

        return true;

    }
}
