// The integer array arr[] is given and print the resultant value of the bitwise OR
// of the sum of all the possible sub-arrays of the given array arr[].

// Note: A sub-array is a sequence of array-elements that could be drawn from other
//       sequence of array-elements by removing zero or more elements without changing 
//       the order of the remaining elements.



// Input Format
// -------------
// Line-1: Read the size of array P.
// Line-2: Read the array elements(space separated values).

// Output Format
// --------------
// Print the resultant value.


// Sample input-1:
// ---------------
// 4
// 0 2 1 3
// Sample output-1:
// ----------------
// 7

// Explanation
// The sums of sub-arrays are
// 0 1 2 3 4 5 6. 
// and bitwise OR operation
// 0 OR 1 OR 2 OR 3 OR 4 OR 5 OR 6 = 7.



// Sample input-2:
// ---------------
// 4
// 0 0 0 0
// Sample output-2:
// ----------------
// 0

// Explanation
// Only one sum sub-arrays i.e. 0.

import java.util.*;
class j{
    static void fun(int ind,int n,int[] a,Set<Integer> l,int sum){
        if(ind==a.length){
            l.add(sum);
            return;
        }
        sum=sum+a[ind];
        fun(ind+1,n,a,l,sum);
        sum=sum-a[ind];
        fun(ind+1,n,a,l,sum);
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Set<Integer> l=new HashSet<>();
        fun(0,n,a,l,0);
        // System.out.println(l);
        int ans=0;
        for(int i:l){
            ans=ans|i;
        }
        System.out.println(ans);
    }
}
