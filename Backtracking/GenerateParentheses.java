import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generator = new GenerateParentheses();
        int n = 3;
        List<String> combinations = generator.generateParenthesis(n);
        System.out.println("All combinations of well-formed parentheses for n = " + n + " are: " + combinations);
        // Output: All combinations of well-formed parentheses for n = 3 are: [((())), (()()), (())(), ()(()), ()()()]
    }
}


//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.