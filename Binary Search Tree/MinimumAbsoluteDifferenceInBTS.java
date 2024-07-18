class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MinimumAbsoluteDifferenceInBTS {
    private Integer prev;
    private int minDiff;

    public int getMinimumDifference(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inorderTraversal(node.left);

        // Process the current node
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        // Traverse the right subtree
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        // Example usage:
        // Constructing the following BST:
        //     4
        //    / \
        //   2   6
        //  / \
        // 1   3

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Solution solution = new Solution();
        int minDifference = solution.getMinimumDifference(root);
        System.out.println("Minimum absolute difference: " + minDifference);  // Output: 1
    }
}


//Given the root of a Binary Search Tree (BST), return the minimum absolute difference 
//between the values of any two different nodes in the tree.