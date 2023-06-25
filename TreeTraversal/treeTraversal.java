package TreeTraversal;

class Node {
    int value;
    Node left;
    Node right;

    Node(int val) {
        value = val;
        left = null;
        right = null;
    }
}

public class treeTraversal {

    public static void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public static void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }

    public static void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Perform preorder traversal
        System.out.print("Preorder traversal: ");
        preorderTraversal(root);
        System.out.println();

        // Perform inorder traversal
        System.out.print("Inorder traversal: ");
        inorderTraversal(root);
        System.out.println();

        // Perform postorder traversal
        System.out.print("Postorder traversal: ");
        postorderTraversal(root);
        System.out.println();
    }
}
