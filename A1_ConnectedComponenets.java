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
 
// Note: Look HINT for explanation.

import java.util.*;
class j{
    static List<List<Integer>> adj=new ArrayList<>();
    static void dfs(int i,boolean[] vis){
        vis[i]=true;
        for(int j:adj.get(i)){
            if(vis[j]==false){
                dfs(j,vis);
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        int[][] g=new int[e][2];
        for(int i=0;i<e;i++){
            g[i][0]=sc.nextInt();
            g[i][1]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]:g){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        boolean[] vis=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                ans++;
                dfs(i,vis);
            }
        }
        System.out.println(ans);
    }
}
