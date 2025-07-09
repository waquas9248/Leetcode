// There are n gas stations along a circular route. You are given two integer arrays gas and cost where:
// gas[i] is the amount of gas at the ith station.
// cost[i] is the amount of gas needed to travel from the ith station to the (i + 1)th station. (The last station is connected to the first station)
// You have a car that can store an unlimited amount of gas, but you begin the journey with an empty tank at one of the gas stations.
// Return the starting gas station's index such that you can travel around the circuit once in the clockwise direction. If it's impossible, then return -1.
// It's guaranteed that at most one solution exists.

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0;

        int index = 0;

        int tracking_sum = 0;

        for(int i = 0 ; i < gas.length ; i++){
            sum += gas[i] - cost[i];
            
            tracking_sum += gas[i] - cost[i];

            if(tracking_sum < 0){
                index = (i+1)%cost.length;
                tracking_sum = 0;
            }

        }

        if( sum < 0 )
            return -1;

        return index;         

    }
}
