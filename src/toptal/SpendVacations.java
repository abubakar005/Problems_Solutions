package toptal;

import java.util.ArrayList;
import java.util.List;

public class SpendVacations {

    public static void main(String[] args) {

        int[] arr = {7, 3, 7, 3, 1, 3, 4, 1};
        int[] arr2 = {2, 1, 1, 3, 2, 1, 1, 3};
        System.out.println("Result: " + solution(arr2));

    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        List<Integer> l = new ArrayList<Integer>();
        List<Integer> s = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++) {
            if (l.indexOf(A[i]) == -1) {
                l.add((Integer)A[i]);
            } else if (l.indexOf(A[i]) == 0 ){
                l.remove((Integer)A[i]);
                l.add((Integer)A[i]);
            }else {
                l.add((Integer)A[i]);
            }
        }

        for(int i = l.size()-1; i >= 0; i--){
            if (s.indexOf(l.get(i)) == -1) {
                s.add(l.get(i));
            } else if (s.indexOf(l.get(i)) == 0 ){
                s.remove(l.get(i));
                s.add(l.get(i));
            }else {
                s.add(l.get(i));
            }
        }

        for(Integer e : s){
            System.out.println(e);
        }

        return s.size();
    }
}
