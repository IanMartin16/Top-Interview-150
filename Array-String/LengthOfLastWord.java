public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Trim trailing spaces
        s = s.trim();
        
        // Start from the end of the string
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            // Break the loop when we find a space character
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }
        
        return length;
    }

    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();
        System.out.println(solution.lengthOfLastWord("Hello World"));  // Output: 5
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));  // Output: 4
        System.out.println(solution.lengthOfLastWord("luffy is still joyboy"));  // Output: 6
    }
}


//Given a string s consisting of words and spaces, return the length of the last word in the string.

// A word is a maximal substring consisting of non-space characters only.