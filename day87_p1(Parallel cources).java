// EA Sports, developed a video game. They designed a game in such a way that, 
// there are L number of levels from 1 to L. There are D number of dependencies
// where each dependency[m] = [ Xm, Ym ], represents a prerequisite relationship,
// that is, in order to play level-Ym, you must have completed the level-Xm.

// In one day you can complete any number of levels as long as you 
// have completed all the prerequisites levels in the game. 

// You cannont play a level-Ym which has some prerequisite level-Xm on same day.

// Write a method to return the minimum number of days to complete all the levels
// in the game. If there is no way to complete all the levels, return -1.


// Input Format:
// -------------
// Line-1: An integer L, number of levels.
// Line-2: An integer D, number of dependencies.
// Next D lines: Two space separated integers, Xm and Ym.

// Output Format:
// --------------
// An integer, the minimum number of days to complete all the levels in the game.


// Sample Input-1:
// ---------------
// 3
// 2
// 1 3
// 2 3

// Sample Output-1:
// ----------------
// 2

// Explanation-1:
// --------------
// On the first day, levels 1 and 2 are completed. 
// On the second day, level-3 is completed.


// Sample Input-2:
// ---------------
// 3
// 3
// 1 2
// 2 3
// 3 1

// Sample Output-2:
// ----------------
// -1

// Explanation-2:
// -------------
// No level can be completed because they depend on each other.


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int mm=sc.nextInt();
        int[][] g=new int[mm][2];
        for(int i=0;i<mm;i++){
            g[i][0]=sc.nextInt();
            g[i][1]=sc.nextInt();
        }
        Map<Integer,List<Integer>> m=new HashMap<>();
        for(int i=1;i<=n;i++){
            m.put(i,new ArrayList<>());
        }
        for(int i[]:g){
            m.get(i[1]).add(i[0]);
        }
        int[] indg=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j:m.get(i)){
                indg[j]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indg[i]==0){
                q.add(i);
            }
        }
        int c=0;
        while(!q.isEmpty()){
            c++;
            int b=q.size();
            while(b-->0){
                int front=q.poll();
                for(int i:m.get(front)){
                    indg[i]--;
                    if(indg[i]==0){
                        q.add(i);
                    }
                }
            }
        }
        for(int i:indg){
            if(i!=0){
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(c);
    }
}
