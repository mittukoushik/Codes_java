// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).
// Constraints:

// The number of nodes in the tree is in the range [2, 105].
// -109 <= Node.val <= 109
// All Node.val are unique.
// p != q
// p and q will exist in the BST.

// Example:1
// Input: root = [6 2 8 0 4 7 9 -1 -1 3 5], p = 2, q = 8
// Output: 6
// Explanation: The LCA of nodes 2 and 8 is 6.

// Example:2
// Input: root = [6 2 8 0 4 7 9 -1 -1 3 5], p = 2, q = 4
// Output: 2
// Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

// Example : 3
// Input: root = [2 1], p = 2, q = 1
// Output: 2

import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
    }
}
class BST{
    public static Node rptr;
    BST(){
        rptr=null;
    }
    public static Node append(Node r,int d){
        if(r==null){
            Node nptr=new Node(d);
            return nptr; 
        }
        else if(r.data>d){
            r.left=append(r.left,d);
            return r;
        }
        else{
            r.right=append(r.right,d);
            return r;
        }
    }
    public static Node LCA(Node root,Node p,Node q){
        if(root==p || root==q){
            return root;
        }
        if(root.left==p && root.right==q){
            return root;
        }
        if(p.data<root.data && q.data<root.data){
            return LCA(root.left,p,q);
        }
        if(p.data>root.data && q.data>root.data){
            return LCA(root.right,p,q);
        }
        return root;
    }
}
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        BST bst=new BST();
        // int n=sc.nextInt();
        String sarr[] = sc.nextLine().split(" "); 
        int n = sarr.length;
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(sarr[i]);
        }
        int p=sc.nextInt();
        int q=sc.nextInt();
        Node t=bst.append(null,a[0]);
        for(int i=1;i<n;i++){
            if(a[i]!=-1)
                t=bst.append(t,a[i]);
        }
        Node node=bst.LCA(t,new Node(p),new Node(q));
        System.out.println(node.data);
    }
}
