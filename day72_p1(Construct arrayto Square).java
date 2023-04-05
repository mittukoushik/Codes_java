// Bablu is working in a construction field.
// He has N number of building blocks, where the height and width of all the blocks are same.
// And the length of each block is given in an array, blocks[].

// Bablu is planned to build a wall in the form of a square.
// The rules to cunstruct the wall are as follows:
// 	- He should use all the building blocks.
// 	- He should not break any building block, but you can attach them with other.
// 	- Each building-block must be used only once.
	
// Your task is to check whether Bablu can cunstruct the wall as a square
// with the given rules or not. If possible, print true. Otherwise, print false.

// Input Format:
// -------------
// Line-1: An integer N, number of BuildingBlocks.
// Line-2: N space separated integers, length of each block.

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 6
// 1 2 6 4 5 6

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 6
// 5 3 2 5 5 6

// Sample Output-2:
// ----------------
// false


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int tot=0;
        for(int i:a){
            tot+=i;
        }
        if(tot%4!=0){
            System.out.println(false);
            System.exit(0);
        }
        Arrays.sort(a);
        System.out.println(fun(a,n-1,tot/4,0,0,0,0));
    }
    static boolean fun(int[] a,int ind,int tar,int l,int r,int u,int d){
        if(l==tar && r==tar && u==tar && d==tar){
            return true;
        }
        if(l>tar || r>tar || u>tar || d>tar){
            return false;
        }
        int val=a[ind];
        if(fun(a,ind-1,tar,l+val,r,u,d)){
            return true;
        }
        if(fun(a,ind-1,tar,l,r+val,u,d)){
            return true;
        }
        if(fun(a,ind-1,tar,l,r,u+val,d)){
            return true;
        }
        if(fun(a,ind-1,tar,l,r,u,d+val)){
            return true;
        }
        return false;
        
    }
}
