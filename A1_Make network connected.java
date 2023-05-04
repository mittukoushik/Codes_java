/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi]
 represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
input = number of nodes n 
number of edges m
m number of edges 
output = integer 

sample cases:
input =
4
3
0 1
0 2
1 2
output = 1
case 2:
input = 6
5
0 1
0 2
0 3
1 2
1 3
output = 2
 */
import java.util.*;
class j{
    static void dfs(int i,List<List<Integer>> adj,boolean[] vis){
        vis[i]=true;
        for(int j:adj.get(i)){
            if(vis[j]==false){
                dfs(j,adj,vis);
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        if(m<n-1){
            System.out.println(-1);
            System.exit(0);
        }
        List<List<Integer>> adj=new ArrayList<>();
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(i,adj,vis);
                c++;
            }
        }
        System.out.println(c-1);
    }
}
