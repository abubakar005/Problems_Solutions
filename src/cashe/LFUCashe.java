package cashe;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class LFUCashe {

    public static void main(String args[]){

        LFU cash = new LFU(5);

        cash.add(1, 5);
        cash.add(2, 6);

        cash.get(3);

        cash.get(1);
        cash.get(1);

        cash.pQueue.stream().forEach(System.out :: print);

        PriorityQueue<Node> pQueue = new PriorityQueue();

        Node node = new Node(1, 1, 1);
        Node node2 = new Node(2, 2, 2);
        Node node3 = new Node(3, 1, 3);
        Node node4 = new Node(4, 1, 4);

        pQueue.add(node);
        pQueue.add(node2);
        pQueue.add(node3);
        pQueue.add(node4);

        //pQueue.stream().forEach(System.out :: print);
        pQueue.poll();
        pQueue.poll();
        //System.out.println();
        //pQueue.stream().forEach(System.out :: print);

    }

    static class LFU {

        int capacity;

        PriorityQueue<Node> pQueue = new PriorityQueue();
        Map<Integer, Node> map =  new HashMap();

        public LFU (int capacity){
            this.capacity = capacity;
        }

        public void add(int key, int value) {

            if(map.containsKey(key)) {
                System.out.println("Element key already exists");
                return;
            }

            if(map.size() == this.capacity) {
                delete();
            }

            Node node = new Node(key, value);
            map.put(key, node);
            pQueue.add(node);
        }

        public Node get(int key) {

            if(!map.containsKey(key)) {
                System.out.println("Element key does not exist in the cash");
                return null;
            }

            Node node = map.get(key);
            pQueue.remove(node);
            node.setCount(node.getCount()+1);

            map.put(key, node);
            pQueue.add(node);

            return node;
        }

        private void delete() {

            Node node = pQueue.poll();
            map.remove(node);
        }
    }


    static class Node implements Comparable<Node> {

        int key;
        int value;
        int count;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.count = 1;
        }

        public Node(int key, int value, int count){
            this.key = key;
            this.value = value;
            this.count = count;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key &&
                    value == node.value &&
                    count == node.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", count=" + count +
                    '}';
        }

        @Override
        public int compareTo(Node node) {

            if(this.getCount() > node.getCount())
                return 1;
            else if(this.getCount() == node.getCount())
                return 0;

            return -1;
        }
    }
}
