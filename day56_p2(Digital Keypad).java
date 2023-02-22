// Given a classic mobile phone, and the key pad of the phone looks like below.
// 	1		2		3
// 		   abc	   def
		 
// 	4		5		6
//    ghi     jkl     mno
  
// 	7		8		9
//   pqrs     tuv    wxyz
	
// 	*		0		#


// You are given a string S contains digits between [2-9] only, 
// For example: S = "2", then the possible words are "a", "b", "c".

// Now your task is to find all possible words that the string S could represent.
// and print them in a lexicographical order. 

// Input Format:
// -------------
// A string S, consist of digits [2-9]

// Output Format:
// --------------
// Print the list of words in lexicographical order.


// Sample Input-1:
// ---------------
// 2

// Sample Output-1:
// ----------------
// [a, b, c]


// Sample Input-2:
// ---------------
// 24

// Sample Output-2:
// ----------------
// [ag, ah, ai, bg, bh, bi, cg, ch, ci]
import java.util.*;
class j{
    static void fun(String s,Map<Integer,String> m,List<String> l,int ind,StringBuilder sb){
        if(ind==s.length()){
            l.add(sb.toString());
            return;
        }
        String d=m.get(s.charAt(ind)-'0');
        for(int i=0;i<d.length();i++){
            sb.append(d.charAt(i));
            fun(s,m,l,ind+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Map<Integer,String> m=new HashMap<>();
        m.put(2,"abc");
        m.put(3,"def");
        m.put(4,"ghi");
        m.put(5,"jkl");
        m.put(6,"mno");
        m.put(7,"pqrs");
        m.put(8,"tuv");
        m.put(9,"wxyz");
        List<String> l=new ArrayList<>();
        fun(s,m,l,0,new StringBuilder());
        System.out.println(l);
    }
}
