class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineCounts = new int[26]; // Assuming only lowercase English letters

        // Count each letter in the magazine
        for (char c : magazine.toCharArray()) {
            magazineCounts[c - 'a']++;
        }

        // Count each letter in the ransom note and check against magazine counts
        for (char c : ransomNote.toCharArray()) {
            if (magazineCounts[c - 'a'] == 0) {
                return false; // If any letter is not available, return false
            }
            magazineCounts[c - 'a']--; // Use one occurrence of the letter
        }

        return true; // All letters are available
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(solution.canConstruct(ransomNote, magazine)); // Output: false

        ransomNote = "aa";
        magazine = "ab";
        System.out.println(solution.canConstruct(ransomNote, magazine)); // Output: false

        ransomNote = "aa";
        magazine = "aab";
        System.out.println(solution.canConstruct(ransomNote, magazine)); // Output: true
    }
}


//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

//Each letter in magazine can only be used once in ransomNote.