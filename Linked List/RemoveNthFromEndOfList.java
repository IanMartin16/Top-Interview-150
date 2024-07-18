class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Initialize dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Initialize two pointers
        ListNode first = dummy;
        ListNode second = dummy;

        // Step 3: Move the first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Step 4: Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Step 5: Remove the nth node from the end
        second.next = second.next.next;

        // Return the head of the modified list
        return dummy.next;
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
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode newHead = solution.removeNthFromEnd(head, n);

        System.out.println("Modified list after removing nth node from the end:");
        solution.printList(newHead);
    }
}


//Given the head of a linked list, remove the nth node from the end of the list and return its head.