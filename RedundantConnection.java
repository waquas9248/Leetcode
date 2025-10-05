class Solution {

    List<List<Integer>> adjList = new ArrayList<>();

    List<Integer> visited = new ArrayList<>();
    
    public int[] findRedundantConnection(int[][] edges) {

        for(int i = 0 ; i <= edges.length ; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        dfs(1, -1);

        for(int i = edges.length - 1 ; i >= 0 ; i--){

            if(visited.contains(edges[i][0]) && visited.contains(edges[i][1]))
                return new int[]{edges[i][0], edges[i][1]};

        }

        return new int[]{};
        
    }

    public boolean dfs(int node, int parent){

        if(visited.contains(node)){
            visited = visited.subList(visited.indexOf(node), visited.size());
            return true;
        }

        visited.add(node);

        for(int n: adjList.get(node)){
            if(n == parent){
                continue;
            }
            if (dfs(n, node)){
                return true;
            }
        }

        visited.remove(Integer.valueOf(node));

        return false;

    }

}
