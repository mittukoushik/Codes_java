// There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

// A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

// Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
// Constraints:

// n == graph.length
// 1 <= n <= 104
// 0 <= graph[i].length <= n
// 0 <= graph[i][j] <= n - 1
// graph[i] is sorted in a strictly increasing order.
// The graph may contain self-loops.
// The number of edges in the graph will be in the range [1, 4 * 104].

// input=7
// 7
// 0 1
// 0 2
// 1 2
// 1 3
// 2 5
// 3 0
// 4 5
// output=[2, 4, 5, 6]



import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int op=sc.nextInt();
        Map<Integer,List<Integer>> m=new HashMap<>();
        Map<Integer,List<Integer>> rm=new HashMap<>();
        for(int i=0;i<n;i++){
            m.put(i,new ArrayList<>());
            rm.put(i,new ArrayList<>());
        }
        for(int i=0;i<op;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            m.get(x).add(y);
        }
        for(int i=0;i<n;i++){
            for(int x:m.get(i)){
                rm.get(x).add(i);
            }
        }
        // System.out.println(m);
        // System.out.println(rm);
        int[] indg=new int[n];
        for(int i=0;i<n;i++){
            for(int x:rm.get(i)){
                indg[x]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indg[i]==0){
                q.add(i);
            }
        }
        List<Integer> l=new ArrayList<>();
        while(!q.isEmpty()){
            int front=q.poll();
            l.add(front);
            for(int i:rm.get(front)){
                indg[i]--;
                if(indg[i]==0){
                    q.add(i);
                }
            }
        }
        Collections.sort(l);
        System.out.println(l);
    }
}
