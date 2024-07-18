// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);

        return node;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sol.sortedArrayToBST(nums);
        printTree(root);
    }

    // Helper method to print the tree (in-order traversal)
    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
}


//Given an integer array nums where the elements are sorted in ascending order, convert it to a 
//height-balanced
// binary search tree.