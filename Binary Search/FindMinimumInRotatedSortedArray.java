public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            // Si el segmento está ordenado, el mínimo es nums[left]
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            
            int mid = left + (right - left) / 2;
            
            // Verificar si el punto medio es el mínimo
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            
            // Decidir en qué mitad continuar
            if (nums[mid] >= nums[left]) {
                left = mid + 1; // El mínimo está en la mitad derecha
            } else {
                right = mid - 1; // El mínimo está en la mitad izquierda
            }
        }
        
        // Si left == right, hemos encontrado el mínimo
        return nums[left];
    }
}


//Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

//[4,5,6,7,0,1,2] if it was rotated 4 times.
//[0,1,2,4,5,6,7] if it was rotated 7 times.
//Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

//Given the sorted rotated array nums of unique elements, return the minimum element of this array.

//You must write an algorithm that runs in O(log n) time.