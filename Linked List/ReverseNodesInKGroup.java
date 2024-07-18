public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, nex = dummy, pre = dummy;
        int count = 0;
        
        // Count the number of nodes in the list
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }
        
        // Loop through the list, reversing every k nodes
        while (count >= k) {
            curr = pre.next;
            nex = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            pre = curr;
            count -= k;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        int k = 3;
        ListNode result = solution.reverseKGroup(head, k);
        
        // Print the resulting list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}


//Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

//k is a positive integer and is less than or equal to the length of the linked list. 
//If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

//You may not alter the values in the list's nodes, only nodes themselves may be changed.