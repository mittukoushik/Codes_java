// Sridhar brought his latest Apple iPhone 12 pro. He started his conversation 
// with one of his friend on WhatsApp with list of words.

// Now it’s our task to find and return what are the most common words 
// in the list of words he used in sorted order based on occurrence from 
// largest to smallest. If any of words he used are having same occurrence 
// then consider the lexicographic order.

// You will be given a list of words, you need to print top P number of 
// most common used words as described in the statement. 

// Input Format:
// -------------
// Line-1: comma separated line of words, list of words.
// Line-2: An integer P, number of words to display. 

// Output Format:
// --------------
// Print P number of most common used words.


// Sample Input-1:
// ---------------
// ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are,case
// 3

// Sample Output-1:
// ----------------
// [are, case, egg]



// Sample Input-2:
// ---------------
// ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are
// 3

// Sample Output-2:
// ----------------
// [are, egg, case]

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.next().split(",");
        int k=sc.nextInt();
        Map<String,Integer> m=new TreeMap<>();
        for(String i:s){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        List<Integer> l1=new ArrayList<>(m.values());
        Collections.sort(l1);
        int ma=l1.get(l1.size()-1);
        Map<Integer,List<String>> hm=new HashMap<>();
        for(Map.Entry e:m.entrySet()){
            int a=(int)e.getValue();
            hm.put(ma-a,new ArrayList<>());
        }
        for(Map.Entry e:m.entrySet()){
            int a=(int)e.getValue();
            hm.get(ma-a).add((String)e.getKey());
        }
        List<List<String>> l=new ArrayList<>(hm.values());
        List<String> res=new ArrayList<>();
        for(List<String> i:l){
            Collections.sort(i);
            for(String j:i){
                if(k>0){
                    res.add(j);
                }
                else{
                    break;
                }
                k--;
            }
        }
        System.out.println(res);
    }
}
