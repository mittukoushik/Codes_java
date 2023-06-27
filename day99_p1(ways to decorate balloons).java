//lc-1411

// Mohan is given a task to decorate a wall with balloons.
// He is given an unlimited set of ballons of three different colors.

// The decoration should have N rows of 3 balloons each. 
// He has to make sure that no two adjacent balloons have the same colour.
// both vertically and horizontally.

// Your task is to help Mr Mohan to find the number of ways to decorate the wall,  
// the answer must be computed modulo 10^9 + 7

// Input Format:
// -------------
// An integer N

// Output Format:
// --------------
// Print an integer as outpur, number of ways to decorate.


// Sample Input-1:
// ---------------
// 1

// Sample Output-1:
// ----------------
// 12

// Explanation:
// ------------
// Suppose the colors are, B-Blue, W-White, R-Red. Given N is 1
// RBR	BRB	WRB
// RBW	BRW	WRW
// RWR	BWR	WBR
// RWB	BWB	WBW


// Sample Input-2:
// ---------------
// 2

// Sample Output-2:
// ----------------
// 54

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int mod=(int)Math.pow(10,9)+7;
        long[][] dp=new long[n][2];
        // dp[row][0]->3clr  dp[row][1]->2clr
        // for n==1 there will be 6 2 clr rows amd 6 3 clr rows so
        Arrays.fill(dp[0],6);
        //in general if we take 3 clrs in ith row there can be 2 twocolored rows and 2 threecolored rows in i+1th row
        //in general if we take 2 clrs in ith row there can be 3 twocolored rows and 2 threecolored rows in i+1th row
        for(int i=1;i<n;i++){
            dp[i][0]=(dp[i-1][0]*2+dp[i-1][1]*2)%mod;
            dp[i][1]=(dp[i-1][0]*2+dp[i-1][1]*3)%mod;
        }
        System.out.println((int)(dp[n-1][0]+dp[n-1][1])%mod);
    }
}
