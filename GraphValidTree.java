class Solution {

    List<List<Integer>> adjList = new ArrayList<>();

    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        //edges exactly n-1
        if( edges.length != n-1 )
            return false;

        for(int i = 0 ; i < n ; i++){
            adjList.add(new ArrayList<>()); 
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        if ( !dfs(0,-1) )
            return false;

        if(visited.size() == n)
            return true;

        return false;    

    }

    boolean dfs(int node, int prev){

        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        
        for(int i : adjList.get(node)){
            
            if(i == prev)
                continue;

            if ( !dfs(i,node) )
                return false;

        }
        
        return true;

    }

}
