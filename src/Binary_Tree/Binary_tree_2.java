package Binary_Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Binary_tree_2 {
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

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val +" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static int size(Node root){
        if(root == null){
            return 0;
        }
        return 1+ size(root.left)+size(root.right);
    }

    public static int sumofNodes(Node root){
        if(root == null){
            return 0;
        }
        return root.val + sumofNodes(root.left) + sumofNodes(root.right);
    }
    public static int maxnode(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int a = root.val;
        int b = maxnode(root.left);
        int c = maxnode(root.right);
        return Math.max(a, Math.max(b,c));
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public static int minofNodes(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.val, Math.min(minofNodes(root.left), minofNodes(root.right)));
    }
    public static int productofNodes(Node root){
        if(root == null){
            return 1;
        }
        return root.val*productofNodes(root.left)*productofNodes(root.right);
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
        preorder(root);
        System.out.println();
        System.out.print(size(root));
        System.out.println();
        int ans = sumofNodes(root);
        System.out.println(ans);
        System.out.println(maxnode(root));
        System.out.println("The height of tree is: ");
        System.out.println(height(root));
        System.out.println("The Minimum value of all Nodes: ");
        System.out.println(minofNodes(root));
        System.out.println("The Product of Nodes: ");
        System.out.println(productofNodes(root));
        System.out.println("Preorder Traversal:");
        preorder2(root);
        System.out.println("Inorder Traversal:");
        inorder(root);
        System.out.println("Postorder traversal: ");
        postorder(root);
        System.out.println("Printing element on the basis of level");
        levelorder(root,3);
        System.out.println("Printing element of Tree by using BFS.");
        BFS(root);

    }
    public static void preorder2(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preorder2(root.left);
        preorder2(root.right);
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }
    public static void levelorder(Node root, int n){
        if(n > height(root)+1){
            System.out.println("n is greater than height of tree.");
            return;
        }
        if(root == null || n<1){
            return;
        }
        if(n == 1){
            System.out.print(root.val + " ");
            System.out.println();
            return;
        }
        levelorder(root.left, n-1);
        levelorder(root.right, n-1);
    }
    public static void BFS(Node root){
        Queue<Node> qt = new ArrayDeque<>();
        qt.offer(root);
        while(!qt.isEmpty()){
            Node temp= qt.peek();
            if(temp.left != null){
                qt.add(temp.left);
            }
            if(temp.right != null){
                qt.add(temp.right);
            }
            System.out.print(temp.val + " ");
            qt.remove();
        }
    }
}
