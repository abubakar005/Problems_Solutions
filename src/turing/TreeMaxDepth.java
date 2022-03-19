package turing;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxDepth {

    static TreeNode root;

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    private TreeNode addNode(TreeNode current, int value) {

        if(current == null)
            return new TreeNode(value);

        if(value < current.value)
            current.left = addNode(current.left, value);
        else if(value > current.value)
            current.right = addNode(current.right, value);
        else
            return current;

        return current;
    }

    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> subQueue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while(!queue.isEmpty()) {

            TreeNode temp = queue.remove();

            if(temp.left != null)
                subQueue.add(temp.left);

            if(temp.right != null)
                subQueue.add(temp.right);

            if(queue.isEmpty()) {
                queue = subQueue;
                subQueue = new LinkedList<>();
                depth++;
            }
        }

        return depth;
    }

    public boolean findNode(TreeNode current, int value) {

        if(current == null)
            return false;

        if(current.value == value)
            return true;

        if(value < current.value)
            return findNode(current.left, value);
        else
            return findNode(current.right, value);
    }

    private TreeNode deleteNode(TreeNode current, int value) {

        if (current == null)
            return null;

        if (value == current.value) {

            // Case 1: when node has no child
            if(current.left == null && current.right == null)
                return null;

            // Case 2: when node has one child
            if(current.left == null)
                return current.right;

            if(current.right == null)
                return current.left;

        }

        if (value < current.value) {
            current.left = deleteNode(current.left, value);
            return current;
        } else {
            current.right = deleteNode(current.right, value);
            return current;
        }
    }

    public void traverseLevelOrder() {

        if (root == null) {
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<TreeNode> subNodes = new LinkedList<>();
        nodes.add(root);

        print(nodes);

        while (!nodes.isEmpty()) {

            TreeNode node = nodes.remove();

            if (node.left != null)
                subNodes.add(node.left);

            if (node.right != null)
                subNodes.add(node.right);

            if(nodes.isEmpty()) {

                if(!subNodes.isEmpty())
                    print(subNodes);

                nodes = subNodes;
                subNodes = new LinkedList<>();
            }
        }
    }

    public static void main(String[] ags) {

        TreeMaxDepth bt = new TreeMaxDepth();

        root = bt.addNode(root, 6);
        bt.addNode(root,4);
        bt.addNode(root, 8);
        bt.addNode(root, 3);
        bt.addNode(root, 5);
        bt.addNode(root, 7);
        bt.addNode(root, 9);

        bt.traverseLevelOrder();
       /* int depth = bt.maxDepth(root);
        System.out.println();
        System.out.println("Depth: " + depth);

        System.out.println("Node 5: " + bt.findNode(root, 5));
        System.out.println("Node 0: " + bt.findNode(root, 0));
        System.out.println("Node 9: " + bt.findNode(root, 9));*/
    }

    private void print(Queue<TreeNode> nodes) {
        nodes.stream().forEach(node -> System.out.print(node.value + " "));
        System.out.println();
    }
}
