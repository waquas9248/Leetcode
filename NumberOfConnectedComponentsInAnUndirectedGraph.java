class Solution {

    List<List<Integer>> adjList = new ArrayList<>();

    List<Integer> visited = new ArrayList<>();

    public int countComponents(int n, int[][] edges) {

        //create empty lists
        for(int i = 0; i < n ; i++){
            adjList.add(new ArrayList<>());
            visited.add(i);
        }

        //put each edge node in the list of spec. node
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int components = 0;

        //dfs on each unvisited node
        while(!visited.isEmpty()){
            
            int node = visited.get(0);

            dfs(node, new ArrayList<>());

            components++;

        }

        return components;

    }

    void dfs(int node, List<Integer> cycle){
        
        if(cycle.contains(node))
            return;
        
        cycle.add(node);

        for(int i: adjList.get(node)){
            dfs(i, cycle);
        }

        visited.remove(new Integer(node));

        return;

    }

}
