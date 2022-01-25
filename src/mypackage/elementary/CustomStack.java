package mypackage.elementary;

import java.util.Stack;

public class CustomStack {


    public static void main(String []arg)
    {
        result("{}(");
    }

    public static void result(String input) {

        Stack<Character> stack = new Stack<Character>();
        boolean result = true;

        for(int i=0; i<input.length(); i++) {

            if(input.charAt(i) == '(')
                stack.push('(');
            else if(input.charAt(i) == '{')
                stack.push('{');
            else if(input.charAt(i) == '[')
                stack.push('[');

            else if(input.charAt(i) == ')') {
                if(stack.empty() || stack.pop() != '(') {
                    result = false;
                    break;
                }
            }
            else if(input.charAt(i) == '}') {
                if(stack.empty() || stack.pop() != '{') {
                    result = false;
                    break;
                }
            }
            else if(input.charAt(i) == ']') {
                if(stack.empty() || stack.pop() != '[') {
                    result = false;
                    break;
                }
            }
        }

        System.out.println(result);

    }
}
