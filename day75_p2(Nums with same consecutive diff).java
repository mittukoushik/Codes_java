// // lc-967
// Basanthi interested playing with digits.
// He wants create a set of integers of length N, using the digits[0-9].
// The rules to create the integers are as follows:
// 	- digits in each integer are like d0,d1,d2...dn-1
// 	- and |d0-d1| = |d1-d2| = |d2-d3| ... |dn-2 - dn-1|= D

// Basanthi is given two integers N and D, where N is length of the integer and 
// D is the difference. Can you help Basanthi, to create such list of integers 
// and print all the possible integers in ascending order


// Note:
// -----
// Integers with leading 0's are not allowed


// Input Format:
// -------------
// Two space separated integers N and K.

// Output Format:
// --------------
// Print all the possible integers in ascending order.


// Sample Input-1:
// ---------------
// 3 6

// Sample Output-1:
// ----------------
// [171, 282, 393, 606, 717, 828, 939]


// Sample Input-2:
// ---------------
// 2 3

// Sample Output-2:
// ----------------
// [14, 25, 30, 36, 41, 47, 52, 58, 63, 69, 74, 85, 96]

import java.util.*;
class j{
    static void fun(int num,int n,int k,List<Integer> l){
        if(n==0){
            l.add(num);
            return;
        }
        int last_digit=num%10;
        if(last_digit>=k){
            fun(num*10+last_digit-k,n-1,k,l);
        }
        if(k>0 &&last_digit+k<10){
            fun(num*10+last_digit+k,n-1,k,l);
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<10;i++){
            fun(i,n-1,k,res);
        }
        System.out.println(res);
    }
}


import java.util.*;
class j{
    static void fun(String s,StringBuilder sb,int n,int k,List<Integer> res){
        if(sb.length()==n){
            res.add(Integer.parseInt(sb.toString()));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(sb.length()==0 ||(sb.charAt(0)!='0' &&  Math.abs((sb.charAt(sb.length()-1)-'0')-(s.charAt(i)-'0'))==k)){
                sb.append(s.charAt(i));
                fun(s,sb,n,k,res);
                sb.deleteCharAt(sb.length()-1);
                
            }
                            
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        String s="0123456789";
        List<Integer> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        fun(s,sb,n,k,res);
        System.out.println(res);
    }
}
