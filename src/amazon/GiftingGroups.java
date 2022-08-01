package amazon;

import java.util.Arrays;
import java.util.List;

public class GiftingGroups {

    public static void main(String[] args) {

        String given1[] = {"110", "112", "011"}; //2
        String given2[] = {"1100", "1101", "0010", "0010", "0001"}; //2
        String given3[] = {"110", "111", "011"}; //1

        String arr1[] = {"1100", "1110", "0110", "0001"};//2
        String arr2[] = {"10000", "01000", "00100", "00010", "00001"};//5
        String arr3[] = {"1100", "1101", "0010", "0010", "0001"};//2
        String arr4[] = {"1100", "1101", "0010", "0010", "0001"};//2
        String arr5[] = {"11100", "11001", "10100", "00011", "01011"};//1
        String arr6[] = {"11100", "11100", "11100", "00011", "00011"};//2
        String arr7[] = {"10100", "01010", "10100", "01010", "00001"};//3

        List<String> arrayList = Arrays.asList(given3);
        int result = findSubscriberGroups(arrayList);
        System.out.println(result);

    }


    public static int findSubscriberGroups(List<String> arrayList) {

        if (null == arrayList || arrayList.isEmpty())
            return 0;

        int count = 0;
        int[][] isConnected = new int[arrayList.size()][arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {

            String row = arrayList.get(i);

            for (int j = 0; j < row.length(); j++) {

                // isConnected[i][j] = (row.charAt(j) - '0'); //Working
                isConnected[i][j] = Integer.parseInt(Character.toString(row.charAt(j)));
            }

        }

        boolean[] isReached = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!isReached[i]) {
                alignedGroups(isConnected, isReached, i);
                count++;

            }

        }
        return count;

    }

    private static void alignedGroups(int[][] isConnected, boolean[] isReached, int v) {
        isReached[v] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[v][i] == 1 && !isReached[i])
                alignedGroups(isConnected, isReached, i);
        }

    }
}
