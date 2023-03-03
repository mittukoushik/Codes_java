// Given an array of integer elements, ele[], YOur task is to find and print 
// the number of the subarrays, which gives you an even value after multiplication
// of the elements in it.

// Input Format:
// -------------
// Line-1: An integer N, number of elements.
// Line-2: Space separated elements.

// Output Format:
// --------------
// Print number of possible subarrays.


// Sample Input-1:
// ---------------
// 4
// 5 8 9 17

// Sample Output-1:
// ----------------
// 6

// Explanation:
// ------------
// 5 x 8 = 40
// 5 x 8 x 9 = 360
// 5 x 8 x 9 x 17 = 6120
// 8 = 8
// 8 x 9 = 72
// 8 x 9 x 17 = 1224
// Hence we got 6 even subarray multiplications.



// Sample Input-2:
// ---------------
// 3
// 5 7 11

// Sample Output-2:
// ----------------
// 0

// Explanation:
// ------------
// No subarrays which will give you even value after multiplication.


import java.util.*;
class j{
    static int c=0;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int l=i,r=i,pro=1;
            while(l>=0 && r<n){
                pro*=a[l]*a[r];
                if(pro%2==0){
                    c++;
                }
                l--;
                r++;
            }
            l=i;
            r=i+1;
            pro=1;
            while(l>=0 && r<n){
                pro*=a[l]*a[r];
                if(pro%2==0){
                    c++;
                }
                l--;
                r++;
            }
        }
        System.out.println(c);
    }
}

// Alternate method

static int getAns(int ar[]){
        int n = ar.length;
        int res = (n*(n+1))/2;
        int c=0;
        for(int i=0;i<n;i++){
            if(ar[i]%2!=0){
                c++;
            }
            else{
                res=res-(c*(c+1))/2;
                c=0;
            }
        }
        res=res-(c*(c+1))/2;
        return res;
    }
