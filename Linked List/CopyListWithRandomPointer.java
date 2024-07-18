class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a weaved list of original and copied nodes.
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Assign random pointers for the copied nodes.
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Unweave the list to separate original and copied nodes.
        current = head;
        Node dummy = new Node(0);
        Node copyCurrent = dummy;

        while (current != null) {
            Node copy = current.next;
            copyCurrent.next = copy;
            copyCurrent = copy;

            current.next = copy.next;
            current = current.next;
        }

        return dummy.next;
    }

    // Helper function to print the list (for testing purposes)
    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.val + ", ");
            if (current.random != null) {
                System.out.print(current.random.val + "]");
            } else {
                System.out.print("null]");
            }
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example to test the function
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        head.random = head.next.next; // 1.random -> 3
        head.next.random = head;      // 2.random -> 1
        head.next.next.random = head.next; // 3.random -> 2

        DeepCopyLinkedList solution = new DeepCopyLinkedList();
        Node copiedHead = solution.copyRandomList(head);

        System.out.println("Original list:");
        solution.printList(head);

        System.out.println("Copied list:");
        solution.printList(copiedHead);
    }
}


//A linked list of length n is given such that each node contains an additional random pointer, 
//which could point to any node in the list, or null.

//Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, 
//where each new node has its value set to the value of its corresponding original node. 
//Both the next and random pointer of the new nodes should point to new nodes in the copied list such that 
//the pointers in the original list and copied list represent the same list state. 
//None of the pointers in the new list should point to nodes in the original list.

//For example, if there are two nodes X and Y in the original list, where X.random --> Y, 
//then for the corresponding two nodes x and y in the copied list, x.random --> y.

//Return the head of the copied linked list.