import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            int lineStart = index;
            int lineLength = words[index].length();
            index++;

            // Add words to the line until it reaches maxWidth
            while (index < n && lineLength + words[index].length() + (index - lineStart) <= maxWidth) {
                lineLength += words[index].length();
                index++;
            }

            StringBuilder sb = new StringBuilder();
            int slots = index - lineStart - 1;

            // If last line or only one word in the line
            if (index == n || slots == 0) {
                for (int i = lineStart; i < index; i++) {
                    sb.append(words[i]);
                    if (i < index - 1) {
                        sb.append(" ");
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int totalSpaces = maxWidth - lineLength;
                int spacesPerSlot = totalSpaces / slots;
                int extraSpaces = totalSpaces % slots;

                for (int i = lineStart; i < index; i++) {
                    sb.append(words[i]);
                    if (i < index - 1) {
                        int spacesToApply = spacesPerSlot + (i - lineStart < extraSpaces ? 1 : 0);
                        for (int j = 0; j < spacesToApply; j++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        System.out.println(solution.fullJustify(words1, maxWidth1));
        
        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth2 = 16;
        System.out.println(solution.fullJustify(words2, maxWidth2));
        
        String[] words3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth3 = 20;
        System.out.println(solution.fullJustify(words3, maxWidth3));
    }
}


//Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully 
//(left and right) justified.

//You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
//Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

//Extra spaces between words should be distributed as evenly as possible. 
//If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces 
//than the slots on the right.

//For the last line of text, it should be left-justified, and no extra space is inserted between words.

//Note:

//A word is defined as a character sequence consisting of non-space characters only.
//Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//The input array words contains at least one word.