// Kittu playing a game, the game contains a panel of N cells.
// Each cell in the panel is a number panel[i], 
// Kittu will win when he reaches 0.

// The rules to play the game are as follows:
// 	- Kittu's intital position is S.
// 	- When Kittu is at index i, he can move to position-(i + panel[i] ) or 
// 	position-(i - panel[i]).
// 	- Kittu cannot move outside the panel.
// 	- if he reaches any panel[i] has value 0, He wins.	

// Your task to find that whether kittu wins or not.
// if he wins print "true".
// if there is no way to reach 0 then print "false".

// NOTE: cell positions are numbered from 0 to N-1.
// 0<= panel[i] < N


// Input Format:
// -------------
// Line-1: Two integers N and S, number of cells in the panel and 
// 		Kittu's initial position.
// Line-2: N space separated integers.

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 7 5
// 4 2 3 0 3 1 2

// Sample Output-1:
// ----------------
// true

// Explanation: 
// ------------
// All possible ways to reach at position 3 with value 0 are: 
// position 5 -> position 4 -> position 1 -> position 3 
// position 5 -> position 6 -> position 4 -> position 1 -> position 3 


// Sample Input-2:
// ---------------
// 5 2
// 3 0 2 1 2

// Sample Output-2:
// ----------------
// false


import java.util.*;
class j{
    static boolean fun(int[] a,int n,boolean[] vis,int ind){
        if(ind>n-1 || ind<0 || vis[ind]==true){
            return false;
        }
        vis[ind]=true;
        if(a[ind]==0){
            return true;
        }
        return fun(a,n,vis,ind-a[ind])||fun(a,n,vis,ind+a[ind]);
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ind=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        boolean[] vis=new boolean[n];
        System.out.println(fun(a,n,vis,ind));
    }
}
