// A merchant has two types of idols, gold and silver.
// He has arranged the idols in the form of m*n grid, 
// 	- the gold idols are represented as 1's 
// 	- the silver idols are represented as 0's.

// Your task is to find the longest consecutive arrangement of gold idols, 
// The arrangement can be either horizontal, vertical, diagonal or 
// antidiagonal, but not the combination of these.


// Input Format:
// -------------
// Line-1: Two space separated integers m and n, grid size.
// Next m lines : n space separated integers, arrangement of idols.

// Output Format:
// --------------
// Print an integer, longest arranement of gold idols.


// Sample Input:
// ---------------
// 4 5
// 1 0 1 1 1
// 0 1 0 1 0
// 1 0 1 0 1
// 1 1 0 1 1

// Sample Output:
// ----------------
// 4
import java.util.*;
class j{
    static int ans=0;
    static int hor(int i,int j,int n,int m,int[][] a){
        if(i<0 || j<0 || i>=n || j>=m || a[i][j]==0){
            return 0;
        }
        return 1+hor(i,j+1,n,m,a);
    }
    static int ver(int i,int j,int n,int m,int[][] a){
        if(i<0 || j<0 || i>=n || j>=m || a[i][j]==0){
            return 0;
        }
        return 1+ver(i+1,j,n,m,a);
    }
    static int dia(int i,int j,int n,int m,int[][] a){
        if(i<0 || j<0 || i>=n || j>=m || a[i][j]==0){
            return 0;
        }
        return 1+dia(i+1,j+1,n,m,a);
    }
    static int anti(int i,int j,int n,int m,int[][] a){
        if(i<0 || j<0 || i>=n || j>=m || a[i][j]==0){
            return 0;
        }
        return 1+anti(i-1,j+1,n,m,a);
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==1){
                    ans=Math.max(ans,hor(i,j,n,m,a));
                    ans=Math.max(ans,ver(i,j,n,m,a));
                    ans=Math.max(ans,dia(i,j,n,m,a));
                    ans=Math.max(ans,anti(i,j,n,m,a));
                }
            }
        }
        System.out.println(ans);
    }
}
