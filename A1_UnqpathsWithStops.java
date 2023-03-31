// You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

// Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// Example 1:
// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2
// Explanation: There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right

// Example 2:
// Input: obstacleGrid = [[0,1],[0,0]]
// Output: 1

// Constraints:

// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] is 0 or 1.

// input format
// Input=2
// 2
// 0 1
// 0 0
// Output=1
import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] g=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                g[i][j]=sc.nextInt();
            }
        }
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }
                else if(g[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                else{
                    int u=0,l=0;
                    if(i>0){
                        u=dp[i-1][j];
                    }
                    if(j>0){
                        l=dp[i][j-1];
                    }
                    dp[i][j]=u+l;
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
