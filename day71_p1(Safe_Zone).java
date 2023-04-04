// Brahmi and his gang was chased by group of police officers, unfortunately 
// they all got locked up in a building consist of M*N rooms in the form of 
// a grid. All the rooms are connected with  the adjacent rooms both horizontally
// and vertically. There are few rooms for them to escape called as safe zones. 

// Now help Brahmi and his gang to reach the safe zones in the building.

// In the Building we have the rooms filled with following values: [0,-1,-2] 
// where, -1 -> Danger zone (they should not enter into it).
// 0 -> Safe Zone (room to escape)
// -2 -> a thief

// Now create a method to print the grid after performing following step: 
// Fill each room with one of the member from The Brahmi and his gang with 
// the distance to its nearest safe zone.
// If it is impossible to reach a safezone, fill with '-2' only.

// Input Format:
// -------------
// Line-1 -> two integers M and N, size of the grid of rooms.
// Next M Lines -> N space separated integers, from this set [-2,-1,0] only.

// Output Format:
// --------------
// Print an integer as result.


// Sample Input-1:
// ---------------
// 4 4
// -2 -1 0 -2
// -2 -2 -2 -1
// -2 -1 -2 -1
// 0 -1 -2 -2

// Sample Output-1:
// ----------------
// 3 -1 0 1
// 2 2 1 -1
// 1 -1 2 -1
// 0 -1 3 4



import java.util.*;
class j{
    static int ans=Integer.MAX_VALUE;
    static void dfs(int i,int j,int n,int m,int[][] g,int c){
        if(i<0 || j<0|| i>=n || j>=m || g[i][j]==-1){
            return;
        } 
        if(g[i][j]==0){
            ans=Math.min(ans,c);
            return;
        }
        int tmp=g[i][j];
        g[i][j]=-1;
        dfs(i+1,j,n,m,g,c+1);
        dfs(i-1,j,n,m,g,c+1);
        dfs(i,j+1,n,m,g,c+1);
        dfs(i,j-1,n,m,g,c+1);
        g[i][j]=tmp;
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
            for(int j=0;j<m;j++){
                if(g[i][j]==-2){
                    ans=Integer.MAX_VALUE;
                    dfs(i,j,n,m,g,0);
                    if(ans!=Integer.MAX_VALUE){
                        g[i][j]=ans;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(g[i][j]+" ");
            }
            System.out.println();
        }
    }
}

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] g=new int[n][m];
        boolean[][] vis=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                g[i][j]=sc.nextInt();
                if(g[i][j]==0){
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int[][] nbrs={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int row=temp[0],col=temp[1],c=temp[2];
            vis[row][col]=true;
            if(g[row][col]==-2){
                g[row][col]=c;
                vis[row][col]=true;
            }
            for(int[] nbr:nbrs){
                int nr=row+nbr[0];
                int nc=col+nbr[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc]==false && g[nr][nc]!=-1){
                    q.add(new int[]{nr,nc,c+1});
                }
            }
            
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(g[i][j]+" ");
            }
            System.out.println();
        }
    }
}
