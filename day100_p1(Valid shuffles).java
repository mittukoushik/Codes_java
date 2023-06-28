// Ganesh is working on numbers, He is given a list of integers 1,2,3,...,N 
// the list is indexed from 1 to N.

// Now he can shuffle the list in whatever way he want.
// Shuffled list is said to be valid, if one of the following is true for 
// i-th position in the list.
// 	- The integer at the i-th position is divisible by i.
// 	- 'i' is divisible by the integer at the i-th position.

// Now your task is to find out, How many valid shuffles can Ganesh do?

// Input Format:
// -------------
// An integer N, where N<=20.

// Output Format:
// --------------
// Print an integer, number of ways ganesh can shuffle.


// Sample Input-1:
// ------------------
// 1

// Sample Output-1:
// --------------------
// 1

// Explanation:
// ---------------
// The list contains only value 1, so the valid shuffles are 1 only.


// Sample Input:
// ---------------
// 2

// Sample Output:
// ----------------
// 2

// Explanation:
// ------------
// The first shuffled list is [1, 2]:
// Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
// Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

// The second shuffled list is [2, 1]:
// Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
// Integer at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.


// Sample Input-3:
// ---------------
// 3

// Sample Output-3:
// ----------------
// 3

// Explanation:
// ------------
// The valid shuffled lists are: [1,2,3], [3,2,1],[2,1,3]


// Sample Input-4:
// ---------------
// 4

// Sample Output-4:
// ----------------
// 8

// Explanation:
// ------------
// The valid shuffled lists are: [1,2,3,4], [3,2,1,4],[2,1,3,4],[4,2,3,1],[1,4,3,2],[3,4,1,2],[2,4,3,1],[4,1,3,2]



import java.util.*;
class j{
    static int count=0;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=i+1;
        }
        count=0;
        fun(a,0);
        System.out.println(count);
    }
    static void fun(int[] a,int ind){
        if(ind==a.length){
            count++;
            return;
        }
        for(int i=ind;i<a.length;i++){
            swap(a,i,ind);
            if(a[ind]%(ind+1)==0 || (ind+1)%a[ind]==0){
                fun(a,ind+1);
            }
            swap(a,i,ind);
        }
    }
    static void swap(int []a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
