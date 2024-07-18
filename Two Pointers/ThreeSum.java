import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Ordenar el array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Evitar duplicados en el primer número
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Evitar duplicados en el segundo y tercer número
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Casos de prueba
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums1)); // [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {};
        System.out.println(solution.threeSum(nums2)); // []

        int[] nums3 = {0};
        System.out.println(solution.threeSum(nums3)); // []

        int[] nums4 = {0, 0, 0};
        System.out.println(solution.threeSum(nums4)); // [[0, 0, 0]]
    }
}


//Given an integer array nums, return all the triplets [nums[i], nums[j], 
//nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.