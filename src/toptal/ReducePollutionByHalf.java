package toptal;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ReducePollutionByHalf {

    public static void main(String[] args) {

        ReducePollutionByHalf sol = new ReducePollutionByHalf();

        int[] A = {5, 19, 8, 1};
        int[] A2 = {10, 10};
        int[] A3 = {3, 0, 5};
        int[] A4 = {5, 29, 8, 1};
        System.out.println(sol.solution(A4));
    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        float sumOfPollution = Arrays.stream(A).sum() / 2;
        float filteredPollution = 0;
        int filtersCount = 0;

        for (int i = 0; i < A.length; i++) {

            if(A[i] > 0)
                filtersCount++;

            filteredPollution += (float)A[i] / 2;

            if (filteredPollution >= sumOfPollution)
                break;
        }

        return filtersCount;
    }

    /** Final solution */
    public int solution(int[] A) {
        // write your code in Java SE 8
        float sumOfPollution =  (float) Arrays.stream(A).sum();
        float halfOfPollution =  sumOfPollution/ 2;
        int filtersCount = 0;

        PriorityQueue<Float> queue = new PriorityQueue<>((a, b) -> {
            if(b > a) return 1;
            if(a > b) return -1;
            return 0;
        });

        for(int a: A)
            if(a > 0)
                queue.add((float)a);

        while (true) {
            float poll = queue.poll()/2;
            filtersCount++;
            sumOfPollution -= poll;

            if (sumOfPollution <= halfOfPollution)
                break;

            queue.add(poll);
        }

        return filtersCount;
    }
}
