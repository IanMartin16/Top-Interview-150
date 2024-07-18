import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int result = 0;
        int sign = 1; // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            } else if (currentChar == '+') {
                result += sign * currentNumber;
                currentNumber = 0;
                sign = 1;
            } else if (currentChar == '-') {
                result += sign * currentNumber;
                currentNumber = 0;
                sign = -1;
            } else if (currentChar == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (currentChar == ')') {
                result += sign * currentNumber;
                currentNumber = 0;
                result *= stack.pop(); // this is the sign before the parenthesis
                result += stack.pop(); // this is the result calculated before the parenthesis
            }
        }

        if (currentNumber != 0) {
            result += sign * currentNumber;
        }

        return result;
    }

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        System.out.println(calculator.calculate("1 + 1")); // Output: 2
        System.out.println(calculator.calculate(" 2-1 + 2 ")); // Output: 3
        System.out.println(calculator.calculate("(1+(4+5+2)-3)+(6+8)")); // Output: 23
    }
}


//Given a string s representing a valid expression, implement a basic calculator to evaluate it, 
//and return the result of the evaluation.

//Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().