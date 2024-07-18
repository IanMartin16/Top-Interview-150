public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        
        int sPointer = 0, tPointer = 0;

        while (tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
                if (sPointer == s.length()) {
                    return true;
                }
            }
            tPointer++;
        }

        return sPointer == s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(solution.isSubsequence("axc", "ahbgdc")); // false
        System.out.println(solution.isSubsequence("", "ahbgdc")); // true
        System.out.println(solution.isSubsequence("b", "abc")); // true
        System.out.println(solution.isSubsequence("abc", "")); // false
    }
}


//Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

//A subsequence of a string is a new string that is formed from the original 
//string by deleting some (can be none) of the characters without disturbing 
//the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).