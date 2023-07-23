// A new online video game has been released, and in this video game, there are 
// 15-minute rounds scheduled every quarter-hour period. This means that at HH:00,
// HH:15, HH:30 and HH:45, a new round starts, where HH represents an integer 
// number from 00 to 23. A 24-hour clock is used, so the earliest time in the day 
// is 00:00 and the latest is 23:59.

// Given two strings startTime and finishTime in the format "HH:MM" representing 
// the exact time you started and finished playing the game, respectively, 
// calculate the number of full rounds that you played during your game session.

// For example, if startTime = "05:20" and finishTime = "05:59" this means you 
// played only one full round from 05:30 to 05:45. You did not play the full round 
// from 05:15 to 05:30 because you started after the round began, and you did not 
// play the full round from 05:45 to 06:00 because you stopped before the round 
// ended. If finishTime is earlier than startTime, this means you have played 
// overnight (from startTime to the midnight and from midnight to finishTime).

// Return the number of full rounds that you have played if you had started 
// playing at startTime and finished at finishTime.


// Input Format:
// -------------
// Two space separated strings, startTime and finishTime.

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 12:01 12:44

// Sample Output-1:
// ----------------
// 1

// Explanation: 
// ------------
// You can play 1 game round from 12:15 to 12:30 from 12:01 to 12:44


// Sample Input-2:
// ---------------
// 20:00 06:00

// Sample Output-2:
// ----------------
// 40

// Explanation:
// ------------
// You can play 16 game rounds from 20:00 to 00:00 and 24 game rounds from 00:00 to 06:00. 


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        int h1=Integer.parseInt(a.substring(0,2));
        int m1=Integer.parseInt(a.substring(3,5));
        int h2=Integer.parseInt(b.substring(0,2));
        int m2=Integer.parseInt(b.substring(3,5));
        int x=h1*60+m1;
        int y=h2*60+m2;
        if(x%15!=0){
            x=x-x%15+15;
        }
        if(y%15!=0){
            y=y-y%15;
        }
        if(x>y){
            y+=1440;
        }
        System.out.println((y-x)/15);
    }
}
