class Solution {

    Map<Integer, List<Integer>> prMap = new HashMap<>();

    Set<Integer> taken = new HashSet<>();

    List<Integer> order = new ArrayList<>();

    Set<Integer> cycle = new HashSet<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for(int i = 0 ; i < numCourses ; i++){
            prMap.put(i, new ArrayList<Integer>());
        }

        for(int[] prereq: prerequisites ){
            prMap.get(prereq[0]).add(prereq[1]);
        }

        
        for(int c = 0 ; c < numCourses ; c++){
            if ( !dfs(c) ){
                return new int[0];
            }
        }

        return order.stream().mapToInt(i -> i).toArray();
                
    }

    boolean dfs( int course ){

        if(cycle.contains(course)){
            return false;
        }

        if(taken.contains(course)){
            return true;
        }
     
        cycle.add(course);

        for(int c: prMap.get(course)){
            if( !dfs(c) )
                return false;
        }

        order.add(course);

        taken.add(course);

        cycle.remove(course);

        return true;

    }

}
