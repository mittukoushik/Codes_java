// /*
// You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.

// Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.

// You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips.

// input = 3
// 1 2 3
// 5
// ouput = 3
 

// Example 1:

// Input: time = [1,2,3], totalTrips = 5
// Output: 3
// Explanation:
// - At time t = 1, the number of trips completed by each bus are [1,0,0]. 
//   The total number of trips completed is 1 + 0 + 0 = 1.
// - At time t = 2, the number of trips completed by each bus are [2,1,0]. 
//   The total number of trips completed is 2 + 1 + 0 = 3.
// - At time t = 3, the number of trips completed by each bus are [3,1,1]. 
//   The total number of trips completed is 3 + 1 + 1 = 5.
// So the minimum time needed for all buses to complete at least 5 trips is 3.
// Example 2:

// Input: time = [2], totalTrips = 1
// Output: 2
// Explanation:
// There is only one bus, and it will complete its first trip at t = 2.
// So the minimum time needed to complete 1 trip is 2.
 

// Constraints:

// 1 <= time.length <= 105
// 1 <= time[i], totalTrips <= 107

import java.util.*;
class j{
    static boolean valid(int m,int trips,int[] a){
        int ans=0;
        for(int i:a){
            ans+=m/i;
        }
        return ans>=trips;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int trips=sc.nextInt();
        int max=Arrays.stream(a).max().getAsInt();
        int l=1,r=trips*max;
        while(l<=r){
            int m=l+(r-l)/2;
            if(valid(m,trips,a)){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        System.out.println(l);
    }
}
