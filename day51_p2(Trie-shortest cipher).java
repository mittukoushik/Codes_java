// Mr Suresh is working with the plain text P, a list of words w[], 
// He is converting P into C [the cipher text], C is valid cipher of P, 
// if the following rules are followed:
// 	- The cipher-text C is a string ends with '$' character.
// 	- Every word, w[i] in w[], should be a substring of C, and 
// 	the substring should have $ at the end of it.

// Your task is to help Mr Suresh to find the shortest Cipher C,  
// and return its length.

// Input Format:
// -------------
// Single line of space separated words, w[].

// Output Format:
// --------------
// Print an integer result, the length of the shortest cipher.


// Sample Input-1:
// ---------------
// kmit it ngit

// Sample Output-1:
// ----------------
// 10

// Explanation:
// ------------
// A valid cipher C is "kmit$ngit$".
// w[0] = "kmit", the substring of C, and the '$' is the end character after "kmit"
// w[1] = "it", the substring of C, and the '$' is the end character after "it"
// w[2] = "ngit", the substring of C, and the '$' is the end character after "ngit"


// Sample Input-2:
// ---------------
// ace

// Sample Output-2:
// ----------------
// 4

// Explanation:
// ------------
// A valid cipher C is "ace$".
// w[0] = "ace", the substring of C, and the '$' is the end character after "ace"
import java.util.*;
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
        for(int i=s.length()-1;i>=0;i--){
            if(!node.containskey(s.charAt(i))){
                node.put(s.charAt(i),new Node());
            }
            node=node.get(s.charAt(i));
        }
        node.setend();
    }
    static boolean search(String s){
        Node temp=root;
        for(int i=s.length()-1;i>=0;i--){
            temp=temp.get(s.charAt(i));
        }
        for(int i=0;i<26;i++){
            if(temp.links[i]!=null){
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
        Set<String> set=new HashSet<>();
        for(String i:s){
            obj.insert(i);
            set.add(i);
        }
        System.out.println(set);
        int ans=0;
        for(String i:set){
            if(obj.search(i)){
                ans++;
                // System.out.println(i);
                ans=ans+i.length();
            }
        }
        System.out.println(ans);
    }
}
