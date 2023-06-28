// Mark is playing a game where he is trying to save the city of Atlantis 
// by throwing grenades at a monster which is trying to destroy the city. 
// Once a monster gets hit with a grenade, it stays inactive for d seconds. 
// So let's say, if monster gets hit at second t, it will stay inactive during 
// the inclusive time interval [t,t+d-1]. If another grenade is thrown before 
// the effect of previous one ends, the monster remains inactive until seconds 
// after this new attack. 

// Given an array of non-decreasing integers attack, where attack[i] represents
// that a grenade is thrown at attack[i]-th second, and the value of integer
// duration d, you need to return the total number of seconds that the monster
// stayed inactive. 


// Constraints: 
// • attack is sorted in non-decreasing order. 
// • 1 <= attack.length <= 10^4 
// • 0 <= attack[i], d <= 10^7 


// Sample Input-1:
// ---------------
// 2 3     // n and d values
// 1 5     // attack[] values


// Sample Output-2:
// ----------------
// 6


// Sample Input-2:
// ---------------
// 3 5
// 1 3 5

// Sample Output-2:
// ----------------
// 9



import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int[][] l=new int[n][2];
        for(int i=0;i<n;i++){
            l[i]=new int[]{a[i],a[i]+d-1};
        }
        List<int[]> res=new ArrayList<>();
        int s=l[0][0],e=l[0][1];
        for(int[] i:l){
            if(i[0]<=e){
                e=Math.max(e,i[1]);
            }
            else{
                res.add(new int[]{s,e});
                s=i[0];
                e=i[1];
            }
        }
        res.add(new int[]{s,e});
        int ans=0;
        // System.out.println(res);
        for(int[] i:res){
            ans+=i[1]-i[0]+1;
        }
        System.out.println(ans);
    }
}
