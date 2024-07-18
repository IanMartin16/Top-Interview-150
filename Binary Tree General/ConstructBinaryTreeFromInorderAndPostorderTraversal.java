import java.util.HashMap;
import java.util.Map;

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

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Build a map to store the index of each value in the inorder array
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Start the recursive construction of the tree
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        // Base case: if there are no elements to construct the tree
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // The last element of postorder array is the root of the tree
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // Find the root in the inorder array to divide the tree into left and right subtrees
        int inRootIndex = inorderIndexMap.get(rootVal);
        int leftSubtreeSize = inRootIndex - inStart;

        // Recursively build the left subtree
        root.left = buildTree(inorder, postorder, inStart, inRootIndex - 1, postStart, postStart + leftSubtreeSize - 1);

        // Recursively build the right subtree
        root.right = buildTree(inorder, postorder, inRootIndex + 1, inEnd, postStart + leftSubtreeSize, postEnd - 1);

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = solution.buildTree(inorder, postorder);
        // The tree can be tested here by traversing it or using a debugger
    }
}


//Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.