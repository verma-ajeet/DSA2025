package Linkedlist;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}

public class RotateLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println("Original List:");
		printList(head);
		int k = 2; // Number of positions to rotate
		ListNode rotatedHead = rotateRight(head, k);
		printList(rotatedHead);
	}

	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static ListNode rotateRight(ListNode head, int k) {
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
		System.out.println("newTail "+newTail.val);
		// Perform the rotation
		ListNode newHead = newTail.next;
		System.out.println(newHead.val);
		System.out.println(newTail.val);
		newTail.next = null;
		tail.next = head;

		return newHead;
	}
}
