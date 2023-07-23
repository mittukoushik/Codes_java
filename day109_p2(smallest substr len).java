// Mr Shravan is given a word W, and W cosists of lowercase alphabets only. 
// Mr Shravan is interested to find the substring which is smallest in length 
// the which occurs only one in the word W.

// Your task is to help Mr Sharavan to return the length of the smallest 
// substring of W according to the above statement.

// Input Format:
// -------------
// A String W, consists of lowercase letters.

// Output Format:
// --------------
// An integer result.


// Sample Input-1:
// ---------------
// abbaabab

// Sample Output-1:
// ----------------
// 2


// Sample Input-2:
// ---------------
// rererer

// Sample Output-2:
// ----------------
// 5

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Map<String,Integer> m=new HashMap<>();
        for(int i=0;i<s.length();i++){
            int l=i,r=i;
            String x="";
            while(l>=0 && r<s.length()){
                x=s.substring(l,r+1);
                m.put(x,m.getOrDefault(x,0)+1);
                l--;r++;
            }
            l=i;r=i+1;
            x="";
            while(l>=0 && r<s.length()){
                x=s.substring(l,r+1);
                m.put(x,m.getOrDefault(x,0)+1);
                l--;r++;
            }
            
        }
        int ans=s.length();
        for(String a:m.keySet()){
            if(m.get(a)==1){
                if(ans>a.length()){
                    ans=a.length();
                }
            }
        }
        System.out.println(ans);
    }
}
