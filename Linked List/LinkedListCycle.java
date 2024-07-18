public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // Test case 1: Cycle exists
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next;  // Creates a cycle
        
        System.out.println(solution.hasCycle(head1)); // Expected output: true

        // Test case 2: No cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        
        System.out.println(solution.hasCycle(head2)); // Expected output: false
        
        // Test case 3: Single node, no cycle
        ListNode head3 = new ListNode(1);
        
        System.out.println(solution.hasCycle(head3)); // Expected output: false
    }
}


//Given head, the head of a linked list, determine if the linked list has a cycle in it.

//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
//Internally, pos is used to denote the index of the node that tail's next pointer is connected to. 
//Note that pos is not passed as a parameter.

//Return true if there is a cycle in the linked list. Otherwise, return false.