class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SortList {

    public ListNode sortList(ListNode head) {
        // Base case: if head is null or there is only one element in the list
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode mid = getMiddle(head);
        ListNode rightHalf = mid.next;
        mid.next = null; // Split the list

        // Step 2: Recursively sort each half
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        // Step 3: Merge the two sorted halves
        return merge(left, right);
    }

    // Helper method to find the middle of the list
    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper method to merge two sorted lists
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        } else if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a sample linked list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        // Sort the list
        ListNode sortedHead = solution.sortList(head);

        // Print the sorted list
        while (sortedHead != null) {
            System.out.print(sortedHead.val + " ");
            sortedHead = sortedHead.next;
        }
    }
}


//Given the head of a linked list, return the list after sorting it in ascending order.