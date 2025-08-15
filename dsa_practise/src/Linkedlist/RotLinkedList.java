package Linkedlist;

class RLL {
	int data;
	RLL next;

	public RLL(int data) {
		this.data = data;
	}
}

public class RotLinkedList {
	public static void main(String[] args) {
		RLL head = new RLL(1);
		head.next = new RLL(2);
		head.next.next = new RLL(3);
		head.next.next.next = new RLL(4);
		head.next.next.next.next = new RLL(5);
		int rotations = 2;
		print(head);
		System.out.println("rotated");
		head = rotateLinkList(head, rotations);
		print(head);
	}

	private static void print(RLL head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	private static RLL rotateLinkList(RLL head, int rotations) {
		if (head == null || head.next == null || rotations == 0) {
			return head;
		}
		RLL tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		int len = getSize(head);
		rotations = rotations % len;
		if (rotations == 0 && rotations == len) {
			return head;
		}

		RLL newTail = head;
		for (int i = 0; i < len - rotations - 1; i++) {
			newTail = newTail.next;
		}
		RLL newHead = newTail.next;
		newTail.next = null;
		tail.next = head;
		return newHead;
	}

	private static int getSize(RLL head) {
		int len = 0;
		RLL curr = head;
		while (curr != null) {
			curr = curr.next;
			len++;
		}
		return len;
	}

}
