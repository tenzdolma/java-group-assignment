package com.iims.util;

import java.util.Stack;

public class BalancedBracket {

    /**
     * If the current character is an opening bracket, push it to the stack. If the current character is a closing bracket,
     * pop from the stack and check if the popped character is a matching pair. If all brackets are matched, return true
     *
     * @param expression a string of characters.
     * @return The return value is the number of times the character c appears in the string s.
     */
    public static String isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[') {
                stack.push(expression.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return "No";
                } else {
                    char pop_val = stack.pop();
                    if (expression.charAt(i) == ')' && pop_val != '(') {
                        return "No";
                    } else if (expression.charAt(i) == '}' && pop_val != '{') {
                        return "No";
                    } else if (expression.charAt(i) == ']' && pop_val != '[') {
                        return "No";
                    }
                }
            }
        }

        return stack.isEmpty() ? "Yes" : "No";
    }

}
