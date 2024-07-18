import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        // Ordenar las citas en orden ascendente
        Arrays.sort(citations);
        
        int n = citations.length;
        
        // Iterar desde el final del array hacia el principio
        for (int i = 0; i < n; i++) {
            int h = n - i;  // Número de trabajos restantes
            if (citations[i] >= h) {
                return h;  // Encontramos el h-index
            }
        }
        
        return 0;  // Si no encontramos un h-index válido
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Pruebas de ejemplo
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println(solution.hIndex(citations1));  // 3

        int[] citations2 = {10, 8, 5, 4, 3};
        System.out.println(solution.hIndex(citations2));  // 4

        int[] citations3 = {25, 8, 5, 3, 3};
        System.out.println(solution.hIndex(citations3));  // 3
    }
}


//Given an array of integers citations where citations[i] is the number of citations a researcher 
//received for their ith paper, return the researcher's h-index.

//According to the definition of h-index on Wikipedia: 
//The h-index is defined as the maximum value of h such that the given researcher 
//has published at least h papers that have each been cited at least h times.