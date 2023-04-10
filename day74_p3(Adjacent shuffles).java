// Gnanesh is working on Machine Learning domain. He wants train the machine 
// in such a way that, if he provided an image printed with a string on it,
// the machine has to extract the text as a string and verify that, 
// after shuffling  the letters in the string, 'the shuffled string should be 
// like no two adjacent letters should be same' 

// You will be given extracted string, and
// Can you help Gnanesh to train the machine with the given constraint 
// The machine has to print "true", if the constarint is met, 
// Otherwise, print "false".

// Input Format:
// -------------
// A String S

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// aaabd

// Sample Output-1:
// ----------------
// true

// Sample Input-2:
// ---------------
// aaab

// Sample Output-2:
// ----------------
// false


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Map<Character,Integer> m=new HashMap<>();
        for(char i:s.toCharArray()){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        for(int i:m.values()){
            if(s.length()%2==0){
                if(i>s.length()/2){
                    System.out.println(false);
                    System.exit(0);
                }
            }
            else{
                if(i>s.length()/2+1){
                    System.out.println(false);
                    System.exit(0);
                }
            }
        }
        System.out.println(true);
    }
}
