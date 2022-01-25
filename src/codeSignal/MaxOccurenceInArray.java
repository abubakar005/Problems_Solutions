package codeSignal;

import java.util.*;

/**
 * Problem Statement: return the number with max occurrences in the given array
 *
 * If there are multiple number , then return in ascending order
 *
 *
 * */

public class MaxOccurenceInArray {

    public static void main(String args[]){

        int[] array = {25, 5, 3, 32, 21, 34};
        System.out.println(Arrays.toString(solution(array)));
    }

    static int[] solution(int[] a) {

        PriorityQueue<Node> pQueue = new PriorityQueue();
        List<Integer> resp = new ArrayList<>();
        Map<Integer, Node> map = new HashMap();

        for(int i=0; i<a.length; i++) {

            if(a[i] > 9) {
                put(map, pQueue, a[i]%10);
                put(map, pQueue, a[i]/10);
            } else {
                put(map, pQueue, a[i]);
            }
        }

        boolean traverse = true;
        int counterValue = -1;

        while(traverse) {

            Node node = pQueue.remove();

            if(counterValue == -1)
                counterValue = node.getCounter();

            if(counterValue != node.getCounter())
                traverse = false;
            else
                resp.add(node.getKey());
        }

        int[] arr = resp.stream().mapToInt(i -> i).toArray();

        return arr;
    }

    static void put(Map<Integer, Node> map, PriorityQueue<Node> pQueue, int key) {

        Node node = null;

        if(map.containsKey(key)) {
            node = map.get(key);
            node.setCounter(node.getCounter()+1);
            pQueue.remove(node);
        } else {
            node = new Node(key, 1);
        }

        map.put(key, node);
        pQueue.add(node);
    }

    static class Node implements Comparable<Node> {

        int key;
        int counter;

        public Node(int key, int counter){
            this.key = key;
            this.counter = counter;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key &&
                    counter == node.counter;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, counter);
        }

        @Override
        public String toString() {
            return "node{" +
                    "key=" + key +
                    ", counter=" + counter +
                    '}';
        }

        @Override
        public int compareTo(Node node) {
            if(this.getCounter() < node.getCounter())
                return 1;
            if(this.getCounter() == node.getCounter())
                if(this.getKey() > node.getKey())
                    return 1;

            return -1;
        }
    }

}
