public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] result1 = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result1)); // [1, 2]

        int[] result2 = solution.twoSum(new int[]{2, 3, 4}, 6);
        System.out.println(Arrays.toString(result2)); // [1, 3]

        int[] result3 = solution.twoSum(new int[]{-1, 0}, -1);
        System.out.println(Arrays.toString(result3)); // [1, 2]
    }
}


//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing 
//order, find two numbers such that they add up to a specific target number. 
//Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

//Return the indices of the two numbers, index1 and index2, added by one as an 
//integer array [index1, index2] of length 2.

//The tests are generated such that there is exactly one solution. You may not use the same element twice.

//Your solution must use only constant extra space.