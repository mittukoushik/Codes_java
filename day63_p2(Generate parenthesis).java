// Clavius, the person who suggested grouping of data using brackets.
// He has suggested that the group of brackets should be Well-Formed.

// A string is said to be Well-Formed, if:
//     - The string is empty.
//     - The string can be written as MN, (M is appended to N), 
//       where M and N are Well-Formed Strings, or
//     - The string can be written as {M}, where M is Well-Formed string.

// You will be given an integer N. Your task is to return the list of all 
// Well-Formed strings of length 2*N.

// Input Format:
// -------------
// An integer N.

// Output Format:
// --------------
// Print the list of well-formed strings.


// Sample Input-1:
// ---------------
// 3

// Sample Output-1:
// ----------------
// [{{{}}},{{}{}},{{}}{},{}{{}},{}{}{}]


// Sample Input-2:
// ---------------
// 1

// Sample Output-2:
// ----------------
// [{}]


import java.util.*;
class j{
    static List<String> res=new ArrayList<>(); 
    static void fun(int l,int r,String s){
        if(l==0 && r==0){
            res.add(s);
            return;
        }
        if(l>0){
            fun(l-1,r,s+'{');
        }
        if(l<r){
            fun(l,r-1,s+'}');
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        fun(n,n,"");
        System.out.println(res);
    }
}
