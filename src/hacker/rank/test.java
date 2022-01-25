package hacker.rank;

import java.util.*;

public class test {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();

        System.out.println("Enter size of array: ");
        int n = in.nextInt();
        System.out.println("Enter size of sub-array: ");
        int m = in.nextInt();

        System.out.println("Before looping array elements");
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
        }

        System.out.println("After looping array elements");

        Set<Integer> unique = new HashSet<>();
        int counter = m;
        int result = 0;

        while(deque.size() >= m) {

            unique.clear();
            counter = m;

            Iterator<Integer> iterator = deque.iterator();

            while (iterator.hasNext()) {
                unique.add(iterator.next());
                counter--;

                if(counter == 0)
                    break;
            }

            if(unique.size() > result)
                result = unique.size();
        }

        System.out.println(result);
    }
}

