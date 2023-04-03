// In an online magazine, every day they will ask their readers a puzzle.
// The puzzle has to be solved using the following rule set:
// 	- The puzzle is an 9*9 matrix, and consist of 9 -> 3*3 sub-matrices.
// 	- Each row in the puzzle should be filled with 1-9digits with out repetition
// 	- Each column in the puzzle should be filled with 1-9digits with out repetition.
// 	- Each 3*3 sub-matrix should be filled with 1-9 digits with out repetition.

// You will be given the puzzle in the form of 9 strings, each string length is 9.
// Your task is check whether the puzzle can be solved or not.
// If it is possible to solve, print "true". Otherwise print "false".


// Input Format:
// -------------
// 9 Lines: Each line consists of a string  length-9, consist of digits[1-9] and '.' only

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 53..7....
// 6..195...
// .98....6.
// 8...6...3
// 4..8.3..2
// 7...2...6
// .6....28.
// ...419..5
// ....8..79

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 83..7....
// 6..195...
// .98....1.
// 8...6...3
// 4..8.3..1
// 7...2...6
// .6....28.
// ...419..5
// ....8..79

// Sample Output-2:
// ----------------
// false


import java.util.*;
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        char[][] l=new char[9][9];
        for(int i=0;i<9;i++){
            char[] c=sc.nextLine().toCharArray();
            l[i]=c;
        }
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(l[i][j]!='.'){
                    m.put(l[i][j],m.getOrDefault(l[i][j],0)+1);
                }
            }
            for(int k:m.values()){
                if(k>1){
                    System.out.println(false);
                    System.exit(0);
                }
            }
            m.clear();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(l[j][i]!='.'){
                    m.put(l[j][i],m.getOrDefault(l[j][i],0)+1);
                }
            }
            for(int k:m.values()){
                if(k>1){
                    System.out.println(false);
                    System.exit(0);
                }
            }
            m.clear();
        }
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                for(int x=i;x<i+3;x++){
                    for(int y=j;y<j+3;y++){
                        if(l[x][y]!='.'){
                            m.put(l[x][y],m.getOrDefault(l[x][y],0)+1);
                        }
                    }
                }
                for(int k:m.values()){
                    if(k>1){
                        System.out.println(false);
                        System.exit(0);
                    }
                }
                m.clear();
            }
        }
        System.out.println(true);
    }
}
