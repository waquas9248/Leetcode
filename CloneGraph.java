// Given a node in a connected undirected graph, return a deep copy of the graph.

// Each node in the graph contains an integer value and a list of its neighbors.

// class Node {
//     public int val;
//     public List<Node> neighbors;
// }
// The graph is shown in the test cases as an adjacency list. An adjacency list is a mapping of nodes to lists, used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

// For simplicity, nodes values are numbered from 1 to n, where n is the total number of nodes in the graph. The index of each node within the adjacency list is the same as the node's value (1-indexed).

// The input node will always be the first node in the graph and have 1 as the value.


/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
    
class Solution {
    public Node cloneGraph(Node node) {

        return dfs(node, new HashMap<Integer, Node>() );


    }

    public Node dfs(Node node, Map<Integer, Node> nodes){

        if( node == null )
            return null;

        if( !nodes.containsKey(node.val) ){
            
            Node copy = new Node(node.val);

            nodes.put(copy.val, copy);

            for( Node neighbor: node.neighbors ){
                
                if(nodes.containsKey(neighbor.val)){
                    copy.neighbors.add(nodes.get(neighbor.val));
                } else{
                    copy.neighbors.add(dfs(neighbor, nodes));
                }                

            }
                                                                    
        }


        return nodes.get(node.val);

    }

}

