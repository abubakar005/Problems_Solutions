package jpMorgan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinStack {

    Node head;

    public static void main(String[] args) {

        MinStack minStack = new MinStack();


        // Pushing elements
        minStack.push(3);
        System.out.println(minStack.peak());
        minStack.push(5);
        System.out.println(minStack.peak());
        minStack.push(1);
        System.out.println(minStack.peak());

        System.out.println(minStack.pop());
        System.out.println(minStack.peak());

        List<Node> list = minStack.getNodesList();
        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));

    }

    class Node implements Comparable<Node>{
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public int compareTo(Node o) {
            if(this.value > o.value)
                return 1;
            else if(this.value < o.value)
                return -1;
            else return 0;
        }
    }

    public void push(int value) {

        if(head == null) {
            head = new Node(value);
        } else {

            Node node = new Node(value);
            node.next = head;
            head = node;
        }
    }

    public int pop() {

        //if(head == null)
        //    throw new Exception("Stack is empty!");

        Node poped = head;
        head = head.next;
        return poped.value;
    }

    public int peak() {
        return head.value;
    }

    public List<Node> getNodesList() {

        Node temp = head;
        List<Node> list = new ArrayList<>();

        while (temp != null){
            list.add(temp);
            temp = temp.next;
        }

        return list;
    }


}
