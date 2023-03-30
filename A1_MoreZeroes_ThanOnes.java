// You are given a binary array nums containing only the integers 0 and 1. Return the number of subarrays in nums that have more 1's than 0's. Since the answer may be very large, return it modulo 109 + 7.

// A subarray is a contiguous sequence of elements within an array.

//  Example 1:

// Input: nums = [0,1,1,0,1]
// Output: 9
// Explanation:
// The subarrays of size 1 that have more ones than zeros are: [1], [1], [1]
// The subarrays of size 2 that have more ones than zeros are: [1,1]
// The subarrays of size 3 that have more ones than zeros are: [0,1,1], [1,1,0], [1,0,1]
// The subarrays of size 4 that have more ones than zeros are: [1,1,0,1]
// The subarrays of size 5 that have more ones than zeros are: [0,1,1,0,1]
// Example 2:

// Input: nums = [0]
// Output: 0
// Explanation:
// No subarrays have more ones than zeros.
// Example 3:

// Input: nums = [1]
// Output: 1
// Explanation:
// The subarrays of size 1 that have more ones than zeros are: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 1


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int l=i,r=i,o=0,z=0;
            while(l>=0 && r<n){
                if(l==r){
                    if(a[l]==0){
                        z++;
                    }
                    else{
                        o++;
                    }
                }
                else{
                    if(a[l]==0){
                        z++;
                    }
                    if(a[l]==1){
                        o++;
                    }
                    if(a[r]==0){
                        z++;
                    }
                    if(a[r]==1){
                        o++;
                    }
                }
                if(o>z){
                    ans++;
                }
                l--;
                r++;
            }
            l=i;
            r=i+1;
            o=0;
            z=0;
            while(l>=0 && r<n){
                if(l==r){
                    if(a[l]==0){
                        z++;
                    }
                    else{
                        o++;
                    }
                }
                else{
                    if(a[l]==0){
                        z++;
                    }
                    if(a[l]==1){
                        o++;
                    }
                    if(a[r]==0){
                        z++;
                    }
                    if(a[r]==1){
                        o++;
                    }
                }
                if(o>z){
                    ans++;
                }
                l--;
                r++;
            }
            
        }
        System.out.println(ans);
    }
}
