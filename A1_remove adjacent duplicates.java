/*
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
*/

import java.util.*;
class pair{
    char ch;
    int val;
    pair(char ch,int val){
        this.ch=ch;
        this.val=val;
    }
}
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int k=sc.nextInt();
        Stack<pair> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.isEmpty()){
                st.push(new pair(s.charAt(i),1));
            }
            else{
                pair top=st.peek();
                if(top.ch==s.charAt(i)){
                    top.val++;
                    if(top.val==k){
                        st.pop();
                    }
                }
                else{
                    st.push(new pair(s.charAt(i),1));
                }
            }
        }
        String res="";
        while(!st.isEmpty()){
            pair t=st.pop();
            for(int i=0;i<t.val;i++){
                res=t.ch+res;
            }
        }
        System.out.println(res);
    }
}
