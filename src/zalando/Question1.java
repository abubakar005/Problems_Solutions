package zalando;

public class Question1 {

    /*int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }*/

    // updated with missing lines
    static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {   // length is 0
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if(A[m] == X) return m;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m+1;
            }
        }
        if (A[l] == X) {
            return l;
        } else if (A[r] == X) return r;

        return -1;
    }

}
