package generic.problems;

// problem statement: link list in the order  1 -> 2 -> 3 -> 4 -> 5 -> 6
// output: 1 -> 6 -> 2 -> 5 -> 3 -> 4

import java.util.Stack;

public class LinkListGreaterSum {

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

        LinkListGreaterSum reArrangeLinkList = new LinkListGreaterSum();
        reArrangeLinkList.addNodes();

        //reArrangeLinkList.print();
        reArrangeLinkList.sumNodes();
        //System.out.println("===================");
        //reArrangeLinkList.print();
    }

    void sumNodes() {

        Node slow = root;
        Node fast = root;
        int countNodes = 0;
        int oddVal = 0;
        boolean isOdd = false;
        int sum = 0;

        // It will identify the half of the linklist
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            countNodes++;
        }

        Node secondHalf = slow;
        Node reverseLinkList = null;

        while (secondHalf != null) {
            Node temp = secondHalf;
            temp.next = reverseLinkList;
            reverseLinkList = temp;
            secondHalf = secondHalf.next;
        }

        slow.next = null;
        Node first = root;

        while (first != null && reverseLinkList != null) {
            sum = Math.max(first.val + reverseLinkList.val, sum);
            first = first.next;
            reverseLinkList = reverseLinkList.next;
        }

        if(reverseLinkList != null)
            sum = Math.max(reverseLinkList.val, sum);

        System.out.println("Sum: " + sum);
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
        addNode(7);
        addNode(3);
        addNode(3);
        addNode(5);
        //addNode(5);
        //addNode(6);
       // addNode(7);
       // addNode(8);
    }
}
