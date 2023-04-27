// A transitive law is "If a == b and b == c, then a == c"
// Which also says "If a == b and b != c, then a != c"

// You will be given a list of strings relations[], i.e, like p==q or p!=q.
// Your task is to find out whether all the relations follow the transitive law or not.
// If all of them followed return true, otherwise return false.

// Input Format:
// -------------
// Space separated strnigs, list of relations

// Output Format:
// --------------
// Print a boolean value, whether transitive law is obeyed or not.


// Sample Input-1:
// ---------------
// a==b c==d c!=e e==f

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// a==b b!=c c==a

// Sample Output-2:
// ----------------
// false


// Sample Input-3:
// ---------------
// a==b b==c c!=d d!=e f==g g!=d

// Sample Output-3:
// ----------------
// true


import java.util.*;
class j{
    static int find(int i,int[] par){
        if(i==par[i]){
            return i;
        }
        return par[i]=find(par[i],par);
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        int[] par=new int[26];
        for(int i=0;i<26;i++){
            par[i]=i;
        }
        for(String s:str){
            if(s.charAt(1)=='='){
                par[find(s.charAt(0)-'a',par)]=find(s.charAt(3)-'a',par);
            }
        }
        for(String s:str){
            if(s.charAt(1)=='!'){
                if(find(s.charAt(0)-'a',par)==find(s.charAt(3)-'a',par)){
                    System.out.println(false);
                    System.exit(0);
                }
            }
        }
        System.out.println(true);
        
    }
}
