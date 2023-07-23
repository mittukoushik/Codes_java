// In a garden, there is a row of plants. The gardener need to water them regularly.
// In the row of plants, some are empty places some are plants. you need to setup 
// the watering kits to water the row of plants at the empty places. A watering kit
// can supply water to its adjacent plants, i.e., if the watering kit is at 
// i-th position it can water the plants ar 'i+1'-th and 'i-1'-th  positions.

// You are given a string 'plants', consists of two characters only [P,E], where P 
// indiactes plant and E indicates empty place.

// Your task is to return the minimum number of watering kits needed so that 
// for every plant, the gardener can supply the water to all the plants in that 
// row OR -1 if it is impossible.


// Input Format:
// -------------
// A string, consists of only two characters P and E

// Output Format:
// --------------
// Print an integer result, the minimum num of watering kits.


// Sample Input-1:
// ---------------
// PEEEPEP

// Sample Output-1:
// ----------------
// 2

// Explanation: 
// ------------
// You can setup watering kits at index-1, index-5, so all the 3 plants gets water.


// Sample Input-2:
// ---------------
// PEPEEPP

// Sample Output-2:
// ----------------
// -1

// Explanation: 
// ------------
// No empty place after the last plant in the row, so retrun -1.



import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] c=s.toCharArray();
        int ans=0;
        for(int i=1;i<c.length-1;i++){
            if(c[i]=='E'){
                if(c[i-1]=='P' && c[i+1]=='P'){
                    c[i-1]='#';
                    c[i+1]='#';
                    ans++;
                }
            }
        }
        for(int i=0;i<c.length;i++){
            if(c[i]=='P'){
                if(i==0 && c[i+1]=='E'){
                    ans++;
                }
                else if(i==c.length-1 && c[i-1]=='E'){
                    ans++;
                }
                else if(i>0 && i<c.length-1 &&( c[i-1]=='E' || c[i+1]=='E')){
                    ans++;
                }
                else{
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(ans);
        System.out.println(ans);
    }
}
