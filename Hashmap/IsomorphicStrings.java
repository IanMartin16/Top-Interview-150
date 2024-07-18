import java.util.HashMap;
import java.util.Map;

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check the mapping from s to t
            if (mapS.containsKey(charS)) {
                if (mapS.get(charS) != charT) {
                    return false;
                }
            } else {
                mapS.put(charS, charT);
            }

            // Check the mapping from t to s
            if (mapT.containsKey(charT)) {
                if (mapT.get(charT) != charS) {
                    return false;
                }
            } else {
                mapT.put(charT, charS);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        String s1 = "egg";
        String t1 = "add";
        System.out.println(solution.isIsomorphic(s1, t1)); // Output: true

        String s2 = "foo";
        String t2 = "bar";
        System.out.println(solution.isIsomorphic(s2, t2)); // Output: false

        String s3 = "paper";
        String t3 = "title";
        System.out.println(solution.isIsomorphic(s3, t3)); // Output: true
    }
}


//Given two strings s and t, determine if they are isomorphic.

//Two strings s and t are isomorphic if the characters in s can be replaced to get t.

//All occurrences of a character must be replaced with another character while preserving 
//the order of characters. No two characters may map to the same character, but a character may map to itself.