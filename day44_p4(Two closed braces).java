// Clavius, the person who suggested grouping of data using brackets.
// He has suggested that the group of brackets should be Well-Formed.

// A string is said to be Well-Formed, if:
//     - Any open bracket must have corresponding two consecutive close brackets.
//     - Open bracket must appear before the corresponding close brackets.

// You will be given a string B, consists of square brackets only '[' , ']'.
// In one operation, you can insert one square bracket at any position of B.
// i.e., Given B = [[]]], in one operation you can add a open square bracket,
// now B can be Well-Formed string, if you add at index 2,3,4 or 5 => [[]]]]

// Your task is to return the least number of operations required,
// to make B as a Well-Formed string.

// Input Format:
// -------------
// A string, B contains only characters '[', ']'

// Output Format:
// --------------
// Print an integer value.


// Sample Input-1:
// ---------------
// []]][

// Sample Output-1:
// ----------------
// 4


// Sample Input-2:
// ---------------
// []][[]]

// Sample Output-2:
// ----------------
// 2
import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int ans=0,cnt=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='['){
                cnt++;
            }
            else{
                if((i+1)==s.length() || s.charAt(i+1)=='['){
                    // i++;
                    if(cnt>0){
                        cnt--;
                        ans++;
                    }
                    else{
                        ans=ans+2;
                    }
                }
                else{
                    i++;
                    if(cnt>0){
                        cnt--;
                        // ans++;
                    }
                    else{
                        ans++;
                    }
                }
            }
        }
        ans=ans+2*cnt;
        System.out.println(ans);
    }
}

class Solution {
    public int minInsertions(String s) {
        int countBraces = 0;
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                countBraces += 1;
            }
            else{
                //Case 1-> Whenever a closing bracket is encountered, one case can be it is followed by another closing bracket and preceeded/not preceeded by an opening bracket(handled in this following if block)
                if(i+1<s.length() && s.charAt(i+1) == ')'){
                    if(countBraces > 0){
                        countBraces--; // It's balanced only.. Just decrement the opening bracket
                    }
                    else{
                        //This is the case for --> "))" It means we need to add 1 opening bracket --> "("
                        ans += 1;
                    }
                    i++;
                }
                else{
                    //Case 2 -> Whenever a closing bracket is encountered, another case can be it is not followed by another closing bracket and preceeded/not preceeded by an opening bracket(handled in this following if block)
                    if(countBraces > 0){
                        countBraces--;
                        ans += 1;//Add the last closing bracket to balance
                    }
                    else{
                        
                        ans += 2;//Add the last closing bracket and first opening bracket(eg.test case-> ")")
                    }
                }
                //Finally we should return the 2times the number of countBraces(opening brackets remaining in excess)
            }
        }
        return ans+countBraces*2;
    }
}
