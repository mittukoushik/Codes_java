// Given N satellite stations, numbered 1 to N.
// These satellites are connected to send signals from one to other.
// To send a signal from satellite 's' to satellite 'd', it takes 
// an amount of time 't'.

// You are given a list of travel times as directed edges times[i] = (s, d, t).

// Your task to find the time taken to recieve signal from a satellite station K, 
// to all N-1 satellite stations. If it is impossible, return -1 .

// Input Format:
// -------------
// Line-1 ->   Three integers, N number of satellite stations, 
//             K is the satellite to send signal and T is the number of edges.
// Next T lines -> Three space separated integers, 's' is the source, 
//             'd' is the destination, 
// 			't' is the time taken recieve signal from 's' to 'd'.

// Output Format:
// --------------
// Print an integer as your result.


// Sample Input-1:
// ---------------
// 4 2 3
// 2 1 1
// 2 3 1
// 3 4 1

// Sample Output-1:
// ----------------
// 2


// Sample Input-2:
// ---------------
// 5 2 4
// 2 1 1
// 2 3 2
// 3 4 3
// 5 1 4

// Sample Output-2:
// ----------------
// -1


// Sample Input-3:
// ---------------
// 5 2 4
// 2 1 1
// 2 3 2
// 3 4 3
// 1 5 6

// Sample Output-3:
// ----------------
// 7


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int ops=sc.nextInt();
        int[][] times=new int[ops][3];
        for(int i=0;i<ops;i++){
            times[i][0]=sc.nextInt();
            times[i][1]=sc.nextInt();
            times[i][2]=sc.nextInt();
        }
        Map<Integer,Map<Integer,Integer>> m=new HashMap<>();
        for(int i[]:times){
            m.putIfAbsent(i[0],new HashMap<>());
            m.get(i[0]).put(i[1],i[2]);
        }
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{k,0});
        while(!q.isEmpty()){
            int[] t=q.poll();
            int curr=t[0],wt=t[1];
            for(int i:m.getOrDefault(curr,new HashMap<>()).keySet()){
                int nextwt=m.get(curr).get(i);
                if(wt+nextwt<dis[i]){
                    dis[i]=wt+nextwt;
                    q.add(new int[]{i,wt+nextwt});
                }
            }
        }
        int res=0;
        for(int i=1;i<=n;i++){
            if(dis[i]>res){
                res=Math.max(res,dis[i]);
            }
        }
        if(res==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(res);
        }
    }
}
