package LL;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SortLinkedList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Already sorted or empty list
        }

        // Find the middle of the linked list
        ListNode middle = findMiddle(head);

        // Split the list into two halves
        ListNode secondHalf = middle.next;
        middle.next = null;

        // Recursively sort both halves
        ListNode sortedFirstHalf = sortList(head);
        ListNode sortedSecondHalf = sortList(secondHalf);

        // Merge the sorted halves
        return merge(sortedFirstHalf, sortedSecondHalf);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes (if any) from both lists
        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SortLinkedList solution = new SortLinkedList();

        // Example: Sort a linked list
        ListNode unsortedList = new ListNode(3, new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(5)))));
        System.out.println("Unsorted Linked List:");
        solution.printList(unsortedList);

        ListNode sortedList = solution.sortList(unsortedList);
        System.out.println("Sorted Linked List:");
        solution.printList(sortedList);
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
