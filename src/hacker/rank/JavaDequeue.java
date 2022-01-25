package hacker.rank;

import java.util.*;

public class JavaDequeue {

    public static void main(String[] args) {

        // 6 3
        //5 2 5 2 5 2
        int sizeOfSubarray = 3;

        Set<Integer> unique = new HashSet<>();
        int counter = 0;
        int result = 0;

        Deque<Integer> deque = new LinkedList<>();
        deque.add(5);
        deque.add(3);
        deque.add(5);
        deque.add(2);
        deque.add(3);
        deque.add(2);

        deque.stream().forEach(e -> System.out.println("word: " + e));

        while(deque.size() >= sizeOfSubarray+1) {

            unique.clear();
            counter = sizeOfSubarray;

            Iterator<Integer> iterator = deque.iterator();
            Iterator<Integer> descendingIterator = deque.descendingIterator();

            while (iterator.hasNext()) {
                unique.add(iterator.next());
                counter--;

                if(counter == 0)
                    break;
            }

            if(unique.size() > result)
                result = unique.size();

            unique.clear();
            counter = sizeOfSubarray;

            while (descendingIterator.hasNext()) {
                unique.add(descendingIterator.next());
                counter--;

                if(counter == 0)
                    break;
            }

            if(unique.size() > result)
                result = unique.size();

            System.out.println("Removed first element: " + deque.removeFirst());
            System.out.println("Removed last element: " + deque.removeLast());

            /*deque.stream().forEach(e -> {

                System.out.println("word: " + e);
                }
            );*/

        }

        System.out.println("Result: " + result);
    }

/*    // optimised solution
    public class test {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            final Deque<Integer> deque = new ArrayDeque<Integer>();
            final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            final int n = in.nextInt();
            final int m = in.nextInt();

            int res = 0;
            for (int i = 0; i < n; i++) {
                final int num = in.nextInt();
                deque.addLast(num);
                if (map.containsKey(num)) {
                    map.put(num, map.get(num).intValue() + 1);
                } else {
                    map.put(num, 1);
                }

                if (deque.size() == m + 1) {
                    final int key = deque.removeFirst();
                    final int v = map.get(key);
                    if (v == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, v - 1);
                    }
                }

                final int cnt = map.size();
                if (cnt > res) { res = cnt; }
            }
            System.out.println(res);
        }
    }
    */
}
