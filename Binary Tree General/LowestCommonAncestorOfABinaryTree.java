// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the root is null or matches either p or q, return the root.
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recurse on the left and right subtree.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, the current node is the LCA.
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child (either left or right).
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        // Create a sample binary tree:
        //         3
        //       /   \
        //      5     1
        //     / \   / \
        //    6   2 0   8
        //       / \
        //      7   4

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Solution solution = new Solution();
        TreeNode lca = solution.lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println("Lowest Common Ancestor: " + lca.val); // Expected output: 5
    }
}


//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as 
//the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”