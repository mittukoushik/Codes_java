// Given a preorder traversal of a tree as an array of integers arr[].
// Construct a binary search tree for the above tree.

// Note: 
//     A binary search tree is a binary tree where for every node, any 
//     descendant of Node.left has a value strictly less than Node.val, and 
//     any descendant of Node.right has a value strictly greater than Node.val.
     
//     A preorder traversal of a binary tree displays the value of the node first, 
//     then traverses Node.left, then traverses Node.right.

// Your task is to print the level order traversal of binary search tree that
// has been constructed using the pre order values of a binary tree.
// In the output, all null nodes in the level order traversal are indicated with -1. 

// Input Format:
// -------------
// Line-1: Size of array n
// Line-2: Array elements of size n.

// Output Format:
// --------------
// Print the level order traversal


// Sample Input-1:
// ---------------
// 6
// 10 6 2 8 12 16

// Sample Output-1:
// ----------------
// 10 6 12 2 8 -1 16


// Sample Input-2:
// ---------------
// 3 5

// Sample Output-2:
// ----------------
// 3 -1 5

import java.util.*;
class Node{
    int val;
    Node left,right;
    Node(int d){
        val=d;
        left=right=null;
    }
}
class bst{
    Node root=null;
    Node append(Node root,int d){
        if(root==null){
            Node nn=new Node(d);
            return nn;
        }
        else if(root.val>d){
            root.left=append(root.left,d);
            return root;
        }
        else{
            root.right=append(root.right,d);
            return root;
        }
        
    }
    void levelorder(Node root){
        Queue<Node> q=new LinkedList<>();
        if(root==null){
            return;
        }
        q.add(root);
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int c=q.size();
            while(c>0){
                Node front=q.peek();
                q.poll();
                // if(front.val==-1){
                //     res.add(-1);
                // }
                // else{
                //     res.add(front.val);
                //     if(front.left!=null && front.left.val!=-1){
                //         q.add(front.left);
                //     }
                //     else{
                //         q.add(new Node(-1));
                //     }
                //     if(front.right!=null && front.right.val!=-1){
                //         q.add(front.right);
                //     }
                //     else{
                //         q.add(new Node(-1));
                //     }
                // }
                if(front!=null){
                    // System.out.print(front.val+" ");
                    res.add(front.val);
                    q.add(front.left);
                    q.add(front.right);
                }
                else{
                    // System.out.print(-1+" ");
                    res.add(-1);
                }
                
                c--;
            }
        }
        int p=0;
        for(int i=res.size()-1;i>=0;i--){
            if(res.get(i)!=-1){
                p=i;
                break;
            }
        }
        for(int i=0;i<=p;i++){
            System.out.print(res.get(i)+" ");
        }
    }
}
class j{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        bst bt=new bst();
        Node t=null;
        t=bt.append(null,a[0]);
        for(int i=1;i<n;i++){
            t=bt.append(t,a[i]);
        }
        // bt.in(t);
        bt.levelorder(t);
    }
}
