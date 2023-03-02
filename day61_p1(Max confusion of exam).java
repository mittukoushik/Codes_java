// In a game, there are some questions in a row, and each question has two options 
// 'A' or 'B'. The organizer wants to confuse the participants by maximizing the 
// number of consecutive questions with the same option as valid answer. 
// (multiple As or multiple Bs in a row).

// The organizer is given a word 'options' and an integer P, where options[i] is 
// the valid answer to the ith question and P is the maximum number of times 
// you may perform the following operation:
//     - Change the options value for any question to 'A' or 'B' 
//       (i.e., set options[i] to 'A' or 'B').
// Your task is to return the maximum number of consecutive As or Bs in the options,
// after performing the operation at most P times.

// Input Format:
// -------------
// Line-1 -> A word, the options
// Line-2 -> An integer P, P number of operations.


// Output Format:
// --------------
// Print an integer as output.


// Sample Input-1:
// ---------------
// ABBABA
// 2

// Sample Output-1:
// ----------------
// 5

// Explanation:
// ------------
// We can replace any two 'A's at with 'B's. There are five consecutive 'B's.


// Sample Input-2:
// ---------------
// BABBABABAA
// 1

// Sample Output-2:
// ----------------
// 4


// Sample Input-3:
// ---------------
// BABBABABAA
// 2

// Sample Output-3:
// ----------------
// 6


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();
        int ans=0,j=0,cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                cnt++;
            }
            while(cnt>k){
                if(s.charAt(j)=='A'){
                    cnt--;
                }
                j++;
            }
            ans=Math.max(ans,i-j+1);
        }
        cnt=0;j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='B'){
                cnt++;
            }
            while(cnt>k){
                if(s.charAt(j)=='B'){
                    cnt--;
                }
                j++;
            }
            ans=Math.max(ans,i-j+1);
        }
        System.out.println(ans);
    }
}
