package Binary_Tree;

import java.util.Stack;

public class Binary_Tree_3 {
    public static void main(String[] args) {
        Node b1 = new Node(3);
        Node b2 = new Node(4);
        Node b3 = new Node(5);
        Node b4 = new Node(6);
        Node b5 = new Node(7);
        Node b6 = new Node(8);
        Node b7 = new Node(9);
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b3.left = b6;
        b3.right = b7;
        System.out.println("Printing element of Binary tree by PreOrder traversal.");
        Node.display(b1);
        System.out.println();
        System.out.println("Printing element through iterative preorder method.");
        Node.preorder(b1);
        System.out.println();
        System.out.println("Printing element through iterative postorder method.");
        Node.postorder(b1);
        System.out.println();
        System.out.println("Printing element through iterative inorder method.");
        Node.inorder(b1);


    }

}
class Node{
    int data;
    Node left;
    Node right;

    Node(int x){
        data = x;
    }

    public static void display(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + "->");
        display(root.left);
        display(root.right);
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()){
            int x = st.size();
            for (int i = 0; i < x; i++) {
                Node temp = st.pop();
                if(temp.right != null){
                    st.push(temp.right);
                }
                if(temp.left != null){
                    st.push(temp.left);
                }
                System.out.print(temp.data + " ");
            }
        }
    }

    public static void postorder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> st1  = new Stack<>();
        Stack<Node> st2  = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()){
            int len = st1.size();
            for(int i = 0; i<len; i++){
                Node temp = st1.pop();
                st2.push(temp);
                if(temp.left != null){
                    st1.push(temp.left);
                }
                if(temp.right != null){
                    st1.push(temp.right);
                }
            }
        }
        while(!st2.isEmpty()){
            System.out.print(st2.pop().data + " ");
        }
    }
    public static void inorder(Node root){
        Stack<Node> st = new Stack<>();
        if(root == null){
            return;
        }
        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                root = st.pop();
                System.out.print(root.data + " ");
                root = root.right;

            }
        }
    }
}
