// Venkat wants to create a unique name for his child, to do that he is referring 
// two names, one is traditonal name(TN) and other is modern name(MN).

// He is planning to create unique name(UN), using the following ways:
//     - if traditional name TN is non empty, then add the first letter L of TN 
//     to unique name UN and remove the letter L from traditional name TN
// 	e.g., if TN = "havi" and UN="anvika", then after adding L to UN and remove L 
// 	from TN, the names updated as UN="hanvika", TN="avi".
   
//    - if modern name MN is non empty, then add the first letter L of MN 
//     to unique name UN and remove the letter L from modern name MN
//     e.g., if MN = "ram" and UN="ao", then after adding L to UN and remove L 
// 	from MN, the names updated as UN="rao", MN="am".
	
// You are given two names, TN and MN, 
// Your task is to help venkat to generate the unique name for his child,
// and the name should be largest in the dictionary order.

// For example, "kmit" is larger than "kmec", as third letter is greater in "kmit".

// Input Format:
// -------------
// Two space separated names, TN and MN.

// Output Format:
// --------------
// Print a string, the laregst unique name possible.


// Sample Input-1:
// ---------------
// sudha vivid

// Sample Output-1:
// ----------------
// vsuividhda


// Sample Input-2:
// ---------------
// appa banana

// Sample Output-2:
// ----------------
// bappananaa

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        String a=s[0],b=s[1];
        int i=0,j=0,n=a.length(),m=b.length();
        StringBuilder sb=new StringBuilder();
        while(i<n && j<m){
            if(a.charAt(i)>b.charAt(j)){
                sb.append(a.charAt(i++));
            }
            else if(a.charAt(i)<b.charAt(j)){
                sb.append(b.charAt(j++));
            }
            else{
                if(a.substring(i).compareTo(b.substring(j))>0){
                    sb.append(a.charAt(i++));
                }
                else{
                    sb.append(b.charAt(j++));
                }
            }
        }
        while(i<n){
            sb.append(a.charAt(i++));
        }
        while(j<m){
            sb.append(b.charAt(j++));
        }
        System.out.println(sb.toString());
    }
}
