public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0; // Si el array tiene solo un elemento, ya estamos en el último índice
        }

        int jumps = 0;  // Número de saltos necesarios
        int currentEnd = 0;  // El final del rango actual que podemos alcanzar con los saltos actuales
        int farthest = 0;  // El rango más lejano que podemos alcanzar con el próximo salto

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);  // Actualizar el rango más lejano alcanzable

            // Si alcanzamos el final del rango actual, incrementamos el número de saltos
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;  // Actualizamos el final del rango actual al más lejano alcanzable

                // Si ya podemos alcanzar el último índice, salimos del bucle
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Pruebas de ejemplo
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums1));  // 2

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(solution.jump(nums2));  // 2
    }
}


//You are given a 0-indexed array of integers nums of length n. 
//You are initially positioned at nums[0].

//Each element nums[i] represents the maximum length of a forward jump from index i. 
//In other words, if you are at nums[i], you can jump to any nums[i + j] where:

//0 <= j <= nums[i] and
//i + j < n
//Return the minimum number of jumps to reach nums[n - 1]. 
//The test cases are generated such that you can reach nums[n - 1].