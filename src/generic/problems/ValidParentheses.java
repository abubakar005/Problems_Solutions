package generic.problems;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String args[]){

        System.out.println(isValid("(){}[]"));
    }

    public static boolean isValid(String s) {

        s.split("/,");

        boolean result = false;
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();

        for(int i=0; i<array.length; i++) {

            if(array[i] == '(' || array[i] == '{' || array[i] == '[')
                stack.push(array[i]);

            else if(array[i] == ')') {
                if(!stack.isEmpty() && stack.pop() != '(')
                    return false;
            } else if(array[i] == '}') {
                if(!stack.isEmpty() && stack.pop() != '{')
                    return false;
            } else if(array[i] == ']')
                if(!stack.isEmpty() && stack.pop() != '[')
                    return false;
        }

        return stack.isEmpty();
    }
}
