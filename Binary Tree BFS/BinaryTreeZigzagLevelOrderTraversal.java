import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> currentLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (leftToRight) {
                    currentLevel.addLast(currentNode.val);
                } else {
                    currentLevel.addFirst(currentNode.val);
                }

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(new ArrayList<>(currentLevel));
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        // Create a sample binary tree:
        //         3
        //       /   \
        //      9     20
        //           /  \
        //          15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        List<List<Integer>> zigzagOrderTraversal = solution.zigzagLevelOrder(root);
        System.out.println("Zigzag Level Order Traversal: " + zigzagOrderTraversal); 
        // Expected output: [[3], [20, 9], [15, 7]]
    }
}


//Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., 
//from left to right, then right to left for the next level and alternate between).