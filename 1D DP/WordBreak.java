import java.util.*;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string can always be segmented

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
    public static void main(String[] args) {
        String s = "leetcode"; // Example input
        List<String> wordDict = Arrays.asList("leet", "code"); // Example dictionary
        boolean result = wordBreak(s, wordDict);
        System.out.println("Can the string be segmented? " + result); // Output: true
    }
}


//Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

//Note that the same word in the dictionary may be reused multiple times in the segmentation.