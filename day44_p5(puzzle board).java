// Pranav has a puzzle board filled with square boxes in the form of a grid.
// Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

// Pranav wants to find out the number of empty spaces which are completely 
// surrounded by the square boxes (left, right, top, bottom) in the board.

// You are given the board in the form of a grid M*N, filled wth 0's and 1's.
// Your task is to help Pranav to find the number of empty groups surrounded by
// the boxes in the puzzle board.

// Input Format:
// -------------
// Line-1: Two integers M and N, the number of rows and columns in the board.
// Next M lines: contains N space-separated either 0 or 1.

// Output Format:
// --------------
// Print an integer, the number of empty spaces in the puzzle board.


// Sample Input-1:
// ---------------
// 6 7
// 1 1 1 1 0 0 1
// 1 0 0 0 1 1 0
// 1 0 0 0 1 1 0
// 0 1 1 1 0 1 0
// 1 1 1 0 0 1 1
// 1 1 1 1 1 1 1

// Sample Output-1:
// ----------------
// 2


// Sample Input-2:
// ---------------
// 6 6
// 1 1 0 0 1 1
// 1 0 1 1 0 1
// 0 1 0 1 0 0
// 1 1 0 0 0 1
// 0 0 1 0 1 1
// 1 1 0 1 0 0

// Sample Output-2:
// ----------------
// 1


import java.util.*;
class j{
    static void dfs(int i,int j,int n,int m,int[][] g){
        if(i<0 || j<0 || i>=n || j>=m || g[i][j]==1){
            return;
        }
        g[i][j]=1;
        dfs(i+1,j,n,m,g);
        dfs(i-1,j,n,m,g);
        dfs(i,j+1,n,m,g);
        dfs(i,j-1,n,m,g);
    }
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
        for(int i=0;i<n;i++){
            if(g[i][0]==0){
                dfs(i,0,n,m,g);
            }
            if(g[i][m-1]==0){
                dfs(i,m-1,n,m,g);
            }
        }
        for(int i=0;i<m;i++){
            if(g[0][i]==0){
                dfs(0,i,n,m,g);
            }
            if(g[n-1][i]==0){
                dfs(n-1,i,n,m,g);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(g[i][j]==0){
                    dfs(i,j,n,m,g);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
