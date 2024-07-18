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

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Flatten the left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // Store the left and right subtrees
        TreeNode left = root.left;
        TreeNode right = root.right;

        // Set the left subtree to null and the right subtree to the flattened left subtree
        root.left = null;
        root.right = left;

        // Find the end of the new right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        // Attach the flattened right subtree
        current.right = right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating a sample binary tree:
        //        1
        //       / \
        //      2   5
        //     / \   \
        //    3   4   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        solution.flatten(root);

        // Print the flattened tree
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        // Expected output: 1 2 3 4 5 6
    }
}


//Given the root of a binary tree, flatten the tree into a "linked list":

//The "linked list" should use the same TreeNode class where 
//the right child pointer points to the next node in the list and the left child pointer is always null.
//The "linked list" should be in the same order as a pre-order traversal of the binary tree.