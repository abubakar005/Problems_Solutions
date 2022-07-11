package toptal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinCarsForPeople {

    public static void main(String[] args) {

    }

    public static int minimumNoOfCarsRequired(int []P, int []S)
    {
        int totalNofPassengers = Arrays.stream(P).sum();

        int response = 0;
        List<Integer> seats = Arrays.stream (S).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        for (int seat: seats) {
            if (totalNofPassengers - seat > 0) {
                totalNofPassengers= totalNofPassengers - seat;
                response+= 1;
            } else {
                response+= 1;
                return response;
            }
        }

        return response;
    }
}
