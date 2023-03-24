// Given an array of distinct integers candidates and a target integer target, return a list 
// of all unique combinations of candidates where the chosen numbers sum to target. You may 
// return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two 
// combinations are unique if the 
// frequency
//  of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to 
// target is less than 150 combinations for the given input.

 

// Example 1:

// Input: 4
// 2 3 6 7
//  7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
// Example 2:
// Input: 3
// 2 3 5 
// 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
// Example 3:
// Input: 1
// 2
// 1
// Output: []

import java.util.*;
class j{
    static void fun(int ind,int[] a,int n,int t,List<Integer> l,List<List<Integer>> res){
        if(ind>n || t<0){
            return;
        }
        if(ind==n){
            if(t==0){
                res.add(new ArrayList<>(l));
            }
            return;
        }
        if(a[ind]<=t){
            l.add(a[ind]);
            fun(ind,a,n,t-a[ind],l,res);
            l.remove(l.size()-1);
        }
        fun(ind+1,a,n,t,l,res);
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int t=sc.nextInt();
        List<List<Integer>> res=new ArrayList<>();
        fun(0,a,n,t,new ArrayList<>(),res);
        System.out.println(res);
    }
}
