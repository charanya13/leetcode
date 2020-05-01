/* 
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 

Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.

Time = O(n), n being the number of nodes. Since we maintian a visited set, we do not visit a node more than once.
Space = O(n), for the hashMap 
*/

class Solution {
    int index = 0; 
    HashMap<Integer, List<Integer>> graph;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // create a map for storing the graph 
        graph = new HashMap<>(); 
        List<List<Integer>> ans = new ArrayList<>(); 
        
        for(List<Integer> connection: connections)
        {
            int u = connection.get(0); 
            int v = connection.get(1); 
            if(graph.containsKey(u))
            {
                graph.get(u).add(v); 
            } else {
                List<Integer> l = new ArrayList<>(); 
                l.add(v); 
                graph.put(u, l); 
            }
            
            // for v 
            if(graph.containsKey(v))
            {
                graph.get(v).add(u); 
            }else {
                List<Integer> l = new ArrayList<>(); 
                l.add(u); 
                graph.put(v, l); 
            }
        }
        
        int[] disc = new int[n]; 
        int[] low = new int[n]; 
        Arrays.fill(disc, -1); 
        
        for(int i =0; i< n; i++)
        {
            if(disc[i] == -1) 
            {
                tarjon(i, disc, low, ans, i); 
            }
        }
        return ans; 
    }
    
    private void tarjon(int u, int[] disc, int[] low, List<List<Integer>> ans, int prevU)
    {
        disc[u] = low[u] = ++index; 
        for(int vertex: graph.get(u))
        {
            if(vertex == prevU)
            {
                continue;  // since this is a parent 
            }
            if(disc[vertex] == -1) 
            {
                // vertex is not visited so recur 
                tarjon(vertex, disc, low, ans, u); 
                low[u] = Math.min(low[u], low[vertex]); 
                if(low[vertex] > disc[u])
                {
                    ans.add(Arrays.asList(u, vertex)); 
                }
            } else {
                low[u] = Math.min(low[u], disc[vertex]); 
            }
        }
    }
}
