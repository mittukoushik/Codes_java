// You are playing a shooting game.
// There are N bottles hanging to a rod, i-th bottle numbered bottle[i].

// If you shoot i-th bottle, you will get bottle[i-1]*bottle[i]*bottle[i+1] points.
// The more points you score, the more rewards you can win.

// Your task is to score the maximum points by shooting all the ballons wisely.

// Note: After you shoot bottle at i-th index, bottles at i-1 and i+1 positions
// become adjacent. if there is no existing 'i-1' or 'i+1' positions for selected bottle.
// you can assume that bottle[i-1] = bottle[i+1] = 1.

// Input Format:
// -------------
// N space separated integers bottles[].

// Output Format:
// --------------
// Print an integer, maximum points you can get.


// Sample Input:
// ---------------
// 3 1 5 8

// Sample Output:
// ----------------
// 167

// Explanation:
// ------------
// Given bottles = [3, 1, 5, 8] 
// position 	points
// --------------------
// 1				3*1*5
// 5				3*5*8
// 3				1*3*8
// 8				1*8*1
// --------------------
// Total = 167


// Sample Input:
// ---------------
// 2 1 3 5 4

// Sample Output:
// ----------------
// 102

// Explanation:
// ------------
// Given bottles = [2, 1, 3, 5, 4] 

// position 	points
// --------------------
// 5				3*5*4
// 1				2*1*3
// 3				2*3*4
// 2				1*2*4
// 4				1*4*1
// --------------------
// Total = 102


import java.util.*;
class j{
    static int fun(int i,int j,int[] a,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int maxi=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int ans=a[i-1]*a[k]*a[j+1]+fun(i,k-1,a,dp)+fun(k+1,j,a,dp);
            maxi=Math.max(maxi,ans);
        }
        return dp[i][j]=maxi;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int[] a=new int[s.length+2];
        a[0]=1;
        a[a.length-1]=1;
        int j=1;
        for(int i=0;i<s.length;i++){
            a[j++]=Integer.parseInt(s[i]);
        }
        int n=s.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        System.out.println(fun(1,n,a,dp));
    }
}
