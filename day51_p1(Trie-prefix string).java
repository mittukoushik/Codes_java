// In an english training institute, the trainer Reeta given a task to the trainees.
// We know that, in english we have prefixes and suffixes for the words.
// You can divide a word as concatenation of prefix and suffix.
// i.e., word = prefix + suffix, another = an + other

// You will be given a list of prefixes and a statement consisting of words.
// Now, the task given to the trainees is as follows:
// 	- Replace all the words in the statement with the prefix, 
// 	  if you found prefix of that word in the list.
// 	- If you found more than one prefix in the list for a word in the statement,
// 	  replace the word with the prefix that has the shortest length.

// Your task is to help the trainees to prepare and print the final statement
// after all the replacements done.

// Input Format:
// -------------
// Line-1: Space separated strings, prefixes.
// Line-2: A single line of words, statement.

// Output Format:
// --------------
// Print the String, the final statement.


// Sample Input-1:
// ---------------
// am add mean ref 
// amigos used to address or refer to a friend

// Sample Output-1:
// ----------------
// am used to add or ref to a friend


// Sample Input-2:
// ---------------
// th the pa tho
// thomas the trainer teaches theroy part of thermodynamics

// Sample Output-2:
// ----------------
// th th trainer teaches th pa of th

import java.util.*;
// class j{
//     public static void main (String[] args) {
//         Scanner sc=new Scanner(System.in);
//         String[] pre=sc.nextLine().split(" ");
//         String[] s=sc.nextLine().split(" ");
//         StringBuilder sb=new StringBuilder();
//         for(String i:s){
//             String a=i;
//             for(String j:pre){
//                 if(j.length()<i.length()){
//                     if(i.substring(0,j.length()).equals(j)){
//                         if(a.length()>j.length()){
//                             a=j;
//                         }
//                     }
//                 }
//             }
//             sb.append(a+" ");
//         }
//         System.out.println(sb.toString());
//     }
// }
class Node{
    Node links[]=new Node[26];
    boolean flag=false;
    boolean containskey(char ch){
        return links[ch-'a']!=null;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void put(char ch,Node node){
        links[ch-'a']=node;
    }
    void setend(){
        flag=true;
    }
    boolean isend(){
        return flag;
    }
}
class Trie{
    public static Node root;
    Trie(){
        root=new Node();
    }
    static void insert(String s){
        Node node=root;
        for(int i=0;i<s.length();i++){
            if(!node.containskey(s.charAt(i))){
                node.put(s.charAt(i),new Node());
            }
            node=node.get(s.charAt(i));
        }
        node.setend();
    }
    static String check(String s){
        Node node=root;
        String res=s;
        String ans="";
        for(int i=0;i<s.length();i++){
            if(node.containskey(s.charAt(i))){
                ans=ans+s.charAt(i);
                node=node.get(s.charAt(i));
                if(node.isend()==true){
                    if(ans.length()<res.length()){
                        return ans;
                    }
                }
            }
            else{
                break;
            }
        }
        return res;
    }
}

class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] pre=sc.nextLine().split(" ");
        String[] s=sc.nextLine().split(" ");
        StringBuilder sb=new StringBuilder();
        Trie obj=new Trie();
        for(String i:pre){
            obj.insert(i);
        }
        for(String i:s){
            sb.append(obj.check(i)+" ");
        }
        System.out.println(sb.toString());
    }
}
