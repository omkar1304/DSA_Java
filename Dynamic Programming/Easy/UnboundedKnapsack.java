// https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

public class UnboundedKnapsack {
    static int knapSack(int n, int c, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[n+1][c+1];


        for(int i=0; i<n+1; i++){
            for(int j=0; j<c+1; j++){

                // intilization -> 
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                 // if current size is less or equal than capacity then use max of skip or pick     
                else if(wt[i-1] <= j)
                    dp[i][j] = Math.max(val[i-1]+dp[i][j - wt[i-1]] , dp[i-1][j]);
                // if current size is greater than capacity -> just skip it
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][c];
    }
}
