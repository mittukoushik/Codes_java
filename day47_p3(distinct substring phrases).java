// At university of Chicago a Computer Science programing faculty as a part of 
// teaching passion, in order to make newly joined students more enthusiastic 
// in learning the subject he will be giving a problem at the first day of semester.

// The student who tops they will be awarded with cash prize. In regard to this 
// he asked the students to work on concept related to strings, he gave a task to
// read a word and find the count of all the turn of phrases of the word, and 
// the phrases should be distinct.

// Now it’s time for you to create a method which satisfies the above program.
// A turn of phrases of a word is obtained by deleting 
// any number of characters (possibly zero) from the front of the word and
// any number of characters (possibly zero) from the back of the word.

// Input Format:
// -------------
// A single string, the word.

// Output Format:
// --------------
// Print an integer, number of distinct phrases possible.


// Sample Input-1:
// ---------------
// aabbaba

// Sample Output-1:
// ----------------
// 21

// Explanation:
// -------------
// The turn of phrases of the word, which are distinct as follows:
// a, b, aa, bb, ab, ba, aab, abb, bab, bba, aba, aabb, abba, bbab, baba, 
// aabba, abbab, bbaba, aabbab, abbaba, aabbaba


// Sample Input-2:
// ---------------
// kmithyd

// Sample Output-2:
// ----------------
// 28

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Set<String> l1=new HashSet<>();
        String res="";
        for(int i=0;i<s.length();i++){
            int l=i,r=i;
            while(l>=0 && r<s.length()){
                l1.add(s.substring(l,r+1));
                l--;
                r++;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<s.length()){
                l1.add(s.substring(l,r+1));
                l--;
                r++;
            }
        }
        System.out.println(l1.size());
    }
}
