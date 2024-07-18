class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // Dummy nodes to start the less and greater lists
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        // Pointers to the current end of the less and greater lists
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        // Traverse the original list and partition the nodes
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        // Connect the two lists
        greater.next = null; // Important to avoid cycle
        less.next = greaterHead.next;

        // The head of the partitioned list
        return lessHead.next;
    }

    // Helper function to print the list (for testing purposes)
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example to test the function
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        PartitionList solution = new PartitionList();
        int x = 3;
        ListNode newHead = solution.partition(head, x);

        System.out.println("List after partitioning around " + x + ":");
        solution.printList(newHead);
    }
}


//Given the head of a linked list and a value x, partition it such that 
//all nodes less than x come before nodes greater than or equal to x.

//You should preserve the original relative order of the nodes in each of the two partitions.