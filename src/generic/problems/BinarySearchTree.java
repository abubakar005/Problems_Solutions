package generic.problems;

public class BinarySearchTree {

    static class Node{

        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insertElement(Node root, int value) {

        if(root == null)
            return new Node(value);

        if(value > root.value)
            root.right = insertElement(root.right, value);

        if(value < root.value)
            root.left = insertElement(root.left, value);

        return root;
    }

    public static boolean findElement(Node root, int value) {

        if(root == null)
            return false;

        if(root.value == value)
            return true;

        if(value > root.value)
            return findElement(root.right, value);
        else
            return findElement(root.left, value);
    }

    public static void traversalBFS() {

    }

    public static void traversalDFS() {

    }

    public static void traversalInOrder(Node root) {
        if(root != null) {
            traversalInOrder(root.left);
            System.out.println(root.value);
            traversalInOrder(root.right);
        }
    }

    public static void traversalPreOrder(Node root) {
        if(root != null) {
            System.out.println(root.value);
            traversalInOrder(root.left);
            traversalInOrder(root.right);
        }
    }

    public static void traversalPostOrder(Node root) {
        if(root != null) {
            traversalInOrder(root.left);
            traversalInOrder(root.right);
            System.out.println(root.value);
        }
    }


    public static void main(String[] args) {

        Node root = null;

        root = insertElement(root, 50);
        insertElement(root, 35);
        insertElement(root, 25);
        insertElement(root, 40);
        insertElement(root, 75);
        insertElement(root, 65);
        insertElement(root, 85);


        System.out.println(findElement(root, 75));
        traversalInOrder(root);
    }
}
