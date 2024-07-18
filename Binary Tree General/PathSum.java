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

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // If the root is null, return false since there's no path
        if (root == null) {
            return false;
        }

        // If it's a leaf node, check if the value equals targetSum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recursively check the left and right subtrees with the reduced targetSum
        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a sample binary tree:
        //        5
        //       / \
        //      4   8
        //     /   / \
        //    11  13  4
        //   /  \      \
        //  7    2      1

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        boolean result = solution.hasPathSum(root, targetSum);
        System.out.println(result);  // Expected output: true

        targetSum = 26;
        result = solution.hasPathSum(root, targetSum);
        System.out.println(result);  // Expected output: true

        targetSum = 18;
        result = solution.hasPathSum(root, targetSum);
        System.out.println(result);  // Expected output: false
    }
}


//Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf 
//path such that adding up all the values along the path equals targetSum.

//A leaf is a node with no children.