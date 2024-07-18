import java.util.HashMap;
import java.util.Map;

// Definition for a binary tree node
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

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    // To store the index of each value in inorder array for quick lookup
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Initialize the map to store the index of each value in inorder array
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        // Start the recursive construction of the tree
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        // Base case: if there are no elements to construct the tree
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        // The first element of preorder array is the root of the tree
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        // Find the root in the inorder array to divide the tree into left and right subtrees
        int inRootIndex = inorderIndexMap.get(rootVal);
        int leftSubtreeSize = inRootIndex - inStart;
        
        // Recursively build the left subtree
        root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeSize, inStart, inRootIndex - 1);
        
        // Recursively build the right subtree
        root.right = buildTree(preorder, preStart + leftSubtreeSize + 1, preEnd, inRootIndex + 1, inEnd);
        
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preorder, inorder);
        // The tree can be tested here by traversing it or using a debugger
    }
}


//Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.