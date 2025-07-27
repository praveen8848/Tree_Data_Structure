package Binary_Tree;

public class Binary_Tree_1 {
    public static class Node{
        int val;
        Node left;  // Initially null
        Node right; // Initially null
       public Node(int data){
            this.val = data;
       }

    }
    public static void display(Node temp){
        if(temp == null){
            return;
        }
        System.out.print(temp.val + " --> ");
       if(temp.left != null)System.out.print(temp.left.val +" ");
       if(temp.right != null)System.out.print(temp.right.val);
       System.out.println();
        display(temp.left);
        display(temp.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(6);
        Node f  = new Node(7);
        b.left = e;
        b.right = f;
        display(root);
    }
}
