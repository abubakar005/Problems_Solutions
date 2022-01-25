package hackerrank.senior.java.backend.developer.test;

import java.util.*;

/**
 *  Problem Statement:
 *  HackerRank Link: https://www.hackerrank.com/contests/hackerrank-senior-java-backend-developer-test/challenges/java-stack
 *
 * */

class Solution{

    public static void main(String []arg) {
        Scanner sc = new Scanner(System.in);

        Stack<String> stack = new Stack<String>();

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            //   System.out.println("=====" + input);
            result(input);
        }
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

        if(result && stack.empty())
            System.out.println(result);
        else
            System.out.println(false);

    }
}

