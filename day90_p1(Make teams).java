// In a school, there are N students in a class numbered from 1,2,3..N.
// During the play time in school, drill master wants to split them into 
// two teams based on their interest.

// If the pair of students want to play opposite each other, drill master should 
// put them in different teams, e.g. pair[i] = (A,B), it is not allowed to 
// put A and B in same team.
 
// You need to find out wether is it possible to put everyone into two teams or not
// return true if it is possible, otherwise false.

// Input Format:
// ----------------
// Line-1 -> Two Integers, N and P, number of students N, number of pairs P.
// Next P lines -> Two integers, one pair[i], where 'i' is from 0 to P-1

// Output Format:
// ------------------
// Print a boolean result.


// Sample Input-1:
// -------------------
// 5 4
// 1 2
// 1 3
// 2 4
// 3 5

// Sample Output-1:
// ---------------------
// true

// Explanation: 
// ----------------
// team1 [1,4,5], team2 [2,3]


// Sample Input-2:
// -------------------
// 5 5
// 1 2
// 2 3
// 3 4
// 4 5
// 1 5

// Sample Output-2:
// ---------------------
// false


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] g=new int[m][2];
        for(int i=0;i<m;i++){
            g[i][0]=sc.nextInt();
            g[i][1]=sc.nextInt();
        }
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<=n;i++){
            l.add(new ArrayList<>());
        }
        for(int i[]:g){
            l.get(i[0]).add(i[1]);
            l.get(i[1]).add(i[0]);
        }
        int[] col=new int[n+1];
        for(int i=1;i<=n;i++){
            if(col[i]==0 && !(dfs(l,col,i,1))){
                System.out.println(false);
                System.exit(0);
            }
        }
        System.out.println(true);
    }
    static boolean dfs(List<List<Integer>> l,int[] col,int i,int color){
        col[i]=color;
        for(int j:l.get(i)){
            if(col[j]==0){
                if(!(dfs(l,col,j,-color))){
                    return false;
                }
            }
            else if(col[j]==color){
                return false;
            }
        }
        return true;
    }
}
