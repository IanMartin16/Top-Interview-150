class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public static void main(String[] args) {
        // Example usage:
        // Constructing the following tree:
        //     2
        //    / \
        //   1   3

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution solution = new Solution();
        boolean isValid = solution.isValidBST(root);
        System.out.println("Is the tree a valid BST? " + isValid);  // Output: true
    }
}


//Given the root of a binary tree, determine if it is a valid binary search tree (BST).

//A valid BST is defined as follows:

//The left 
//subtree
// of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.