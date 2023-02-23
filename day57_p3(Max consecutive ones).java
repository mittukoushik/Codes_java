// Given a binary array nums and an integer k, return the maximum number 
// of consecutive 1's in the array if you can flip at most k 0's.

// In a class students are given series of zeroes and ones and an integer 'k'. They have to return
// maximum number of consecutive ones in the series if they can flip at most 'k' zeroes


// Input Format
// ------------
// Line1: An integer represents number of zeroes and ones
// Line2: space separated integers which are zeroes and ones
// Line3: An integer represents no of zeroes which can be flipped

// Output Format
// -------------
// An integer represents maximum number of consecutive ones


// Example 1:
// ----------
// Input1: 11
//         1 1 1 0 0 0 1 1 1 1 0
//         2
// Output1: 6

// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


// Example 2:
// ----------
// Input2: 19
//         0 0 1 1 0 0 1 1 1 0 1 1 0 0 0 1 1 1 1
//         3
// Output2: 10

// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int i=0,j=0,cnt=0;
        int ans=Integer.MIN_VALUE;
        while(j<n){
            if(a[j]==0){
                cnt++;
            }
            while(cnt>k){
                if(a[i]==0){
                    cnt--;
                }
                i++;
            }
            j++;
            ans=Math.max(ans,j-i);
        }
        System.out.println(ans);
    }
}
