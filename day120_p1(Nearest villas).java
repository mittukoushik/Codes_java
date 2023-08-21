//lc-1162

// Few people are living in a township of size N*N, where each 1*1 part 
// of the township is either a villa or a swimming pool. 
// You are given the structure of township as a 2d matrix of size N*N, 
// filled with 0's and 1's, where '0'-indicates a swimming pool and 
// '1'- indiactes a villa. 

// Your task is to find a swimming pool, such that its distance to 
// the nearest villa(s) is maximized, and return the distance.

// If the township contains only the villas or only swimming pools, print '-1'. 

// The distance used in this problem is the Manhattan distance: 
// the distance between two cells (a0, b0) and (a1, b1) is |a0 - a1| + |b0 - b1|


// Input Format:
// -------------
// Line-1: An integer N, size of the 2d matrix.
// Next N lines: N space separated integers, matrix[][] either 0 or 1.

// Output Format:
// --------------
// An integer, maximum distance.


// Sample Input-1:
// ---------------
// 4
// 1 0 1 1
// 0 0 0 0
// 1 0 1 0
// 1 0 0 1

// Sample Output-1:
// ----------------
// 2

// Explanation: 
// ------------
// The swimming pool at (1, 1) is with distance 2 from the nearest villas.


// Sample Input-2:
// ---------------
// 4
// 1 0 0 0
// 0 0 0 0
// 1 0 0 0
// 0 1 0 1

// Sample Output-2:
// ----------------
// 3

// Explanation: 
// ------------
// The swimming pool at (0,3) or (1, 2) are with distance 3 from the nearest villas.


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] g=new int[n][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                g[i][j]=sc.nextInt();
                if(g[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }
        int res=0;
        int[][]nbrs={{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int c=q.size();
            while(c-->0){
                int[] t=q.poll();
                for(int[] nbr:nbrs){
                    int nr=t[0]+nbr[0];
                    int nc=t[1]+nbr[1];
                    if(nr<0 || nc<0 ||nr>=n ||nc>=n||g[nr][nc]==1){
                        continue;
                    }
                    g[nr][nc]=1;
                    q.add(new int[]{nr,nc});
                }
            }
            res++;
        }
        if(res==1){
            System.out.println(-1);
            System.exit(0);
        }
        System.out.println(res-1);
    }
}
