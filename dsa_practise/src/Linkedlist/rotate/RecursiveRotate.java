package Linkedlist.rotate;

class RecursiveListNode {
    int val;
    RecursiveListNode next;

    RecursiveListNode(int val) {
        this.val = val;
    }
}

public class RecursiveRotate {
    public ListNode rotateRightRecursive(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate the length of the linked list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Adjust k if it's greater than the length
        k = k % length;

        // If k becomes 0 after adjustment, no rotation is needed
        if (k == 0) {
            return head;
        }

        // Find the new tail and the node before the new head
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // Perform the rotation
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}
