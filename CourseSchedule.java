class Solution {
    
    Map<Integer, List<Integer>> prMap = new HashMap<>();
    
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            prMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            prMap.get(prereq[0]).add(prereq[1]);
        }

        for(int c = 0; c < numCourses ; c++){

            if( !dfs(c) )
                return false;

        }

        return true;
        
    }
    
    public boolean dfs(int course ){

        if(visited.contains(course))
            return false;
        
        if(prMap.get(course).isEmpty())
            return true;

        visited.add(course);

        List<Integer> prs = prMap.get(course);

        for( int c = 0 ; c < prs.size(); c++ ){
            
            if(! dfs(prs.get(c)) )            
                return false;

        }
        
        visited.remove(course);

        prMap.put(course, new ArrayList<>());

        return true;

    }
}
