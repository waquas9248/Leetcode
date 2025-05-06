// Given an unsorted array of integers nums and an integer k, return the kth largest element in the array.
// By kth largest element, we mean the kth largest element in the sorted order, not the kth distinct element.
// Follow-up: Can you solve it without sorting?

class Solution {

    PriorityQueue<Integer> maxHeap;

    public int findKthLargest(int[] nums, int k) {

        maxHeap = new PriorityQueue<>();

        for(int n : nums){

            maxHeap.offer(n);

            if( maxHeap.size() > k )
                maxHeap.poll();

        }
        
        return maxHeap.poll();

    }
    
}
