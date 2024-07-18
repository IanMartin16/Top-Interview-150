import java.util.HashMap;
import java.util.Map;

class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        // If the length of the pattern and words do not match, return false
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check the mapping from char to word
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            // Check the mapping from word to char
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        System.out.println(solution.wordPattern(pattern1, s1)); // Output: true

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println(solution.wordPattern(pattern2, s2)); // Output: false

        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        System.out.println(solution.wordPattern(pattern3, s3)); // Output: false

        String pattern4 = "abba";
        String s4 = "dog dog dog dog";
        System.out.println(solution.wordPattern(pattern4, s4)); // Output: false
    }
}


//Given a pattern and a string s, find if s follows the same pattern.

//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.