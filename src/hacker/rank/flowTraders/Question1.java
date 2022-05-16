package hacker.rank.flowTraders;

import java.util.Stack;

public class Question1 {

    public static void main(String[] args) {
        System.out.println(checkBalancedBrackets(")()"));
    }

    static String checkBalancedBrackets(String input){

        Stack<Character> stack = new Stack<>();
        char[] brackets = input.toCharArray();
        char popped;
        String result = "true";

        for(char bracket:brackets){
            if(bracket==')' || bracket=='}' || bracket==']') {

                if(stack.isEmpty()) {
                    result = "false";
                    break;
                }

                popped = stack.pop();

                if(bracket==')') {
                    if (popped!='(') {
                        result = "false";
                        break;
                    }
                } else if(bracket=='}') {
                    if (popped!='{'){
                        result = "false";
                        break;
                    }
                } else if(bracket==']') {
                    if (popped!='['){
                        result = "false";
                        break;
                    }
                }
            } else
                stack.push(bracket);
        }

        if(!stack.empty())
            result = "false";

        return result;
    }
}
