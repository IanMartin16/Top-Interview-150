class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // Step 1: Initialize dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Step 2: Initialize pointers
        ListNode prev = dummy;
        ListNode current = head;

        // Step 3: Traverse the list
        while (current != null) {
            // Check for duplicates
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            
            // If prev.next is current, there were no duplicates
            if (prev.next == current) {
                prev = prev.next;
            } else {
                // Skip all duplicates
                prev.next = current.next;
            }
            
            // Move current pointer
            current = current.next;
        }
        
        // Return the modified list
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
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        RemoveDuplicates solution = new RemoveDuplicates();
        ListNode newHead = solution.deleteDuplicates(head);

        System.out.println("Modified list after removing duplicates:");
        solution.printList(newHead);
    }
}


//Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
//Return the linked list sorted as well.