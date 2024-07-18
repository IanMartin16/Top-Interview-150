import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map to hold the sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Convert the string to a char array and sort it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            // Add the original string to the corresponding list in the map
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        // Return the list of anagram groups
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result); // Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
    }
}


//Given an array of strings strs, group the anagrams together. 
//You can return the answer in any order.

//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
//typically using all the original letters exactly once.