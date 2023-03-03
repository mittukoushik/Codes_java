// KCR Chief Minister of Telangana Government has passed a new G.O to Telangana 
// police for safety of Telangana people. In this regard he announced new Vehicles 
// to be released for all the stations working for this mission especially.

// Here we have a 2D mesh, there are P police officers and V vehicles, with P<=V.
// Each police officer and vehicle is a 2D coordinate on this mesh.
// Here the government has assigned a unique vehicle to each police officer.

// Now create a method which prints the minimum possible sum of distances between 
// each police officer and their assigned vehicle.

// Here the distance is between police officer Pi and vehicle Vi assigned to him.
// And distance between Pi, Vi is calculated as follows: |Pi.x - Vi.x| + |Pi.y - Vi.y|


// Input Format:
// -------------
// Line-1: Two integers P and V, number of police officers and vehicles.
// Next P lines: Two space separated integers co-ordinates of Police officers.
// Next V lines: Two space separated integers co-ordinates of Vehicles.

// Output Format:
// --------------
// Print an integer, the minimum possible sum of distances.


// Sample Input-1:
// ---------------
// 3 3
// 0 1		// co-ordinates of police
// 1 2
// 1 3
// 4 5		// co-ordinates of vehicles
// 2 5
// 3 6

// Sample Output-1:
// ----------------
// 17


// Sample Input-2:
// ---------------
// 2 2
// 0 0		// co-ordinates of police
// 2 1
// 1 2		// co-ordinates of vehicles
// 3 3

// Sample Output-2:
// ----------------
// 6


import java.util.*;
class j{
    static int res=Integer.MAX_VALUE;
    static int  distance(int[] a,int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
    static void fun(List<int[]> pol,List<int[]> v,boolean[] vis,int p,int sum){
        if(p==pol.size()){
            res=Math.min(res,sum);
            return;
        }
        for(int i=0;i<v.size();i++){
            if(vis[i]==false){
                vis[i]=true;
                fun(pol,v,vis,p+1,sum+distance(pol.get(p),v.get(i)));
                vis[i]=false;
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<int[]> p=new ArrayList<>();
        List<int[]> v=new ArrayList<>();
        for(int i=0;i<n;i++){
            int[] a=new int[2];
            a[0]=sc.nextInt();
            a[1]=sc.nextInt();
            p.add(a);
        }
        for(int i=0;i<m;i++){
            int[] a=new int[2];
            a[0]=sc.nextInt();
            a[1]=sc.nextInt();
            v.add(a);
        }
        boolean[] vis=new boolean[m];
        fun(p,v,vis,0,0);
        System.out.println(res);
    }
}
