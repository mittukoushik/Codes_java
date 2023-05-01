// A dangerous virus "ebola" is spreading across african countries.
// Few people stand in a form of p*q grid, some positions in the grid are empty.

// The grid is represented with three values 0,1, 2.
// Where
// 	- 0 indicates an empty position,
// 	- 1 indiactes a healthy person , or
// 	- 2 indiactes an infected person.
	
// Every minute, any healthy person who is 4-directionally adjacent to an infected 
// person becomes infected.

// Your task is to find out the minimum amount of time in minutes that the virus 
// takes to spread among all the people in that grid.

// If this is impossible, return -1.

// NOTE:
// 4-directions are Up, Down, Left, Right.

// Input Format:
// -------------
// Line-1: Two integers P and Q, size of the grid.
// Next P lines: contains Q space separated integers, either 0, 1, or 2.

// Output Format:
// --------------
// An integer, the minimum amount of time in minutes


// Sample Input-1:
// ---------------
// 3 3
// 2 1 1
// 1 1 0
// 0 1 1

// Sample Output-1:
// ----------------
// 4

// Explanation-1:
// --------------
// There is an infected person at position (0, 0).
// In the first minute: people in (0, 1) and (1, 0) positions are infected.
// In the second minute: people in (0, 2) and (1, 1) positions are infected.
// In the third minute: person in (1, 2) position is infected.
// In the fourth minute: person in (2, 2) position is infected.


// Sample Input-2:
// ---------------
// 3 3
// 2 1 1
// 0 1 1
// 1 0 1

// Sample Output-2:
// ----------------
// -1

// Explanation-2:
// --------------
// The healthy person in the bottom left corner (row 2, column 0) is never infected, 
// because infection only happens 4-directionally.

// Sample Input-3:
// ---------------
// 1 2
// 0 2

// Sample Output-3:
// ----------------
// 0

// Explanation-3: 
// -------------
// Since there is already no healthy person at minute 0, the answer is just 0.


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
        int res=0,x=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(g[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(g[i][j]==1){
                    x++;
                }
            }
        }
        if(x==0){
            System.out.println(-1);
            System.exit(0);
        }
        int[][] nbr={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int c=q.size();
            res++;
            while(c>0){
                int []t=q.poll();
                for(int[] i:nbr){
                    int r=t[0]+i[0];
                    int co=t[1]+i[1];
                    if(r<0 || co<0 || r>=n || co>=m || g[r][co]==2 || g[r][co]==0){
                        continue;
                    }
                    g[r][co]=2;
                    x--;
                    q.add(new int[]{r,co});
                }
                c--;
            }
        }
        if(x==0){
            System.out.println(res-1);
        }
        else{
            System.out.println(-1);
        }
    }
}
