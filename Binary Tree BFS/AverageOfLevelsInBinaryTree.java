import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                sum += current.val;

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(sum / size);
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
        List<Double> averages = solution.averageOfLevels(root);
        System.out.println("Averages of levels: " + averages); // Expected output: [3.0, 14.5, 11.0]
    }
}


//Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. 
//Answers within 10-5 of the actual answer will be accepted.