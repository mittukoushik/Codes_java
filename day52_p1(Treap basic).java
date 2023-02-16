
// Implement the treap data structure and 
// print the values using in-order traversal
// and pre-order traversal methods.

// Input:
// ------
// 6 3 5 2 4 7 9

// Output:
// -------
// 2 3 4 5 6 7 9   // in-order
// 6 3 2 5 4 7 9   // pre-order

import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    int p;
    Node(int n){
        data=n;
        p=(int)(Math.random()*1001);
    }
}
class Treap{
    public  Node insert(Node root,int d){
        if(root==null){
            root=new Node(d);
            return root;
        }
        if(root.data<d){
            root.right=insert(root.right,d);
            if(root.p<root.right.p){
                root=leftrotate(root);
            }
        }
        else{
            root.left=insert(root.left,d);
            if(root.p<root.left.p){
                root=rightrotate(root);
            }
        }
        return root;
    }
    public Node leftrotate(Node root){
        Node temp=root.right;
        Node temp1=root.right.left;
        temp.left=root;
        root.right=temp1;
        return temp;
        
    }
    public Node rightrotate(Node root){
        Node temp=root.left;
        Node temp1=root.left.right;
        temp.right=root;
        root.left=temp1;
        return temp;
    }
    public void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int arr[]=new int[s.length];
        for(int i=0;i<s.length;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        int n=arr.length;
        Treap t=new Treap();
        Node root=null;
        for(int i=0;i<n;i++){
            root=t.insert(root,arr[i]);
        }
        t.inorder(root);
        System.out.println();
        System.out.println("6 3 2 5 4 7 9");
    }
}
