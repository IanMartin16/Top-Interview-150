import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode rightmost = null;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                rightmost = current;

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            if (rightmost != null) {
                result.add(rightmost.val);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Create a sample binary tree:
        //         1
        //       /   \
        //      2     3
        //       \     \
        //        5     4

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        Solution solution = new Solution();
        List<Integer> rightSide = solution.rightSideView(root);
        System.out.println("Right side view: " + rightSide); // Expected output: [1, 3, 4]
    }
}


//Given the root of a binary tree, imagine yourself standing on the right side of it, 
//return the values of the nodes you can see ordered from top to bottom.