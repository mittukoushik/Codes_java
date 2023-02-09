// "Emphatic Pronunciation" of a given word is where we take the word and
// replicate some of the letter to emphasize their impact.

// Instead of saying 'oh my god', someone may say "ohhh myyy goddd", 
// We define emphatic pronunciation of a word, which is derived by replicating 
// a group (or single) of letters in the original word. 

// So that the replicated group is atleast 3 characters or more and 
// greater than or equal to size of original group. 
// For example Good -> Goood is an emphatic pronunciation,
// but Goodd is not because in Goodd the 'd' are only occuring twice consecutively.
 
// In the question you are given the "Emphatic pronunciation" word, 
// you have to findout how many words can legal result in the 
// "emphatic pronunciation" word.

// Input Format:
// -------------
// Line-1 -> A String contains a single word, Emphatic Pronunciation word
// Line-2 -> Space seperated word/s

// Output Format:
// --------------
// Print an integer as your result


// Sample Input-1:
// ---------------
// Goood
// Good

// Sample Output-1:
// ----------------
// 1


// Sample Input-2:
// ---------------
// heeelllooo
// hello hi helo

// Sample Output-2:
// ----------------
// 2

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] str=sc.nextLine().split(" ");
        char str1[]=s.toCharArray();
        int c=0;
        for(String i:str){
            if(isvalid(str1,i)){
                c++;
            }
        }
        System.out.println(c);
    }
    static boolean isvalid(char[] s1,String s){
        char[] s2=s.toCharArray();
        int i1=0,i2=0;
        while(i1<s1.length && i2<s2.length){
            if(s1[i1]!=s2[i2]){
                return false;
            }
            char c1=s1[i1];
            i1++;
            i2++;
            int counter1=1;
            int counter2=1;
            while(i1<s1.length && s1[i1]==c1){
                i1++;
                counter1++;
            }
            while(i2<s2.length && s2[i2]==c1){
                i2++;
                counter2++;
            }
            if(counter1!=counter2 && (counter1<3 || counter2>counter1)){
                return false;
            }
        }
        if(i1!=s1.length || i2!=s2.length){
            return false;
        }
        return true;
    }
}

