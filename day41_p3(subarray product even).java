// Given an array of integer elements, ele[], YOur task is to find and print 
// the number of the subarrays, which gives you an even value after multiplication
// of the elements in it.

// Input Format:
// -------------
// Line-1: An integer N, number of elements.
// Line-2: Space separated elements.

// Output Format:
// --------------
// Print number of possible subarrays.


// Sample Input-1:
// ---------------
// 4
// 5 8 9 17

// Sample Output-1:
// ----------------
// 6

// Explanation:
// ------------
// 5 x 8 = 40
// 5 x 8 x 9 = 360
// 5 x 8 x 9 x 17 = 6120
// 8 = 8
// 8 x 9 = 72
// 8 x 9 x 17 = 1224
// Hence we got 6 even subarray multiplications.



// Sample Input-2:
// ---------------
// 3
// 5 7 11

// Sample Output-2:
// ----------------
// 0

// Explanation:
// ------------
// No subarrays which will give you even value after multiplication.
// import java.util.*;
// class j{
//     static int res=0;
//     static void fun(int start,int end,int[] a,int n){
//         if(end==n){
//             return;
//         }
//         else if(start>end){
//             fun(0,end+1,a,n);
//         }
//         else{
//             int c=1;
//             for(int i=start;i<end;i++){
//                 c=c*a[i];
//             }
//             c=c*a[end];
//             if(c%2==0){
//                 res++;
//             }
//             fun(start+1,end,a,n);
//         }
//     }
//     public static void main (String[] args) {
//         Scanner sc=new Scanner(System.in);
//         // res=0;
//         int n=sc.nextInt();
//         int[] a=new int[n];
//         for(int i=0;i<n;i++){
//             a[i]=sc.nextInt();
//         }
//         fun(0,0,a,n);
//         System.out.println(res);
//     }
// }
#include<bits/stdc++.h>
using namespace std;
vector<vector<int>> res;
int c=0;
void solve(vector<int> &nums,int start,int end){
    if(end==nums.size()){
        return;
    }
    else if(start>end){
        solve(nums,0,end+1);
    }
    else{
        int res=1;
        for(int i=start;i<end;i++){
            res*=(nums[i]);
        }
        res*=nums[end];
        if(res%2==0){
            c++;
        }
        solve(nums,start+1,end);
    }
}
int main(){
    int n;
    cin>>n;
    vector<int> nums(n,0);
    for(int i=0;i<n;i++){
        cin>>nums[i];
    }
    solve(nums,0,0);
    cout<<c;
}
