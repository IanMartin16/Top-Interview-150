// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {
            // The left subtree is a perfect binary tree
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            // The right subtree is a perfect binary tree
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        // Create a sample complete binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \   /
        //    4   5 6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        Solution solution = new Solution();
        int nodeCount = solution.countNodes(root);
        System.out.println("Number of nodes in the complete binary tree: " + nodeCount);
        // Expected output: 6
    }
}


//Given the root of a complete binary tree, return the number of the nodes in the tree.

//According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, 
//and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

//Design an algorithm that runs in less than O(n) time complexity.