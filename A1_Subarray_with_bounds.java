// You are given an integer array nums and two integers minK and maxK.

// A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

// The minimum value in the subarray is equal to minK.
// The maximum value in the subarray is equal to maxK.
// Return the number of fixed-bound subarrays.

// A subarray is a contiguous part of an array.
//  input = 4
//   1 1 1 1 
//   1
//   1
//   output = 10


// Example 1:

// Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
// Output: 2
// Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
// Example 2:

// Input: nums = [1,1,1,1], minK = 1, maxK = 1
// Output: 10
// Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 
// Constraints:
// 2 <= nums.length <= 10^5
// 1 <= nums[i], minK, maxK <= 10^6

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int mink=sc.nextInt();
        int maxk=sc.nextInt();
        int res=0,min=-1,max=-1,j=-1;
        for(int i=0;i<n;i++){
            if(a[i]<mink || a[i]>maxk){
                j=i;
            }
            if(a[i]==mink){
                min=i;
            }
            if(a[i]==maxk){
                max=i;
            }
            res+=Math.max(0,Math.min(min,max)-j);
            // System.out.println(res);
        }
        System.out.println(res);
    }
}
