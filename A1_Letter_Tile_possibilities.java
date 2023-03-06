// There are some cubes, each cube is printed with an alphabet [A-Z].
// Using these cubes, you can create non-empty distinct words.
// and length of the words should be 0< length <= no.of.cubes.

// You are given a string of alphabets S, 
// Your task is to findout number of possible non-empty distinct words

// Input Format:
// -------------
// A string S, consist of A-Z letters only.

// Output Format:
// --------------
// Print an integer, number of possible non-empty distinct words.


// Sample Input-1:
// ---------------
// EGG

// Sample Output-1:
// ----------------
// 8

// Explanation:
// --------------
// The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


// Sample Input-2:
// ---------------
// MADAM

// Sample Output-2:
// ----------------
// 89



import java.util.*;
class j{
    static Set<String> set=new HashSet<>();
    static void fun(String s,boolean[] vis,String res){
        set.add(res);
        // System.out.println(res);
        for(int i=0;i<s.length();i++){
            if(vis[i]==false){
                vis[i]=true;
                fun(s,vis,res+s.charAt(i));
                vis[i]=false;
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        boolean[] vis=new boolean[s.length()];
        fun(s,vis,"");
        System.out.println(set.size()-1);
    }
}
