public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        
        int left = 0;
        int right = m;
        int totalLength = m + n;
        
        while (left <= right) {
            int partitionX = left + (right - left) / 2;
            int partitionY = (totalLength + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Encontramos la partición correcta
                if (totalLength % 2 == 0) {
                    // Longitud total par
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    // Longitud total impar
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // Debemos movernos hacia la izquierda en nums1
                right = partitionX - 1;
            } else {
                // Debemos movernos hacia la derecha en nums1
                left = partitionX + 1;
            }
        }
        
        // Si llegamos aquí, significa que los arreglos no están ordenados correctamente
        throw new IllegalArgumentException("Los arreglos de entrada no están ordenados correctamente.");
    }
}


//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

//The overall run time complexity should be O(log (m+n)).