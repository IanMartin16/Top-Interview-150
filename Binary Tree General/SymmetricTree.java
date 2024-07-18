import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            
            // If both nodes are null, continue to the next pair
            if (left == null && right == null) {
                continue;
            }
            
            // If only one of the nodes is null, return false
            if (left == null || right == null) {
                return false;
            }
            
            // If values of nodes don't match, return false
            if (left.val != right.val) {
                return false;
            }
            
            // Add the children to the queue in mirror order
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        
        return true;
    }
}


//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).