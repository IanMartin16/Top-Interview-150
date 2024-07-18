public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is a peak
            if (nums[mid] > nums[mid + 1]) {
                right = mid; // Potential peak is in the left half
            } else {
                left = mid + 1; // Potential peak is in the right half
            }
        }
        
        // Left must be the peak element index because we are narrowing down to a single element
        return left;
    }
}


//A peak element is an element that is strictly greater than its neighbors.

//Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

//You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

//You must write an algorithm that runs in O(log n) time.