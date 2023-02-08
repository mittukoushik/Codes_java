// To get the admission into 6th standard in a reputed school in Hyderabad, 
// conducted an entrance test. one of the questions in the test was

// There was a sequence of characters(String) given, student has to check 
// in given String how many substrings are same as reverse of it (palindromic).

// Input Format:
// -------------
// Read a String.

// Output Format:
// --------------
// Print number of palindromic substrings of given string.



// Sample Input-1
// pqrs
// Sample Output-1
// 4

// Explanation: 
// "p", "q", "r", "s" are palindromic substrings of given string.


// Sample Input-2
// pppp
// Sample Output-2
// 10

// Explanation: 
// "p", "p", "p", "p", "pp", "ppp", "pppp", "pp", "ppp", "pp"  are 
// palindromic substrings of given string. 


import java.util.*;
class j{
    // static boolean ispali(String s){
    //     StringBuilder sb=new StringBuilder(s);
    //     return s.equals(sb.reverse().toString());
    // }
    // public static void main (String[] args) {
    //     Scanner sc=new Scanner(System.in);
    //     String s=sc.nextLine();
    //     int c=0;
    //     for(int i=0;i<s.length();i++){
    //         for(int j=i;j<s.length();j++){
    //             String s1=s.substring(i,j+1);
    //             if(ispali(s1)){
    //                 c++;
    //             }
    //         }
    //     }
    //     System.out.println(c);
    // }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int ans=0,n=s.length();
        for(int i=0;i<n;i++){
            int l=i,r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                ans++;
                r++;
                l--;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                ans++;
                r++;
                l--;
            }
        }
        System.out.println(ans);
    }
}






