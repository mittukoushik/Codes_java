// The bomb grid is filled with danger values, with both positive and negative integers.
// positive means you will lose power of grid[i][j], 
// negative means you will gain power of grid[i][j].

// Naresh wants to cross the bridge, with the minimum loss of power.
// He can cross the grid in the following way:
// 	- He can start at any bomb cell in the first row.
// 	- He can step on the next bomb cell in the next row that 
// 	  is either directly below of the current cell or diagonally left/right. 
// 	- Specifically, the next bomb cell from position grid(i, j) will be grid(i+1,j-1),
// 	(i + 1, j) , or (i + 1, j + 1) .

// Can you help Naresh to lose the minimum power after crossing the bomb grid.

// Input Format:
// -------------
// Line-1: An integer N, size of N*N grid 
// Next N lines: N space separated  integers, values in the grid.

// Output Format:
// --------------
// Print an integer, minimum sum of TopDown path.


// Sample Input-1:
// ---------------
// 3
// 1 3 2
// 5 4 6
// 9 8 7

// Sample Output-1:
// ----------------
// 12

// Explanation:
// -------------
// Minimum lose of power is as follows:
// start from bomb cell	1 -> 4 -> 7
// Total lose is 12.


// Sample Input-2:
// ---------------
// 3
// 32 10 23
// -15 14 -16
// 19 -18 17

// Sample Output-2:
// ----------------
// -24

// Explanation:
// -------------
// Minimum lose of power is as follows:
// start from bomb cell	10 -> -16 -> -18
// Total lose is -24.

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] g=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                g[i][j]=sc.nextInt();
            }
        }
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[0][i]=g[0][i];//firs row of dp array
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int up=dp[i-1][j]+g[i][j],leftdia=g[i][j],rightdia=g[i][j];
                if(j>0){
                    leftdia+=dp[i-1][j-1];
                }
                else{
                    leftdia+=99999;
                }
                if(j<n-1){
                    rightdia+=dp[i-1][j+1];
                }
                else{
                    rightdia+=99999;
                }
                dp[i][j]=Math.min(up,Math.min(rightdia,leftdia));
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }
        System.out.println(ans);
    }
}
