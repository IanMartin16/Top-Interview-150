public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        
        // Buscar el inicio del rango
        result[0] = findFirstOccurrence(nums, target);
        if (result[0] == -1) {
            // Si no se encontró el target, retornar [-1, -1]
            return result;
        }
        
        // Buscar el fin del rango
        result[1] = findLastOccurrence(nums, target);
        
        return result;
    }
    
    private int findFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstOccurrence = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) {
                right = mid - 1; // Seguir buscando a la izquierda
                if (nums[mid] == target) {
                    firstOccurrence = mid; // Actualizar la primera ocurrencia
                }
            } else {
                left = mid + 1; // Descartar la mitad izquierda
            }
        }
        
        return firstOccurrence;
    }
    
    private int findLastOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastOccurrence = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] <= target) {
                left = mid + 1; // Seguir buscando a la derecha
                if (nums[mid] == target) {
                    lastOccurrence = mid; // Actualizar la última ocurrencia
                }
            } else {
                right = mid - 1; // Descartar la mitad derecha
            }
        }
        
        return lastOccurrence;
    }
}


//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

//If target is not found in the array, return [-1, -1].

//You must write an algorithm with O(log n) runtime complexity.