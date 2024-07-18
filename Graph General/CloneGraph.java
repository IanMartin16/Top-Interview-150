import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    private Map<Node, Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        // Create a new node with the same value
        Node cloneNode = new Node(node.val, new ArrayList<>());
        
        // Store the node in the visited map
        visited.put(node, cloneNode);
        
        // Iterate through the neighbors to generate their clones and add them to the neighbors list of the clone node
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return cloneNode;
    }

    public static void main(String[] args) {
        // Test case
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Solution solution = new Solution();
        Node clonedGraph = solution.cloneGraph(node1);

        // Output cloned graph's structure to verify correctness
        printGraph(clonedGraph);
    }

    private static void printGraph(Node node) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.print("Node " + n.val + " neighbors: ");
            for (Node neighbor : n.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
            System.out.println();
        }
    }
}


// Given a reference of a node in a connected undirected graph.

//Return a deep copy (clone) of the graph.

//Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

//class Node {
//    public int val;
//    public List<Node> neighbors;
//}
 

//Test case format:

//For simplicity, each node's value is the same as the node's index (1-indexed). 
//For example, the first node with val == 1, the second node with val == 2, and so on. 
//The graph is represented in the test case using an adjacency list.

//An adjacency list is a collection of unordered lists used to represent a finite graph. 
//Each list describes the set of neighbors of a node in the graph.

//The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.