import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Define a priority queue with a comparator for ListNode
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the first node of each list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        // Dummy node to start the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process the priority queue
        while (!queue.isEmpty()) {
            ListNode node = queue.poll(); // Get the smallest node
            current.next = node; // Add it to the merged list
            current = current.next;

            if (node.next != null) {
                queue.add(node.next); // Add the next node of the list to the queue
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();

        // Creating sample linked lists
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {list1, list2, list3};

        ListNode mergedList = solution.mergeKLists(lists);

        // Print the merged linked list
        printList(mergedList);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}


//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

//Merge all the linked-lists into one sorted linked-list and return it.