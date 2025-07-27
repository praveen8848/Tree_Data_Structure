package Binary_Search_Tree;

// Implementations

public class BST_1 {
    Node root;
    static int ans;
    public static void main(String[] args) {
        BST_1 r = new BST_1();
        r.insert(20);
        r.insert(30);
        r.insert(40);
        r.insert(10);
        r.insert(18);
        r.insert(5);
        r.insert( 15);
        System.out.println("Inorder Traversal of binary Search Tree.");
        r.inorder();
        System.out.println();
        System.out.print("Result of search in BST: ");
        System.out.println(r.searchBST(15));
//        System.out.println("Deletion in a BST.");
//        Node k = r.delete(15);
//        r.inorder(k);
//        System.out.println();
//        r.inorder();
        System.out.println();
        System.out.println("Print the Ceil element.");
        r.ceil(20);
        System.out.println(ans);

    }
    public void insert( int val){
        root = insertR(root, val);
    }
    

    public Node insertR(Node root, int val){
        if(root == null){
            return new Node(val);
        }
        if(val<root.val){
            root.left =  insertR(root.left, val);
        }
        else {
            root.right = insertR(root.right, val);
        }
        return root;
    }
    public void inorder(){
        inorder(root);
    }
    void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);

    }
    public boolean searchBST(int val){
       return  searchBST(root, val);
    }
     boolean searchBST(Node root, int val){
        if(root == null){
            return false;
        }
        if(root.val == val){
            return true;
        }
        return val<root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public Node delete(int val){
        return deleteNode(root, val);
    }

    public Node deleteNode(Node root, int val){
        if(root == null){
            return root;
        }
        if(val<root.val){
            root.left = deleteNode(root.left, val);
        } else if (val>root.val) {
            root.right = deleteNode(root.right, val);
        }
        else{

            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    public int minValue(Node root){
        int minv = root.val;
        while (root.left != null){
            minv = root.left.val;
            root= root.left;
        }
        return minv;
    }

    public void ceil(int val){
         ceilNode(root, val);
    }

    void ceilNode(Node root, int val){
        if(root == null){
            return;
        }
        if(val<=root.val){
            ans = root.val;
            ceilNode(root.left, val);
        }
        else{
            ceilNode(root.right, val);
        }
    }
}
class Node{
    int val;
    Node left;
    Node right;
    public Node(int d){
        this.val =d;
        left = null;
        right = null;
    }

}
