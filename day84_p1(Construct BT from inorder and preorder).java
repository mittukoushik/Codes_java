// In a joint family of N members, every person assigned with an ID, an integer value.
// and the entire family is arranged in the from of binary tree.

// You will be given the preOrder data and inOrder data of the tree.
// Your task is to build the original fammily tree using the given data.
// and return the root of the tree.

// Implement the class Solution:
//     - Node buildBinaryTree(int[] preOrder, int[] inOrder):
//         return the root node of the tree.

// Input Format:
// -------------
// Line-1: An integer N, number of persons in the family.
// Line-2: N space separated integers, preOrder[] data.
// Line-3: N space separated integers, inOrder[] data.

// Output Format:
// --------------
// Return the root node of the original tree.


// Sample Input-1:
// ---------------
// 7
// 1 2 4 5 3 6 7
// 4 2 5 1 6 3 7

// Sample Output-1:
// ----------------
// 1 2 3 4 5 6 7 



// Sample Input-2:
// ---------------
// 8
// 1 2 8 3 4 6 5 7
// 2 8 1 6 4 3 5 7

// Sample Output-2:
// ----------------
// 1 2 3 8 4 5 6 7



import java.util.*;

/*
Reference of Node

class Node {
    public int data;
    public Node left;
    public Node right;
    public Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

*/

class Solution{
    static Node build(int[] inOrder,int inStart,int inEnd,int[] preOrder,int preStart,int preEnd,Map<Integer,Integer> m){
        if(inStart> inEnd || preStart>preEnd){
            return null;
        }
        Node root=new Node(preOrder[preStart]);
        int inRoot=m.get(root.data);
        int numsleft=inRoot- inStart;
        root.left=build(inOrder,inStart,inRoot-1,preOrder,preStart+1,preStart+numsleft,m);
        root.right=build(inOrder,inRoot+1,inEnd,preOrder,preStart+numsleft+1,preEnd,m);
        return root;
    }
    Node buildBinaryTree(int[] preOrder, int[] inOrder){
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<inOrder.length;i++){
            m.put(inOrder[i],i);
        }
        return build(inOrder,0,inOrder.length-1,preOrder,0,preOrder.length-1,m);
    }
}
