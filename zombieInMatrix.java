/* 
Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?

Example:

Input:
[[0, 1, 1, 0, 1],
 [0, 1, 0, 1, 0],
 [0, 0, 0, 0, 1],
 [0, 1, 0, 0, 0]]

Output: 2

Explanation:
At the end of the 1st hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [0, 1, 0, 1, 1],
 [1, 1, 1, 0, 1]]

At the end of the 2nd hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1]]
int minHours(int rows, int columns, List<List<Integer>> grid) {
	// todo
}

Time Complexity = O(m*n), where m is the rows, n is the columns in matrix 
Space Complexity = O(m*n) worst case where all the cells of the matrix is a zombie, we need a queue of size m*n 
Idea: We use BFS. We visit each cell's neighbors before visiting its neighbors. Idea is to somehow keep track of all the zombies in a particular level. Every level when some humans are made zombies, 
we keep incrementing the level. When the level reaches the number of cells in the matrix, all the humans have tuned zombies, so we return
*/ 

class Solution 
{
    private int[] rowArr = {-1,0,1,0}; 
    private int[] colArr = {0,-1,0,1}; 
    private int zombiesInMatrix(int[][] matrix) 
    {
        int timeToLive = 0; 
        if(matrix == null || matrix.length == 0) 
        {
          return timeToLive; 
        }
        int count = 0; 
        int targetZombies = matrix.length * matrix[0].length; 
        
        // Identify how many zombies we have, add them to a queue 
        Queue<int[]> queue = new LinkedList<int[]>(); 
        for(int i =0; i< matrix.length; i++)
        {
          for(int j =0; j< matrix[0].length; j++)
          {
            if(matrix[i][j] == 1) 
            { 
              count++; 
              //mark the row column as a zombie, since its neighbors must be tirned to zombies next 
              queue.add(new int[]{i,j}); 
            }
          }
        }  
        
       while(!queue.isEmpty())
       {
          //explore neighbors of zombies in this level 
          int size = queue.size(); 
          if(count == target) 
          {
            return timeToLive; 
          }
          for(int i =0; i< size; i++)
          {
            int[] node = queue.poll(); 
            // get the node's neighbors 
            for(int j =0; j< 4; j++)
            {
              int newRow = node[0] + rowArr[j]; 
              int newCol = node[1] + coArr[j]; 
              if(newRow >0 && newCol > 0 && newRow < matrix.length && newCol < matrix[0].length && matrix[newRow][newCol] == 0) 
              {
                //identified a human, make him a zombie 
                matrix[newRow][newCol] = 1; 
                count++; // zombie count increase 
                queue.add(new int[]{newRow, newCol}); //add new zombie to the queue 
              }
            }
           }
           timeToLive++; // Once all zombies in a level are visited, we increase the time by 1 hour
        }
        return -1; 
    }
}    
            
              
        
        
        
