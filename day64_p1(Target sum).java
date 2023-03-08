// You are given a set of N integers, and a value to find F. Initially a variable, 
// 'total' is set to 0. You can perform either addition(+) or subtraction(-)
// of every integer from the set to the 'total'. The resultant total should be
// equal to the value F.

// Your task is to find out the number of ways, you can make the 'total' equal to
// the value F.

// Input Format:
// -------------
// Line-1: Two integers N and F.
// Line-2: N space separated integers 

// Output Format:
// --------------
// Print an integer, number of ways.


// Sample Input:
// ---------------
// 5 3
// 1 1 1 1 1

// Sample Output:
// ----------------
// 5

// Explanation:
// ------------
// total = -1+1+1+1+1 = 3 -> total=value-F
// total = +1-1+1+1+1 = 3 -> total=value-F
// total = +1+1-1+1+1 = 3 -> total=value-F
// total = +1+1+1-1+1 = 3 -> total=value-F
// total = +1+1+1+1-1 = 3 -> total=value-F

// NOTE: + means addition, - means subtraction



import java.util.*;
class j{
    static int fun(int ind,int t,int[][] dp,int[] a){
        if(ind==0){
            if(t==0 && a[0]==0){
                return 2;
            }
            if(t==0 || a[0]==t){
                return 1;
            }
            return 0;
        }
        if(dp[ind][t]!=0){
            return dp[ind][t];
        }
        int np=fun(ind-1,t,dp,a);
        int p=0;
        if(a[ind]<=t){
            p=fun(ind-1,t-a[ind],dp,a);
        }
        return dp[ind][t]=p+np;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int[][] dp=new int[n+1][t+1];
        int tot=0;
        for(int i:a){
            tot+=i;
        }
        if(tot-t<0 || (tot-t)%2!=0){
            System.out.println(false);
            System.exit(0);
        }
        System.out.println(fun(n-1,(tot-t)/2,dp,a));
    }
}



// cpp solution
// #include<bits/stdc++.h>
// using namespace std;
// int c=0;
// void solve(vector<int> &nums,int ind,int target,int &sum){
//     if(ind==nums.size()){
//         if(sum==target){
//             c++;
//         }
//         return;
//     }
//     sum=sum+nums[ind];
//     solve(nums,ind+1,target,sum);
//     sum=sum-nums[ind];
    
//     sum=sum-nums[ind];
//     solve(nums,ind+1,target,sum);
//     sum=sum+nums[ind];
// }
// int main(){
//     int n,target;
//     cin>>n>>target;
//     vector<int> nums(n,0);
//     for(int i=0;i<n;i++){
//         cin>>nums[i];
//     }
//     int sum=0;
//     solve(nums,0,target,sum);
//     cout<<c;
// }
