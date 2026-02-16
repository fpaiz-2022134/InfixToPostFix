package utils;

import ADT.Stack;

public class InfixToPostfix {

    public static String convert(String infix, Stack<Object> stack) {

        StringBuilder postfix = new StringBuilder();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {

            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                number.append(c);
            } else {

                if (number.length() > 0) {
                    postfix.append(number).append(" ");
                    number.setLength(0);
                }

                if (c == '(') {
                    stack.push(c);
                }
                else if (c == ')') {
                    while (!stack.isEmpty() && (Character) stack.peek() != '(')
                        postfix.append(stack.pop()).append(" ");
                    stack.pop();
                }
                else if (c == ' ') {
                    continue;
                }
                else {
                    while (!stack.isEmpty() &&
                            precedence((Character) stack.peek()) >= precedence(c))                        postfix.append(stack.pop()).append(" ");
                    stack.push(c);
                }
            }
        }

        if (number.length() > 0)
            postfix.append(number).append(" ");

        while (!stack.isEmpty())
            postfix.append(stack.pop()).append(" ");

        return postfix.toString().trim();
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}
