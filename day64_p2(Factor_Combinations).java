// Ms ALEENA is working on numbers; she is fascinated by number factors.
// She is given a number N, she wants to find out all possible ways of 
// obtaining N as multiple of its factors.
// For example given N =12
// can be written as multiple of 2,3 and 4.
// and the ways to obtains 12 from ots factors are: 2*2*3, 2*6, 3*4

// Your task is to help Ms ALEENA to find the all possible ways of obtaining N 
// from its factors and return all the possible ways as shown in the samples.

// Input Format:
// -------------
// An integer N, value of N.

// Output Format:
// --------------
// Print the list of possiblilties.


// Sample Input-1:
// ---------------
// 12

// Sample Output-1:
// ----------------
// [[2, 2, 3], [2, 6], [3, 4]]


// Sample Input-2:
// ---------------
// 16

// Sample Output-2:
// ----------------
// [[2, 2, 2, 2], [2, 2, 4], [2, 8], [4, 4]]


// Sample Input-3:
// ---------------
// 32

// Sample Output-3:
// ----------------
// [[2, 2, 2, 2, 2], [2, 2, 2, 4], [2, 2, 8], [2, 4, 4], [2, 16], [4, 8]]



import java.util.*;
class j{
    static List<List<Integer>> ans=new ArrayList<>();
    static void fun(int st,int num,List<Integer> l){
        if(num==1){
            if(l.size()>1){
                ans.add(new ArrayList<>(l));
            }
            return;
        }
        for(int i=st;i<=num;i++){
            if(num%i==0){
                l.add(i);
                fun(i,num/i,l);
                l.remove(l.size()-1);
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> l=new ArrayList<>();
        fun(2,n,l);
        System.out.println(ans);
    }
}
