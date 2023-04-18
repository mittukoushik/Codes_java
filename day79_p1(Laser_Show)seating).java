// The laser show at the Lumbini Park is something not to be missed.
// But, as per govt rule they have to follow COVID-19 restrictions.
// The management planning to guide the audience to sit in the seats
// that maximizes the distance to the closest person, in order to
// practice the social distance in the auditorium.

// Please help usher to guide the audience to sit in a seat by following few rules:

// - There are N seats in a single row, seats are numbered from 0 to N-1.
// - Maximize the distance from person to the closest person.
// - If there are multiple seats with similar distance, they sit in the seat with the lowest number.
// - First person always sit in seat number 0.
// - If a person leaves the auditorium from a seat, please consider that the seat is vacant

// Create a class Auditorium and two functions in it.
// 1. int seat(): represent the seat number of audience to sit.
// 2. void leave(int s): person leaves the auditorium from a seat number 's'.

// Input Format:
// ----------------
// Line-1 -> two integers N and P, Number of seats N, Number of Operations P
// P lines of input -> each line contains funtion number and parameter list (if required).

// Output Format:
// ------------------
// Print the alloted seat numbers in one line as output.


// Sample Input-1:
// -------------------
// 10 6
// 1
// 1
// 1
// 1
// 2 4
// 1

// Sample Output-1:
// ---------------------
// 0 9 4 2 5

// NOTE:
// -----
// In the sample input:
//     - option 1 indicates, calling "int seat()" method.
//     - option 2 indicates, calling "void leave(seat_num)" method.
    

import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        boolean[] vis=new boolean[n];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            int op=sc.nextInt();
            if(op==1){
                if(i==0){
                    vis[i]=true;
                    ans.add(i);
                }
                else if(i==1){
                    vis[n-1]=true;
                    ans.add(n-1);
                }
                else{
                    if(vis[0]==false){
                        vis[0]=true;
                        ans.add(0);
                    }
                    else if(vis[n-1]==false){
                        vis[n-1]=true;
                        ans.add(n-1);
                    }
                    else{
                        int m=Integer.MIN_VALUE;
                        int point=0;
                        List<Integer> res=new ArrayList<>();
                        for(int j=0;j<vis.length;j++){
                            if(vis[j]==true){
                                res.add(j);
                            }
                        }
                        for(int j=0;j<res.size()-1;j++){
                            if(m<Math.abs(res.get(j)-res.get(j+1))/2){
                                m=Math.abs(res.get(j)-res.get(j+1))/2;
                                point=(res.get(j)+res.get(j+1))/2;
                            }
                        }
                        vis[point]=true;
                        if(point!=0){
                            ans.add(point);
                        }
                    }
                }
            }
            else{
                int b=sc.nextInt();
                vis[b]=false;
            }
        }
        System.out.println(ans);
    }
}
