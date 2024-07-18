public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;  // Almacena el índice máximo que se puede alcanzar
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {  // Si el índice actual es mayor que el máximo alcance, no se puede llegar más lejos
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);  // Actualiza el máximo alcance
            if (maxReach >= nums.length - 1) {  // Si se puede alcanzar o superar el último índice, retorna true
                return true;
            }
        }
        return false;  // Si se recorre todo el array y no se puede alcanzar el último índice, retorna false
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Pruebas de ejemplo
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(nums1));  // true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums2));  // false
    }
}

//You are given an integer array nums. 
//You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

//Return true if you can reach the last index, or false otherwise.