// There are n football players standing in the ground, coach wants to know the 
// P'th largest height of the players. Given an array of heights[] and the value of P. 
// Help the coach to find the P'th largest height.

// Note: You are suppose to print the P'th largest height in the sorted order of heights[].
//       Not the P'th distinct height.

// Input Format:
// -------------
// Line-1: Size of array n and P value(space separeted)
// Line-2: Array elements of size n.

// Output Format:
// --------------
// Print P'th largest height.



// Sample input-1:
// ---------------
// 8 2
// 1 2 1 3 4 5 5 5

// Sample output-1:
// ----------------
// 5


// Sample input-2:
// ---------------
// 6 3
// 2 4 3 1 2 5

// Sample output-2:
// ----------------
// 3
import java.util.*;
interface constants{
    static List<Integer> l=new ArrayList<>();
}
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
class Treap implements constants{
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
        l.add(root.data);
        inorder(root.right);
    }
}
class j implements constants{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Treap t=new Treap();
        Node root=null;
        for(int i=0;i<n;i++){
            root=t.insert(root,arr[i]);
        }
        t.inorder(root);
        System.out.println(l.get(n-m));
    }
}
