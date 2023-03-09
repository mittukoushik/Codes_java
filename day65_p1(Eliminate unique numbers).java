// There are some Special Numbers between 0 to 10^N.
// A number is called special, if all the digits in that number should be different.
// i.e., No two digits are same in that number.

// You are given an integer N,
// Your task is to find the count of special numbers (X) between 0<= X < 10^N.

// NOTE: Leading 0's are allowed.

// Input Format:
// -------------
// An integer N

// Output Format:
// --------------
// Print an integer, Count of special numbers.

// Sample Input-1:
// ---------------
// 1

// Sample Output-1:
// ----------------
// 10


// Sample Input-1:
// ---------------
// 2

// Sample Output-1:
// ----------------
// 91

// Explanation:
// --------------
// Special Number between 0<= X < 10^2.
// Exclude 11, 22, 33, 44, 55, 66, 77, 88, 99, => count is 9
// Total Count is 100=> Special Numbers count is 100-9 = 91.


import java.util.*;
class j{
    static int c=0;
    static void fun(int n,StringBuilder sb,String s){
        if(sb.length()==n){
            return;
        }
        for(int i=0;i<s.length();i++){
            if(sb.length()==0 || (sb.indexOf(String.valueOf(s.charAt(i)))==-1 && sb.charAt(0)!='0')){
                sb.append(s.charAt(i));
                c++;
                fun(n,sb,s);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        c=0;
        StringBuilder sb=new StringBuilder();
        fun(n,sb,"0123456789");
        System.out.println(c);
    }
}
