// Ibrahim is an interior designer wants to color wall of size M*N. 
// He plans to color the wall and put lights of two different colors

// The designer can lit the wall using M*N lights.The lights are Blue or pink
// in color.Blue colored lights represented with digit-1 and pink colored lights 
// represented with digit-0.

// The Blue colored lights forms different shapes, that are connected 4 directonally.
// The directons are upwards, downwards, left, and right. Ibrahim got an idea to 
// count the unique shapes formed by blue colored lights.

// You will be given the decorated wall as a matrix wall[][].
// Your task is to help Ibrahim to count the unique shapes by the lights.

// Input Format:
// -------------
// Line-1: Two space separated integers M and N, size of the wall.
// Next M lines: N space separated integers, either 0 or 1.

// Output Format:
// --------------
// Print an integer, Number of distinct shapes formed by Blue Lights.


// Sample Input-1:
// ---------------
// 4 5
// 1 1 0 1 1
// 1 1 0 0 1
// 0 0 0 0 0
// 1 1 0 0 0

// Sample Output-1:
// ----------------
// 3


// Sample Input-2:
// ---------------
// 5 5
// 1 1 0 1 1
// 1 0 0 0 1
// 0 0 0 0 0
// 1 0 0 0 1
// 1 1 0 1 1

// Sample Output-2:
// ----------------
// 4

import java.util.*;
class j{
    static Set<Set<String>> l=new HashSet<>();
    static void dfs(int i,int j,int n,int m,int[][] a,int i1,int j1,Set<String> l1){
        if(i<0 || j<0 || i>=n || j>=m || a[i][j]==0){
            return;
        }
        a[i][j]=0;
        l1.add(Integer.toString(i-i1)+" "+Integer.toString(j-j1));
        dfs(i+1,j,n,m,a,i1,j1,l1);
        dfs(i-1,j,n,m,a,i1,j1,l1);
        dfs(i,j+1,n,m,a,i1,j1,l1);
        dfs(i,j-1,n,m,a,i1,j1,l1);
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
                    Set<String> l1=new HashSet<>();
                    dfs(i,j,n,m,a,i,j,l1);
                    l.add(l1);
                }
            }
        }
        System.out.println(l.size());
    }
}
