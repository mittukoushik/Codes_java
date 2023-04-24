/*Vihaar is working with strings. 
He is given two strings A and B, and another string T,
where the length of A and B is same.

You can find the relative groups of letters from A and B,
using the following rule set:
- Equality rule: 'p' == 'p'
- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.

Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.

For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".

You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.


Input Format:
-------------
Three space separated strings, A , B and T

Output Format:
--------------
Print a string, relatively smallest string of T.


Sample Input-1:
---------------
kmit ngit mgit

Sample Output-1:
----------------
ggit

Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"


Sample Input-2:
---------------
attitude progress apriori

Sample Output-2:
----------------
aaogoog

Explanation: 
------------
The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
the relatively smallest string of T is "aaogoog"*/
import java.util.*;
class j{
    static int find(int i,int[] par){
        if(i==par[i]){
            return i;
        }
        return par[i]=find(par[i],par);
    }
    static void union(int i,int j,int[] par){
        int l=find(i,par);
        int r=find(j,par);
        if(l>r){
            par[l]=r;
        }
        else{
            par[r]=l;
        }

    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        String a=str[0],b=str[1],c=str[2];
        int[] par=new int[26];
        int n=a.length();
        for(int i=0;i<26;i++){
            par[i]=i;
        }
        for(int i=0;i<n;i++){
            union(a.charAt(i)-'a',b.charAt(i)-'a',par);
        }
        String res="";
        for(int i=0;i<c.length();i++){
            res+=(char)(find(c.charAt(i)-'a',par)+'a');
        }
        System.out.println(res);
    }
}
