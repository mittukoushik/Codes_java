// In Dubai's Burj Khalifa, there is an elevator moves only in upwards direction, 
// the elevator can carry N members.

// The people are waiting for the elevator at different floors, made P requests, 
// request[i] = [ num_people, enter_floor, exit_floor ], each request indicates, 
// number of people to enter into elevator, entering floor number, 
// exiting floor number.

// Initially the elevator is empty.

// Your task is to find and return true, iff it is possible to enter the people
// into elevator and exit from elevator of all the requests made by the people.


// Input Format:
// -------------
// Line-1 -> Two integers P and N, number of requests and number of members 
//           can be carried by elevator.
// Next N Lines -> three space separated integers, num_people, enter_floor, exit_floor.

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 2 5
// 2 1 5
// 3 3 7

// Sample Output-1:
// ----------------
// true



// Sample Input-2:
// ---------------
// 2 4
// 2 1 5
// 3 3 7

// Sample Output-2:
// ----------------
// false



// Sample Input-3:
// ---------------
// 3 11
// 3 2 7
// 3 7 9
// 8 3 9

// Sample Output-3:
// ----------------
// true

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int max=sc.nextInt();
        int[][] a=new int[n][3];
        for(int i=0;i<n;i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
            a[i][2]=sc.nextInt();
        }
        int[] arr=new int[51];
        for(int[] i:a){
            arr[i[1]]+=i[0];
            arr[i[2]]-=i[0];
        }
        for(int i:arr){
            max-=i;
            if(max<0){
                System.out.println(false);
                System.exit(0);
            }
        }
        System.out.println(true);
    }
}
