// Given an 2D character array, Letters[][], of size r*c.
// You have to construct the word W, using the given array.

// Rules to construct the word are as follows:
// 	- All the letters of the word W, should be adjacent to each other 
// 	in the array Letters(either horizontal or vertical).
// 	- You can use each charcater in Letters[][] only once.

// If you are able to construct the word W, return 'true'
// Otherwise 'false'.

// Input Format:
// -------------
// Line-1 -> two integers R and C, array size.
// R lines -> C space separated characters.
// Last line -> a string, word W

// Output Format:
// --------------
// print the boolean result.


// Sample Input-1:
// ---------------
// 3 3
// a b c
// d e f
// g h i
// bad

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 3 3
// a b c
// d e f
// g h i
// ace

// Sample Output-2:
// ----------------
// false


// Sample Input-3:
// ---------------
// 3 3
// a b c
// d e f
// g h i
// add

// Sample Output-3:
// ----------------
// false


import java.util.*;
class j{
    // static boolean fun(char[][] g,int i,int j,int n,int m,int ind,String s,int[][] vis){
    //     if(ind==s.length()){
    //         return true;
    //     }
    //     if(i<0 || j<0 || i>=n || j>=m ||vis[i][j]==1|| s.charAt(ind)!=g[i][j]){
    //         return false;
    //     }
    //     vis[i][j]=1;
    //     boolean a=fun(g,i+1,j,n,m,ind+1,s,vis);
    //     boolean b=fun(g,i-1,j,n,m,ind+1,s,vis);
    //     boolean c=fun(g,i,j-1,n,m,ind+1,s,vis);
    //     boolean d=fun(g,i,j-1,n,m,ind+1,s,vis);
    //     vis[i][j]=0;
    //     return a||b|| c|| d;
    // }
    public static boolean dfs(int i,int j,int pos,String w,int[][] vis,char arr[][]){
        if(pos==w.length()){
            return true;
        }
        vis[i][j]=1;
        int[] r={-1,0,1,0};
        int[] c={0,1,0,-1};
        for(int k=0;k<4;k++){
            int nr=i+r[k];
            int nc=j+c[k];
            if(nr>=0 && nc>=0 && nr<vis.length && nc<vis[0].length && arr[nr][nc]==w.charAt(pos) && vis[nr][nc]==0){
                if(dfs(nr,nc,pos+1,w,vis,arr)){
                    return true;
                }
            }
        }
        vis[i][j]=0;
        return false;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        char[][] g=new char[n][m];
        for(int i=0;i<n;i++){
            // String[] c=sc.next().split(" ");
            
            for(int j=0;j<m;j++){
                g[i][j]=sc.next().charAt(0);
            }
        }
        int[][] vis=new int[n][m];
        String s=sc.next();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(g[i][j]==s.charAt(0)&& dfs(i,j,1,s,vis,g)){
                    
                        System.out.println(true);
                        System.exit(0);
                    
                }
            }
        }
        System.out.println(false);
    }
}
