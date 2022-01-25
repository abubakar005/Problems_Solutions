package Merge.two.sorted.linked.lists;

import java.io.BufferedWriter;
import java.io.IOException;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {

        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }



    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {

        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }

        System.out.println();
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode mergedLinkList = null;
        SinglyLinkedListNode currentNode = null;

        if(head1.data <= head2.data) {
            mergedLinkList = new SinglyLinkedListNode(head1.data);
            currentNode = mergedLinkList;
            head1 = head1.next;

        } else {
            mergedLinkList = new SinglyLinkedListNode(head2.data);
            currentNode = mergedLinkList;
            head2 = head2.next;
        }

        while(head1 != null || head2 != null) {

            if(head1 == null) {
                currentNode.next = head2;
                break;
             //   currentNode = currentNode.next;
             //   head2 = head2.next;
            } else if(head2 == null) {
                currentNode.next = head1;
                break;
               // currentNode = currentNode.next;
               // head1 = head1.next;
            } else if(head1.data <= head2.data) {
                currentNode.next = head1;
                currentNode = currentNode.next;
                head1 = head1.next;
            } else if(head1.data > head2.data) {
                currentNode.next = head2;
                currentNode = currentNode.next;
                head2 = head2.next;
            }
        }

        return mergedLinkList;
    }

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist1 = new SinglyLinkedList();
        SinglyLinkedList llist2 = new SinglyLinkedList();

        int[] list1Elements = {1, 2, 3, 55};
        int[] list2Elements = {3, 4, 10, 15, 20, 25, 50};

        for (int i = 0; i < list1Elements.length; i++)
            llist1.insertNode(list1Elements[i]);

        for (int i = 0; i < list2Elements.length; i++)
            llist2.insertNode(list2Elements[i]);

        printSinglyLinkedList(llist1.head, " ");
        printSinglyLinkedList(llist2.head, " ");

        System.out.println("**************************");
        SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);
        printSinglyLinkedList(llist3, " ");
        System.out.println("**************************");
    }
}
