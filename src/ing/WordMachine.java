package ing;

import java.util.Stack;
import java.util.stream.Stream;

public class WordMachine {

    public static void main(String[] args) {

        WordMachine wordMachine = new WordMachine();

        String s = "4 5 6 - 7 +";
        String s1 = "13 DUP 4 POP 5 DUP + DUP + -";
        String s2 = "5 6 + -";
        String s3 = "3 DUP 5 - -";
        String s4 = "1048575 DUP +";

        System.out.println(wordMachine.solution(s2));
        //getResponseUnsafe(s);
    }

    static void getResponseUnsafe(String input) {
        Stream.iterate(input, str -> str.substring(0, str.lastIndexOf(' ')))
                .forEach(System.out::println);
    }

    public int solution(String s) {

        Stack<Integer> stack = new Stack<>();
        int maxValue = 1048575;
        int num1;
        int num2;

        for(String operation: s.split(" ")) {

            switch (operation) {
                case "POP":
                {
                    if(stack.isEmpty())
                        return -1;

                    stack.pop();
                    break;
                }
                case "DUP":
                {
                    if(stack.isEmpty())
                        return -1;

                    stack.push(stack.peek());
                    break;
                }
                case "+":
                {
                    if(stack.size() < 2)
                        return -1;

                    num1 = stack.pop();
                    num2 = stack.pop();

                    if(num1+num2 > maxValue)
                        return -1;

                    stack.push(num1+num2);
                    break;
                }
                case "-":
                {
                    if(stack.size() < 2)
                        return -1;

                    num1 = stack.pop();
                    num2 = stack.pop();

                    if(num1-num2 < 0)
                        return -1;

                    stack.push(num1-num2);
                    break;
                }
                default :
                    stack.push(Integer.valueOf(operation));
            }
        }

        if(stack.isEmpty())
            return -1;

        return stack.pop();
    }

    public int solution2(String s) {

        Stack<Integer> stack = new Stack<>();
        int maxValue = 1048575;
        int num1;
        int num2;

        String[] operations = s.split(" ");

        for(String operation: operations) {

            if(operation.equals("POP")) {
                if(stack.isEmpty())
                    return -1;

                stack.pop();
            } else if(operation.equals("DUP")) {
                if(stack.isEmpty())
                    return -1;

                stack.push(stack.peek());
            } else if(operation.equals("+")) {
                if(stack.size() < 2)
                    return -1;

                num1 = stack.pop();
                num2 = stack.pop();

                if(num1+num2 > maxValue)
                    return -1;

                stack.push(num1+num2);
            } else if(operation.equals("-")) {
                if(stack.size() < 2)
                    return -1;

                num1 = stack.pop();
                num2 = stack.pop();

                if(num1-num2 < 0)
                    return -1;

                stack.push(num1-num2);
            } else
                stack.push(Integer.valueOf(operation));
        }

        if(stack.isEmpty())
            return -1;

        return stack.pop();
    }
}
