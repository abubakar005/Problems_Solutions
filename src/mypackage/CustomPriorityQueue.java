package mypackage;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class CustomPriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<Integer> pQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1<o2) {
                return 1;
            } else if (o1==o2) {
                return 0;
            } else {
                return -1;
            }
        });

        PriorityQueue<Integer> pQueue2 = new PriorityQueue<>();

        pQueue.add(15);
        pQueue.add(20);
        pQueue.add(1);
        pQueue.add(2);
        pQueue.add(3);
        pQueue.add(4);
        pQueue.add(5);
        pQueue.add(6);
        pQueue.add(7);
        pQueue.add(8);
        pQueue.add(9);
        pQueue.add(10);


        pQueue2.add(15);
        pQueue2.add(20);
        pQueue2.add(1);
        pQueue2.add(2);
        pQueue2.add(3);
        pQueue2.add(4);
        pQueue2.add(5);
        pQueue2.add(6);
        pQueue2.add(7);
        pQueue2.add(8);
        pQueue2.add(9);
        pQueue2.add(10);

     //   pQueue.add(15);

        Iterator iterator = pQueue.iterator();
        System.out.println("peek: " + pQueue.peek());

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
        Iterator iterator2 = pQueue2.iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }

        System.out.println();
        while (!pQueue.isEmpty()) {
            System.out.println("Remove: " + pQueue.remove());
        }

        System.out.println();
        while (!pQueue2.isEmpty()) {
            System.out.println("Remove 2: " + pQueue2.remove());
        }
     //   System.out.println("peek: " + pQueue.peek());

     //   System.out.println("poll: " + pQueue.poll());

     //   System.out.println("peek: " + pQueue.peek());
    }


}
