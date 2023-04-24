// /*
// There are N cities, and M routes[], each route is a path between two cities.
// routes[i] = [city1, city2], there is a travel route between city1 and city2.
// Each city is numbered from 0 to N-1.
 
// There are one or more Regions formed among N cities. 
// A Region is formed in such way that you can travel between any two cities 
// in the region that are connected directly and indirectly.
 
// Your task is to findout the number of regions formed between N cities. 
 
// Input Format:
// -------------
// Line-1: Two space separated integers N and M, number of cities and routes
// Next M lines: Two space separated integers city1, city2.
 
// Output Format:
// --------------
// Print an integer, number of regions formed.
 
 
// Sample Input-1:
// ---------------
// 5 4
// 0 1
// 0 2
// 1 2
// 3 4
 
// Sample Output-1:
// ----------------
// 2
 
 
// Sample Input-2:
// ---------------
// 5 6
// 0 1
// 0 2
// 2 3
// 1 2
// 1 4
// 2 4
 
// Sample Output-2:
// ----------------
// 1


import java.util.*;
class j{
    static int find(int i,int[] par){
        if(i==par[i]){
            return i;
        }
        return par[i]=find(par[i],par);
    }
    static void union(int i,int j,int[] par){
        int l=find(i,par);
        int r=find(j,par);
        par[l]=r;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] a=new int[m][2];
        for(int i=0;i<m;i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        int[] par=new int[n+1];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        for(int i[]:a){
            union(i[0],i[1],par);
        }
        int ans=0;
        for(int i=0;i<par.length;i++){
            if(i==par[i]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
