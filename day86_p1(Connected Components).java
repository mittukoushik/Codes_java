// There are P people in a Village, some of the people are relatives, others are not. 
// Their relationship is transitive in nature. 

// For example, 
// if A is a direct relative of B, and B is a direct relative of C, then A is an 
// indirect relative of C. And we define a Relation Chain is a group of people 
// who are direct or indirect relatives.

// Given a P*P matrix R representing the relationship between people in the village. 
// If R[i][j] = 1, then the i and j persons are direct relatives with each other, 
// otherwise not. 

// Your task is to findout the total number of Relation Chains among all the people.

// Input Format:
// -------------
// Line-1 : An integer P, number of people
// Next P lines : P space separated integers.

// Output Format:
// --------------
// Print an integer, the total number of Relation Chains


// Sample Input-1:
// ---------------
// 3
// 1 1 0
// 1 1 0
// 0 0 1

// Sample Output-1:
// ----------------
// 2

// Explanation:
// ------------
// The 0-th and 1-st people are direct relatives, so they are in a relation chain.
// The 2-nd person himself is in a relation chain. So return 2.


// Sample Input-2:
// ---------------
// 3
// 1 1 0
// 1 1 1
// 0 1 1

// Sample Output-2:
// ----------------
// 1

// Explanation:
// ------------
// The 0-th and 1-st people are direct relatives, 1-st and 2-nd people are direct relatives.
// So, the 0-th and 2-nd people are indirect relatives.
// All of them in the same relative chain. So return 1.


import java.util.*;
class j{
    static void dfs(int i,List<List<Integer>> l,int[] vis){
        vis[i]=1;
        for(int j:l.get(i)){
            if(vis[j]==0){
                dfs(j,l,vis);
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] g=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                g[i][j]=sc.nextInt();
            }
        }
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        int ans=0;
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                ans++;
                dfs(i,adj,vis);
            }
        }
        System.out.println(ans);
    }
}
