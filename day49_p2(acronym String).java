// Ananth interested in creating the acronyms for any word. The definition
// of acronym is another word with a concatenation of its first letter,
// the number of letters between the first and last letter, and its last letter. 
 
// If a word has only two characters, then it is an acronym of itself.

// Examples:
//     - Acronym of 'fog' is f1g'.
//     - Acronym of 'another' is 'a5r'.
//     - Acronym of 'ab' is 'ab'.

// You are given a list of vocabulary, and another list of words.
// Your task is to check,each word with the vocabulary and
// return "true" if atleast one of the following rules satisfied:
// 1. acronym of the word should not match with any of the acronyms of vocabulary
// 2. if acronym of the word matches with any of the acronyms of vocabulary
// 'the word' and matching words in vocabulary should be same.

// Otherwise, return 'false'.

// Input Format:
// -------------
// Line-1: Space separated strings, vocabulary[] 
// Line-2: Space separated strings, words[] 

// Output Format:
// --------------
// Print N boolean values, where N = words.length 


// Sample Input-1:
// ---------------
// cool bell cool coir move more mike
// cool char move 

// Sample Output-1:
// ----------------
// true false false


// Sample Input-2:
// ---------------
// cool bell coal coir
// cool char 

// Sample Output-2:
// ----------------
// false false
import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s1=sc.nextLine().split(" ");
        String[] s2=sc.nextLine().split(" ");
        for(String i:s2){
            int flag=0;
            for(String j:s1){
                if(i.charAt(0)==j.charAt(0) && i.charAt(i.length()-1)==j.charAt(j.length()-1)){
                    if(!i.equals(j)){
                        flag=1;
                        System.out.print(false+" ");
                        break;
                    }
                }
            }
            if(flag==0)
                System.out.print(true+" ");
        }
    }
}
