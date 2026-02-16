package utils;

import ADT.Stack;

public class PostfixEvaluator {

    public static int evaluate(String postfix, Stack<Object> stack) {

        String[] tokens = postfix.split(" ");

        for (String token : tokens) {

            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = (Integer) stack.pop();
                int a = (Integer) stack.pop();

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }

        return (int) stack.pop();
    }
}