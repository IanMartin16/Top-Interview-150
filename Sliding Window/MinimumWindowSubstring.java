import java.util.*;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        // Frequency array for characters in t
        int[] expected = new int[128]; // Assuming ASCII characters
        
        for (char c : t.toCharArray()) {
            expected[c]++;
        }
        
        int left = 0;
        int right = 0;
        int required = t.length(); // Total characters in t to match
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        // Sliding window variables
        while (right < s.length()) {
            // Expand window by including s[right]
            if (expected[s.charAt(right)] > 0) {
                required--;
            }
            expected[s.charAt(right)]--;
            right++;
            
            // Contract window from the left until valid
            while (required == 0) {
                // Update minimum window length and start position
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                
                // Shrink window from left
                expected[s.charAt(left)]++;
                if (expected[s.charAt(left)] > 0) {
                    required++;
                }
                left++;
            }
        }
        
        // If minLen is still Integer.MAX_VALUE, no valid window found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}


//Given two strings s and t of lengths m and n respectively, return the minimum window 
//substring
// of s such that every character in t (including duplicates) is included in the window. 
//If there is no such substring, return the empty string "".

//The testcases will be generated such that the answer is unique.