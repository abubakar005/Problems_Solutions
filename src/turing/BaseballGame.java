package turing;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public static void main(String args[]){

        String[] ops = {"1"};
       // String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(callPoints(ops));
    }

    public static int callPoints(String[] ops) {

        int result = 0;
        List<Integer> list = new ArrayList<>();
        int index = -1;
        int number;

        for(String str: ops){

            if(str.equals("D")) {
                number = list.get(index)*2;
                list.add(number);
                result += number;
                index++;
            } else if(str.equals("C")) {
                number = list.remove(index);
                result -= number;
                index--;
            } else if(str.equals("+")) {
                number = list.get(index)+list.get(index-1);
                list.add(number);
                result += number;
                index++;
            } else {
                number = Integer.parseInt(str);
                list.add(number);
                result += number;
                index++;
            }
        }
        return result;
    }
}
