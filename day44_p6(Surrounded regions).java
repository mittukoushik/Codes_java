// Chitti(ROBO) is busy in turning the people into chittis(ROBOS) by surrounding them.
// In a room there are n*n boxes occupied by ROBOS and people.
//    1.A person will be turned into ROBO if he is surrounded by all ROBOs. 
//    2.A person will not be turned into ROBO if he is on the edge of the room
//      and all the connected people to him (directly or indirectly) are also not to be turned.
//  Return the n*n boxes after conversion.
 
// Input Format
// -------------
// Line-1:integer n represent the n*n boxes of the room..
// Next n lines:Each line of string consists of combination of 'X'(represents ROBO) and 'O'(represents a person)
   
// Output Format:
// --------------
// Print n*n space seperated values after conversion.
  
   
// Sample Input-1:
// ---------------
// 4
// XXXX
// XOOX
// XXOX
// OXXX
   
// Sample Output-1:
// ----------------
// X X X X 
// X X X X 
// X X X X 
// O X X X 
   
// Explanation:
// ------------
// The people at second row and third row are converted to ROBOs as they are surrounded by ROBOs.
// But the person at fourth row is safe as he is on edge.
  
   
// Sample Input-2:
// ---------------
// 5
// XOOOX
// XXXXX
// XOXXX
// XXXOX
// OXXXX
  
// Sample Output-2:
// ----------------
// X O O O X 
// X X X X X 
// X X X X X 
// X X X X X 
// O X X X X 
// 4
// XXXX
// XOOX
// XXOX
// OXXX
import java.util.*;
class j{
    static void dfs(int i,int j,int n,int m,boolean[][] vis,char[][] g){
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j]==true || g[i][j]=='X'){
            return;
        }
        vis[i][j]=true;
        dfs(i+1,j,n,m,vis,g);
        dfs(i-1,j,n,m,vis,g);
        dfs(i,j+1,n,m,vis,g);
        dfs(i,j-1,n,m,vis,g);
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[][] g=new char[n][n];
        for(int i=0;i<n;i++){
            String s=sc.next();
            for(int j=0;j<s.length();j++){
                g[i][j]=s.charAt(j);
            }
        }
        boolean[][] vis=new boolean[n][n];
        for(int i=0;i<n;i++){
            if(g[i][0]=='O' && vis[i][0]==false){
                dfs(i,0,n,n,vis,g);
            }
            if(g[i][n-1]=='O' && vis[i][n-1]==false){
                dfs(i,n-1,n,n,vis,g);
            }
        }
        for(int i=0;i<n;i++){
            if(g[n-1][i]=='O' && vis[n-1][i]==false){
                dfs(n-1,i,n,n,vis,g);
            }
            if(g[0][i]=='O' && vis[0][i]==false){
                dfs(0,i,n,n,vis,g);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==false && g[i][j]=='O'){
                    g[i][j]='X';
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(g[i][j]+" ");
            }
            System.out.println();
        }
    }
}
