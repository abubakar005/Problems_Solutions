package pluang.interviw;

import java.util.Arrays;

public class StockValues_Pluang {

    public static void main(String args[]){

        int[] prices = {4, 2, 3, 3, 3, 8, 8};
        // 1 1 2 3 4 6 7

        int[] res = getStockValues(prices);
        System.out.println("Result: " + Arrays.toString(res));
    }

    public static int[] getStockValues(int[] prices) {

        int[] response = new int[prices.length];
        int count = 0;

        // Assigning value for the first day
        response[0] = 1;

        for(int i=1; i< prices.length; i++) {

            count = 0;

            for(int j=i; j>=0; j--) {
                if(prices[j] > prices[i]) {
                    break;
                } else {
                    count++;
                }
            }

            response[i] = count;
        }

        return response;
    }
}
