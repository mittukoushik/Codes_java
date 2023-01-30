// Given a matrix of 0's and 1's of dimension rows X cols.

// We could traverse from one element(row, col) to any other element(row + 1, col) or (row, col + 1).

// Print 'true' if there is any path from first element(0,0) of the matrix to the last element(rows - 1, cols - 1) 
// of the matrix that visits the same number of 1's and 0's.
// Print 'false' otherwise.


// Input Format
// -------------
// Line-1: Read two integers rows and cols(space separated).
// Line-2: Read the matrix of dimension rows X cols.

// Output Format
// --------------
// If the required path exist print 'true' otherwise 'false'.


// Sample input-1
// 3 4
// 0 1 1 0
// 0 0 0 0
// 0 0 1 0
// Sample output-1
// true

// Explanation: In the given matrix there is a path that is having three 0's and three 1's.

// Sample input-2
// 4 3
// 0 0 1
// 1 0 0
// 0 0 0
// 0 0 1
// Sample output-2
// false

// Explanation: There is NO path that is having same number of 0's and 1's.

import java.util.*;
class j{
    static Set<String> set=new HashSet<>();
    static void dfs(int i,int j,int[][] a,int n,int m,String s){
        if(i<0 || j<0 || i>=n || j>=m){
            return;
        }
        s=s+String.valueOf(a[i][j]);
        dfs(i+1,j,a,n,m,s);
        if(i==n-1 && j==m-1 ){
            set.add(s);
        }
        dfs(i,j+1,a,n,m,s);
        if(i==n-1 && j==m-1 ){
            set.add(s);
        }
    }
    static boolean fun(String s){
        int zc=0,oc=0;
        for(char i:s.toCharArray()){
            if(i=='0'){
                zc++;
            }
            else{
                oc++;
            }
        }
        return oc==zc;
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
        String s="";
        dfs(0,0,a,n,m,s);
        for(String i:set){
            if(fun(i)){
                System.out.println(true);
                System.exit(0);
            }
            
        }
        System.out.println(false);
    }
}
