class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class KthSmallestElementInABST {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }

    private void inorderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inorderTraversal(node.left, k);

        // Process the current node
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse the right subtree
        inorderTraversal(node.right, k);
    }

    public static void main(String[] args) {
        // Example usage:
        // Constructing the following BST:
        //     3
        //    / \
        //   1   4
        //    \
        //     2

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        Solution solution = new Solution();
        int k = 2;
        int kthSmallestValue = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest value is: " + kthSmallestValue);  // Output: 2
    }
}


//Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.