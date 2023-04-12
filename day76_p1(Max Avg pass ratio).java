//lc-1792
// Yamaha Pvt Ltd has N number of stores in Hyderabad, each showroom has 
// allotted few vehicles. The sales of each showroom are given as an array, 
// sales[], where sales[i]={S, T} indiactes, i-th showroom sold S number of 
// vehicles out of T vehicles allotted to that showroom.

// Yamaha introduced a new vehicle in the market and the sales of that 
// vehicle are at peak(i.e., these vehicles will definitely sold ). Now, 
// Yamaha Pvt Ltd, decided to send P vehicles to Hyderabad. Now, each of 
// the P vehicles have to be alloted to a showroom in a way that increases 
// the avarage sales ratio across all the showrooms. 
// The sales ratio of a showroom is calaculated as the number of vehicles 
// sold divided by the total number of vehicles given to that showroom.

// Your task is to return the maximum possible average sales ratio 
// after P number of new vehicles allotted.

// Input Format:
// -------------
// Line-1: Two space separated integers N and P, no.of showrooms, no.of new vehicles
// Next N lines: Two space separated integers S and T, sold count, allotted count.

// Output Format:
// --------------
// Print a double result (rounded to 5 decimals), 
// Max avg sales ratio of all showrooms.


// Sample Input-1:
// ---------------
// 4 3
// 3 5
// 4 9
// 6 8
// 3 10

// Sample Output-1:
// ----------------
// 0.57008


// Sample Input-2:
// ---------------`
// 6 4
// 4 8
// 3 5
// 7 9
// 2 7
// 3 11
// 4 13

// Sample Output-2:
// ----------------
// 0.50499

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                double a1=(double)(a[0])/(double)(a[1]);
                double a2=(double)(a[0]+1)/(double)(a[1]+1);
                double d1=a2-a1;
                double b1=(double)(b[0])/(double)(b[1]);
                double b2=(double)(b[0]+1)/(double)(b[1]+1);
                double d2=b2-b1;
                if(d1>d2){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });
        for(int[] i:a){
            pq.add(i);
        }
        while(m>0){
            int[] arr=pq.poll();
            arr[0]+=1;
            arr[1]+=1;
            pq.add(arr);
            m--;
        }
        double ans=0;
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            ans+=(double)arr[0]/(double)arr[1];
        }
        System.out.printf("%.5f",ans/n);
    }
}


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] ar=new int[n][2];
        for(int i=0;i<n;i++){
            ar[i][0]=sc.nextInt();
            ar[i][1]=sc.nextInt();
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            double a1=(double)(a[0])/(double)(a[1]);
            double a2=(double)(a[0]+1)/(double)(a[1]+1);
            double d1=a2-a1;
            double b1=(double)(b[0])/(double)(b[1]);
            double b2=(double)(b[0]+1)/(double)(b[1]+1);
            double d2=b2-b1;
            if(d1>d2){
                return -1;
            }
            else{
                return 1;
            }
        });
        for(int[] i:ar){
            pq.add(i);
        }
        while(m>0){
            int[] arr=pq.poll();
            arr[0]+=1;
            arr[1]+=1;
            pq.add(arr);
            m--;
        }
        double ans=0;
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            ans+=(double)arr[0]/(double)arr[1];
        }
        System.out.printf("%.5f",ans/n);
    }
}
