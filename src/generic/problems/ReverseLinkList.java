package generic.problems;

public class ReverseLinkList {

    private Node root;
    private Node current;

    public static void main(String args[]){

        ReverseLinkList reverseLinkList = new ReverseLinkList();
        reverseLinkList.insertNode(1);
        reverseLinkList.insertNode(2);
        reverseLinkList.insertNode(3);
        reverseLinkList.insertNode(4);
        reverseLinkList.insertNode(5);

        reverseLinkList.printList();
        reverseLinkList.reverseList();
        reverseLinkList.printList();
    }

    class Node {
        int value;
        Node next;

        Node (int value) {
           this.value = value;
           this.next = null;
        }
    }

    private void reverseList() {

        if(root == null || root.next == null)
            return;

        Node reverseLinkList = root;
        Node temp = root.next;
        reverseLinkList.next = null;

        while (temp != null) {
            Node node = temp;
            temp = temp.next;

            node.next = reverseLinkList;
            reverseLinkList = node;
        }

        root = reverseLinkList;
    }

    private void insertNode(int value) {

        Node node = new Node(value);

        if(root == null) {
            root = node;
            current = node;
        } else {
            current.next = node;
            current = node;
        }
    }

    private void printList() {

        Node temp = root;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }
}
