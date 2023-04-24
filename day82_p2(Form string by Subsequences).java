// Kiran is playing with strings and its subsequences.
// A subsequence can be formed from a string by deleting some characters
// (may be string itself)

// Kiran has given two strings S and T, your task to form T by concatenating 
// the subsequences of S  

// Return the minimum number of subsequences required to form T.
// If the task is impossible, return -1 .


// Input Format:
// -------------
// Line-1 -> Two strings S and T

// Output Format:
// --------------
// Print an integer as result.


// Sample Input-1:
// ---------------
// abc abcbc

// Sample Output-1:
// ----------------
// 2

// Explanation: 
// ------------
// T = "abcbc" can be formed by "abc" and "bc",
// which are subsequences of S = "abc".


// Sample Input-2:
// ---------------
// abc acdbc

// Sample Output-2:
// ----------------
// -1

// Explanation: 
// ------------
// string T cannot be constructed from the
// subsequences of string S due to the character "d" in string T.

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        String s=str[0],t=str[1];
        int ans=0,i=0;
        while(i<t.length()){
            boolean flag=false;
            for(int j=0;j<s.length();j++){
                if(i<t.length() && s.charAt(j)==t.charAt(i)){
                    i++;
                    flag=true;
                }
            }
            if(flag==false){
                System.out.println(-1);
                System.exit(0);
            }
            ans++;
        }
        System.out.println(ans);
    }
}
