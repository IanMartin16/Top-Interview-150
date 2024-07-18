public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid; // Encontramos el target, retornamos su índice.
            }
            
            // Caso 1: El segmento izquierdo es ordenado correctamente
            if (nums[left] <= nums[mid]) {
                // Verificar si el target está en el segmento izquierdo
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Búsqueda en el segmento izquierdo
                } else {
                    left = mid + 1; // Búsqueda en el segmento derecho
                }
            }
            // Caso 2: El segmento derecho es ordenado correctamente
            else {
                // Verificar si el target está en el segmento derecho
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Búsqueda en el segmento derecho
                } else {
                    right = mid - 1; // Búsqueda en el segmento izquierdo
                }
            }
        }
        
        return -1; // No se encontró el target
    }
}


//There is an integer array nums sorted in ascending order (with distinct values).

//Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

//You must write an algorithm with O(log n) runtime complexity.