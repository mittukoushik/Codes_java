// For X-Mas, santa claus is preparing a X-Mas Tree with set of Bulbs.
// The bulbs are of different voltages, and preparation of tree as follows:
// 	- The bulbs are arranged in level-wise, levels are numbered from 0,1,2,3..
// 	  so on.
// 	- At level-0: There will be only one bulb as root bulb.,
// 	- From next level onwards, we have to attach atmost two bulbs, one is to
// 	  left side, and the other is for right side of every bulb in previous level.
// 	- A bulb B is said to be BRIGHT, if all the bulbs in the path root bulb to 
//       bulb B, there are no bulbs with a voltage greater than bulb B.
      
// You will be given the root of the X-Mas Tree,
// your task is to return the number of bright bulbs in xmas tree
// Implement the class Solution:
// 1.public int brighterBulbs(Node root): returns an integer output.

// NOTE:
// -----
// In the input -1 indicates no bulb (null node).


// Input Format:
// -------------
// An integer, number of bulbs.
// A single line of space separated integers, voltages of the set of N bulbs.

// Output Format:
// --------------
// Print the number of BRIGHT bulbs in the tree.


// Sample Input-1:
// ---------------
// 7
// 5 6 3 8 2 6 9

// Sample Output-1:
// ----------------
// 5


// Sample Input-2:
// ---------------
// 13
// 1 2 3 4 5 6 7 8 9 10 -1 -1 11

// Sample Output-2:
// ----------------
// 11
/*
//TreeNode Structure for Your Reference..

class Node{
	public int data; 
	public Node left, right; 
	public Node(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

*/
import java.util.*;
class Solution {
    static int c=0;
    static void fun(Node root,List<Integer> l){
        l.add(root.data);
        List<Integer> l1=new ArrayList<>();
        l1.addAll(l);
        Collections.sort(l);
        if(l1.equals(l)){
            c++;
        }
        if(root.left!=null && root.left.data!=-1){
            fun(root.left,new ArrayList<>(l));
        }
        if(root.right!=null && root.right.data!=-1){
            fun(root.right,new ArrayList<>(l));
        }
    }
    public int brighterBulbs(Node root) {
        // Implement Your Code here..
        fun(root,new ArrayList<>());
        return c;
    }
}
