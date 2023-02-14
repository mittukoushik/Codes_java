// In a school, the students are given an array of strings words[]. Students have 
// to find the longest string in words[] such that every prefix of it is also in words.

// For example, let words = ["a", "app", "ap","appl", "apply"]. The string "apply" 
// has prefixes "ap","app","appl" and "a", all of which are in words.

// Your task is the find and return the longest string in words as described above.

// If there is more than one string with the same length, return the lexicographically
// smallest one, and if no string exists, return "".

// Input Format
// -------------
// Line1: string separated by spaces
 
// Output Format
// --------------
// string 

// Sample Input-1:
// ---------------
// k kmi km kmit

// Sample Output-1:
// ----------------
// kmit

// Explanation:
// ------------
// "kmit" has prefixes "kmi", "km", "k" and all of them appear in words.


// Sample Input-2:
// ---------------
// t tanker tup tupl tu tuple tupla

// Sample Output-2:
// ----------------
// tupla

// Explanation:
// ------------
// Both "tuple" and "tupla" have all their prefixes in words.
// However, "tupla" is lexicographically smaller, so we return that.


// Sample Input-3:
// ---------------
// abc bc ab abcd

// Sample Output-3:
// ----------------
// ""
import java.util.*;
class Node{
    Node links[]=new Node[26];
    boolean flag=false;
    boolean containskey(char ch){
        return links[ch-'a']!=null;
    }
    void put(char ch,Node node){
        links[ch-'a']=node;
    }
    Node get(char ch){
        return links[ch-'a'];
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
    public Trie(){
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
    static boolean checkallprefix(String s){
        Node node=root;
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            if(node.containskey(s.charAt(i))){
                node=node.get(s.charAt(i));
                if(node.isend()==false){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
}
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        Trie obj=new Trie();
        for(String i:s){
            obj.insert(i);
        }
        String res="";
        for(String i:s){
            if(obj.checkallprefix(i)){
                if(i.length()>res.length()){
                    res=i;
                }
                else if(i.length()==res.length() && i.compareTo(res)<0){
                    res=i;
                }
            }
        }
        if(res.length()==0){
            System.out.print("");
        }
        else{
            System.out.print(res);
        }
    }
}
