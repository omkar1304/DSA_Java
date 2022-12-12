// https://leetcode.com/problems/maximal-square/

public class MaximalSquare {
    public int helper(char[][] matrix, int i, int j, int[][] dp){
        // base case
        
        // if index out of bound and matrix[i][j] == 0 then we cant take this side hence retrun 0
        if(i < 0 || j < 0 || i >= matrix.length || j>= matrix[0].length || matrix[i][j] == '0')
            return 0;
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // to form square from current cell(i.e. matrix[i][j]) we need to explore three directions -> right , down, diagonal 
        // hence explore all three directions to get side
        int right = helper(matrix, i, j+1, dp);
        int down = helper(matrix, i+1, j, dp);
        int diagonal = helper(matrix, i+1, j+1, dp);
        
        // why min? as if right returns side 3 , left returns side 4, down retruns side 2 then 
        // we cant take max adn return as we know every side should be same so by taking min we can ensure that it min side is possible in every direction
        // add 1 as current cell also need to add with min of three directions and return
        return dp[i][j] = 1 + Math.min(diagonal, Math.min(right, down));
    }
    
    public int maximalSquare(char[][] matrix) {
        // Memoization ->
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0; i<matrix.length+1; i++){
            for(int j=0; j<matrix[0].length+1; j++){
                dp[i][j] = -1;
            }
        }
        
        // here passing each cell in matrix which contains 1 in it and calculating current area.
        // and after that storing max area and retrun it at last.
        int maxArea = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    int side = helper(matrix, i, j, dp);
                    int currArea = side * side;
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }
        
        return maxArea;
    }
}
