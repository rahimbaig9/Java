import java.util.Stack;
public class BalancedParentheses {
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            } else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing parenthesis
                }
                char top = stack.pop();
                if (currentChar == ')' && top != '(' || currentChar == ']' && top != '['
                        || currentChar == '}' && top != '{') {
                    return false; // Mismatched parentheses
                }
            }
        }

        return stack.isEmpty(); // Stack should be empty for balanced parentheses
    }

    public static void main(String[] args) {
        String input = "{[()]}";
        boolean result = isBalanced(input);
        if (result) {
            System.out.println("The input contains balanced parentheses.");
        } else {
            System.out.println("The input does not contain balanced parentheses.");
        }
    }
}
