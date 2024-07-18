import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                
                if (prev != null) {
                    prev.next = currentNode;
                }
                prev = currentNode;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            prev.next = null; // Last node in this level points to null
        }

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating a sample binary tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        solution.connect(root);

        // Print the next pointers for each node at level 1
        System.out.println("Level 1: " + root.val + " -> " + (root.next != null ? root.next.val : "null"));
        System.out.println("Level 2: " + root.left.val + " -> " + (root.left.next != null ? root.left.next.val : "null"));
        System.out.println("Level 2: " + root.right.val + " -> " + (root.right.next != null ? root.right.next.val : "null"));
        System.out.println("Level 3: " + root.left.left.val + " -> " + (root.left.left.next != null ? root.left.left.next.val : "null"));
        System.out.println("Level 3: " + root.left.right.val + " -> " + (root.left.right.next != null ? root.left.right.next.val : "null"));
        System.out.println("Level 3: " + root.right.right.val + " -> " + (root.right.right.next != null ? root.right.right.next.val : "null"));
    }
}


//Given a binary tree

//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

//Initially, all next pointers are set to NULL.