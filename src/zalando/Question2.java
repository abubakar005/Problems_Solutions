package zalando;

import java.util.Arrays;

public class Question2 {

    public static void main(String[] args) {

        int[] A = new int[11];

        A[0]  = 1;
        A[1]  = 3;
        A[2]  = 2;
        A[3]  = 1;
        A[4]  = 2;
        A[5]  = 1;
        A[6]  = 5;
        A[7]  = 3;
        A[8]  = 3;
        A[9]  = 4;
        A[10] = 2;

        int[] A2 = new int[2];
        A2[0] = 5;
        A2[1] = 8;

        int[] A3 = new int[4];
        A3[0] = 1;
        A3[1] = 1;
        A3[2] = 1;
        A3[3] = 1;

        System.out.println(solution(A));
    }

    public static int solution(int[] A) {

        int maxAllowed = 1000000000;
        int bushStrokes = 0;
        int maxBuilding = Arrays.stream(A).max().getAsInt();
        int length = A.length;

        for (int line = 1; line <= maxBuilding; line++) {

            int iter = 0;

            while (iter < length) {

                if (A[iter] < line)
                    if (iter != 0 && A[iter - 1] >= line) {
                        bushStrokes++;

                        if(bushStrokes >= maxAllowed)
                            return -1;

                        iter++;
                        continue;
                    }

                iter++;
            }

            if (A[iter - 1] >= line)
                bushStrokes++;
        }
        return bushStrokes;
    }
}
