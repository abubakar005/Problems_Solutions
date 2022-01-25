package pluang.interviw;

// problem statement: link list in the order  1 -> 2 -> 3 -> 4 -> 5 -> 6
// output: 1 -> 6 -> 2 -> 5 -> 3 -> 4

import java.util.Stack;

public class ReArrangeLinkList {

    class Node {

        int val;
        Node next;

        public Node(int val) {
            this. val = val;
            this.next = null;
        }
    }

    Node root;
    Node current;

    public static void main(String args[]){

        ReArrangeLinkList reArrangeLinkList = new ReArrangeLinkList();
        reArrangeLinkList.addNodes();

        reArrangeLinkList.print();
        reArrangeLinkList.reArrangeNodes();
        System.out.println("===================");
        reArrangeLinkList.print();
    }

    void reArrangeNodes() {

        Stack<Node> stack = new Stack<>();
        Node slow = root;
        Node fast = root;

        // It will identify the half of the linklist
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Pushing next half in the stack
        while(slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        Node reArrange = root;

        while(!stack.isEmpty()) {
            Node next = reArrange.next;
            reArrange.next = stack.pop();

            if (stack.isEmpty()) {
                reArrange.next.next = null;
            } else {
                reArrange.next.next = next;
                reArrange = reArrange.next.next;
            }
        }
    }

    void addNode(int val) {

        if(root == null) {
            root = new Node(val);
            current = root;
        } else {
            current.next = new Node(val);
            current = current.next;
        }
    }

    void print() {

        if(root == null)
            System.out.println("Linklist is empty!");
        else {
            Node temp = root;
            while(temp != null) {
                System.out.println(temp.val);
                temp = temp.next;
            }
        }
    }

    void addNodes() {
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(5);
        addNode(6);
       // addNode(7);
       // addNode(8);
    }
}
