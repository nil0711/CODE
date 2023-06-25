import java.util.Objects;
import java.util.Scanner;

public class inorder_binary_tree_traversal {
    static Scanner sc= new Scanner(System.in);
        static class Node{
            String data;
            Node left , right;
            Node(String data){
                this.data=data;
            }
        }
    static Node root = null;
        static  Node createTree(){
            System.out.println("Enter data: ");
            String data=sc.next();
            if(Objects.equals(data, "-1"))return null;
            root = new Node(data);
            System.out.println("Enter left for "+data);
            root.left=createTree();
            System.out.println("Enter right for "+data);
            root.right=createTree();
            return root;
        }
        static void inOrder(Node root){
            if(root==null)return;
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
        static void preOrder(Node root){
            if(root==null)return;
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        static void postOrder(Node root){
            if(root==null)return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

    public static void main(String[] args) {
        createTree();
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);

    }}
