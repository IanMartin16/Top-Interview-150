public class ReverseWordsInAString {

    public String reverseWords(String s) {
        // Split the string by spaces to get individual words
        String[] words = s.trim().split("\\s+");

        // Use StringBuilder to build the result
        StringBuilder reversed = new StringBuilder();

        // Traverse the words array in reverse order and append to StringBuilder
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        ReverseWords solution = new ReverseWords();

        String s1 = "the sky is blue";
        System.out.println(solution.reverseWords(s1));  // Output: "blue is sky the"

        String s2 = "  hello world  ";
        System.out.println(solution.reverseWords(s2));  // Output: "world hello"

        String s3 = "a good   example";
        System.out.println(solution.reverseWords(s3));  // Output: "example good a"
    }
}


//Given an input string s, reverse the order of the words.

//A word is defined as a sequence of non-space characters. 
//The words in s will be separated by at least one space.

//Return a string of the words in reverse order concatenated by a single space.

//Note that s may contain leading or trailing spaces or multiple spaces between two words. 
//The returned string should only have a single space separating the words. Do not include any extra spaces.