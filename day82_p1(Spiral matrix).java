// You will be given the matrix of size R*C,

// You have to return the matrix in special order as shown in the sample tescases.
 

// Input Format:
// -------------
// Line-1 -> Two integers R and C, size of matrix.
// Next R-Lines -> C space separated integers

// Output Format:
// --------------
// Print R-Lines -> C space separated integers, in special order.


// Sample Input-1:
// ---------------
// 3 3
// 1 2 3
// 4 5 6
// 7 8 9

// Sample Output-1:
// ----------------
// 1 2 3
// 6 9 8
// 7 4 5


// Sample Input-2:
// ---------------
// 3 4
// 1 2 3 4
// 5 6 7 8
// 9 10 11 12

// Sample Output-2:
// ----------------
// 1 2 3 4
// 8 12 11 10
// 9 5 6 7


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int[][] res=new int[n][m];
        List<Integer> l=new ArrayList<>();
        int minr=0,minc=0,maxr=n-1,maxc=m-1;
        int co=1,cn=n*m;
        while(co<=cn){
            for(int i=minr,j=minc;j<=maxc;j++){
                l.add(a[i][j]);
                co++;
            }
            minr++;
            for(int i=minr,j=maxc;i<=maxr;i++){
                l.add(a[i][j]);
                co++;
            }
            maxc--;
            for(int i=maxr,j=maxc;j>=minc;j--){
                l.add(a[i][j]);
                co++;
            }
            maxr--;
            for(int i=maxr,j=minc;i>=minr;i--){
                l.add(a[i][j]);
                co++;
            }
            minc++;
        }
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(l.get(k++)+" ");
            }
            System.out.println();
        }
    }
}
