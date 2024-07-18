class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeMaximumPathSum {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the maximum path sum for the left and right subtrees
        int leftMax = Math.max(dfs(node.left), 0);
        int rightMax = Math.max(dfs(node.right), 0);

        // Update the global maximum path sum if the path through the current node is higher
        int currentMax = node.val + leftMax + rightMax;
        maxSum = Math.max(maxSum, currentMax);

        // Return the maximum path sum ending at the current node
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a sample binary tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int result = solution.maxPathSum(root);
        System.out.println(result);  // Expected output: 15 (4 -> 2 -> 1 -> 3)
    }
}


//A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. 
//A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

//The path sum of a path is the sum of the node's values in the path.

//Given the root of a binary tree, return the maximum path sum of any non-empty path.