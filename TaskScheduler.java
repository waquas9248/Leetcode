// You are given an array of CPU tasks tasks, where tasks[i] is an uppercase english character from A to Z. You are also given an integer n.
// Each CPU cycle allows the completion of a single task, and tasks may be completed in any order.
// The only constraint is that identical tasks must be separated by at least n CPU cycles, to cooldown the CPU.
// Return the minimum number of CPU cycles required to complete all tasks.

class Solution {
    public int leastInterval(char[] tasks, int n) {
    
        // Map<Task, Freq> to keep track of task frequencies
        Map<Character, Integer> frequencies = new HashMap<>();

        for( char c: tasks )
            frequencies.put(c, frequencies.getOrDefault(c,0) + 1);
        
        // Priority queue to keep track of all the doable tasks at any moment
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>( (a,b) -> Integer.compare( frequencies.getOrDefault(b.getKey(),0),frequencies.getOrDefault(a.getKey(),0) ) );

        frequencies.entrySet().forEach(entry -> queue.offer(entry));      

        // Map<Second, Map<Task, Freq>> to keep track of each task's cooldown period
        Map<Integer, Map.Entry<Character, Integer>> cooldown = new HashMap<>(); 

        int i = 1;

        while( frequencies.size() > 0 ){
            
            if( cooldown.get(i) != null ){
                queue.offer(cooldown.get(i));
            }

            if(queue.size() > 0){

                //always process the most frequent task first
                Map.Entry<Character, Integer> top = queue.poll();

                int count = frequencies.get(top.getKey());                
                
                if( count <= 1 )
                    frequencies.remove(top.getKey());
                else{
                    frequencies.put(top.getKey(), count - 1);
                    cooldown.put(i+n+1, top);
                }

            }

            i++;   
        }

        return i-1;

    }
}
