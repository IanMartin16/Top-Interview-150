class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class ConstructQuadTree {
    
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int row, int col, int size) {
        if (size == 1) {
            return new Node(grid[row][col] == 1, true, null, null, null, null);
        }

        int newSize = size / 2;
        Node topLeft = construct(grid, row, col, newSize);
        Node topRight = construct(grid, row, col + newSize, newSize);
        Node bottomLeft = construct(grid, row + newSize, col, newSize);
        Node bottomRight = construct(grid, row + newSize, col + newSize, newSize);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        } else {
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    public static void main(String[] args) {
        QuadTree quadTree = new QuadTree();
        int[][] grid = {
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0}
        };

        Node root = quadTree.construct(grid);
        printQuadTree(root, 0);
    }

    private static void printQuadTree(Node node, int indent) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        if (node.isLeaf) {
            System.out.println("Leaf: " + node.val);
        } else {
            System.out.println("Internal");
            printQuadTree(node.topLeft, indent + 1);
            printQuadTree(node.topRight, indent + 1);
            printQuadTree(node.bottomLeft, indent + 1);
            printQuadTree(node.bottomRight, indent + 1);
        }
    }
}


//Given a n * n matrix grid of 0's and 1's only. We want to represent grid with a Quad-Tree.

//Return the root of the Quad-Tree representing grid.