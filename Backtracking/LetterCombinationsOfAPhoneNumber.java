import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    // Map digits to corresponding letters on the phone keypad
    private static final String[] KEYPAD_MAPPING = new String[]{
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = KEYPAD_MAPPING[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "23";
        List<String> combinations = solution.letterCombinations(digits);
        System.out.println(combinations); // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}


//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
//Return the answer in any order.

//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.