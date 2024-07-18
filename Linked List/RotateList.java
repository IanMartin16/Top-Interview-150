class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Calculate the length of the list
        ListNode current = head;
        int length = 1;  // since we are already at head
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Make the list circular
        current.next = head;

        // Step 3: Calculate the effective rotations needed
        k = k % length;
        int stepsToNewHead = length - k;

        // Step 4: Find the new head and break the circular list
        ListNode newTail = current;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        // Step 5: Return the new head
        return newHead;
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

        RotateList solution = new RotateList();
        int k = 2;
        ListNode newHead = solution.rotateRight(head, k);

        System.out.println("List after rotating by " + k + " places:");
        solution.printList(newHead);
    }
}


//Given the head of a linked list, rotate the list to the right by k places.