import java.util.HashSet;
import java.util.Set;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // Crear un conjunto para rastrear caracteres únicos
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        // Recorrer la cadena con el puntero derecho
        for (int right = 0; right < s.length(); right++) {
            // Si el conjunto ya contiene el carácter, mover el puntero izquierdo
            // hasta que no haya duplicados en el conjunto
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Añadir el carácter actual al conjunto
            set.add(s.charAt(right));

            // Calcular la longitud máxima de la subcadena sin duplicados
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Casos de prueba
        String s1 = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s1)); // 3 ("abc")

        String s2 = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s2)); // 1 ("b")

        String s3 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s3)); // 3 ("wke")

        String s4 = "";
        System.out.println(solution.lengthOfLongestSubstring(s4)); // 0
    }
}


//Given a string s, find the length of the longest substring without repeating characters.