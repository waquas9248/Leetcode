//Neetcode - 150

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // create a hashmap with elements and freq.
        HashMap<Integer,Integer> frequencies = new HashMap<>();

        for( int i = 0 ; i < nums.length ; i++ ){
            frequencies.put(nums[i], frequencies.getOrDefault(nums[i],0) + 1);
        }

        //max-heap to store frequency counts
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(frequencies.get(b),frequencies.get(a)));

        for( Integer i : frequencies.keySet() ){
            maxHeap.add(i);
        }

        int kCount = 0;
        int[] kTop = new int[k];


        while( kCount < k ){
            kTop[kCount] = maxHeap.poll();
            kCount++;
        }

        return kTop;

    }
}
