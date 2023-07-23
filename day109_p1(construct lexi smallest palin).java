// Mr Shravan is given a word W, and W cosists of lowercase alphabets and '#'. 
// Mr Shravan is allowed to replace the '#' with any one lowercase alphabet, 
// such that the word W is a palindrome and it has to be the lexicographically
// smallest among all the possible options.

// Your task is to help Mr Sharavan to return the lexicographically smallest 
// palindrome string among all the possible options. 
// OR "invlaid" if it is not possible.

// Input Format:
// -------------
// A String W, consists of lowercase letters and #.

// Output Format:
// --------------
// A String result.


// Sample Input-1:
// ---------------
// r#d#v##er

// Sample Output-1:
// ----------------
// redavader


// Sample Input-2:
// ---------------
// r#d#v#cer

// Sample Output-2:
// ----------------
// invalid



import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        int i=0,j=n-1;
        char[] c=s.toCharArray();
        for(;i<j;i++,j--){
            if(c[i]==c[j] && c[i]!='#'){
                continue;
            }
            else if(c[i]==c[j] && c[i]=='#'){
                c[i]='a';
                c[j]='a';
                continue;
            }
            else if(c[i]=='#'){
                c[i]=c[j];
                continue;
            }
            else if(c[j]=='#'){
                c[j]=c[i];
                continue;
            }
            else{
                System.out.println("invalid");
                System.exit(0);
            }
        }
        String ans=String.valueOf(c);
        System.out.println(ans);
    }
}
