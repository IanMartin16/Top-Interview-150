public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int hLength = haystack.length();
        int nLength = needle.length();
        
        // Edge case: needle is empty
        if (nLength == 0) {
            return 0;
        }
        
        // Iterate through haystack
        for (int i = 0; i <= hLength - nLength; i++) {
            // Check if substring starting from i matches needle
            if (haystack.substring(i, i + nLength).equals(needle)) {
                return i;
            }
        }
        
        // No match found
        return -1;
    }
}


//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, 
//or -1 if needle is not part of haystack.