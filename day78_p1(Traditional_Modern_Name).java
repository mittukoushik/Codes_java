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
class a{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String [] s=sc.nextLine().split(" ");
        String a=s[0];
        String b=s[1];
        int i=0;
        int j=0;
        String k="";
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)>b.charAt(j)){
                k+=a.charAt(i);
                i++;
            }
            else if (a.charAt(i)<b.charAt(j)){
                k+=b.charAt(j);
                j++;
            }
            else {
                int m=check(a,b,i,j);
                if(m==1){
                    k+=a.charAt(i);
                    i++;
                }
                else{
                    k+=b.charAt(j);
                    j++;
                }
            }
        }
        while(i<a.length()){
            k+=a.charAt(i);
            i++;
        }
        while(j<b.length()){
            k+=b.charAt(j);
            j++;
        }
        System.out.println(k);
    }
    static int check(String a,String b,int i,int j){
        if(i>=a.length()){
            return 0;
        }
        if(j>=b.length()){
            return 1;
        }
        if(a.charAt(i)>b.charAt(j)){
            return 1;
        }
        else if(a.charAt(i)<b.charAt(j)){
            return 0;
        }
        else{
            return check(a,b,i+1,j+1);
        }
    }
}
