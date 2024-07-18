import java.util.*;

public class FindKPairsWithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        
        // Min-heap based on sum of pairs (nums1[i], nums2[j])
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        // Initialize heap with pairs (nums1[0], nums2[j]) for all j in nums2
        for (int j = 0; j < Math.min(nums2.length, k); j++) {
            minHeap.offer(new int[]{nums1[0], nums2[j], 0, j});
        }
        
        // Process the smallest k pairs
        while (!minHeap.isEmpty() && result.size() < k) {
            int[] pair = minHeap.poll();
            int num1 = pair[0];
            int num2 = pair[1];
            int index1 = pair[2];
            int index2 = pair[3];
            
            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(num1);
            currentPair.add(num2);
            result.add(currentPair);
            
            // Push the next possible pairs
            if (index1 + 1 < nums1.length) {
                minHeap.offer(new int[]{nums1[index1+1], nums2[index2], index1 + 1, index2});
            }
        }
        
        return result;
    }
}


//You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

//Define a pair (u, v) which consists of one element from the first array and one element from the second array.

//Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.