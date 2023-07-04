// Given a set of weights of n items weights[], and another item wieght w.
// Your task is to check if the sum of weights of continuous subset is equal to 
// one of the multiple of w, where subset size should be minimum 2.

// For example: Mulitple of w means, w=3 then multiple of w are
// 3, 6, 9, 12, .... so on.

// Print true, if such subset sum is possible.
// Otherwise, print false.

// Input Format:
// -------------
// Line-1 : Two integers n and w, number of weights and weight to match.
// Line-2 : n space separated integers, weights of n items.

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 5 4
// 1 2 3 5 6

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 5 4
// 1 2 3 6 5

// Sample Output-2:
// ----------------
// true

// Explanation: 
// ------------
// sum of  continuous subset of weights [1,2,3,6]  equals to 12, multiple of 4.



import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int l=i,r=i,sum=0;
            while(l>=0 && r<n){
                if(l==r){
                    sum+=a[l];
                }
                else{
                    sum+=a[l]+a[r];
                }
                if(sum%t==0 && r-l+1>1){
                    System.out.println(true);
                    System.exit(0);
                }
                l--;r++;
            }
            l=i;r=i+1;sum=0;
            while(l>=0 && r<n){
                if(l==r){
                    sum+=a[l];
                }
                else{
                    sum+=a[l]+a[r];
                }
                if(sum%t==0&& r-l+1>1){
                    System.out.println(true);
                    System.exit(0);
                }
                l--;r++;
            }
        }
        System.out.println(false);
    }
}

Map<Integer,Integer> m=new HashMap<>();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            sum=sum%t;
            if(m.containsKey(sum)){
                if(i-m.get(sum)>1){
                    System.out.println(true);
                    System.exit(0);
                }
            }
            m.put(sum,i);
        }
        System.out.println(false);
