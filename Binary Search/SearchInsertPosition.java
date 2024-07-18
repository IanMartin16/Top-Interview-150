public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid; // Si encontramos el target, retornamos su índice.
            } else if (nums[mid] < target) {
                left = mid + 1; // Si el elemento en el medio es menor que el target, buscamos en la mitad derecha.
            } else {
                right = mid - 1; // Si el elemento en el medio es mayor que el target, buscamos en la mitad izquierda.
            }
        }
        
        // Si no encontramos el target, left apuntará al índice donde debería insertarse.
        return left;
    }
}


//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

//You must write an algorithm with O(log n) runtime complexity.