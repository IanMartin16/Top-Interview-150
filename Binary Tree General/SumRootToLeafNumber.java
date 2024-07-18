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

public class SumRootToLeafNumber {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentNumber) {
        if (node == null) {
            return 0;
        }

        // Update the current number
        currentNumber = currentNumber * 10 + node.val;

        // If the node is a leaf, return the current number
        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        // Otherwise, continue the DFS on the left and right subtrees
        int leftSum = dfs(node.left, currentNumber);
        int rightSum = dfs(node.right, currentNumber);

        return leftSum + rightSum;
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

        int result = solution.sumNumbers(root);
        System.out.println(result);  // Expected output: 262 (124 + 125 + 13)
    }
}


//You are given the root of a binary tree containing digits from 0 to 9 only.

//Each root-to-leaf path in the tree represents a number.

//For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

//A leaf node is a node with no children.