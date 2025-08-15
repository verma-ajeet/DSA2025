package Linkedlist;

class MiddleLinkedList {
	int data;
	MiddleLinkedList next;

	public MiddleLinkedList(int data) {
		this.data = data;
	}
}

public class DeleteMiddleLinkedList {
	public static void main(String[] args) {
		MiddleLinkedList head = new MiddleLinkedList(1);
		head.next = new MiddleLinkedList(2);
		head.next.next = new MiddleLinkedList(3);
		head.next.next.next = new MiddleLinkedList(4);
		head.next.next.next.next = new MiddleLinkedList(5);
		int size = getSize(head);
		System.out.println("size = " + size);
		print(head);
		print(deleteMiddle(head));
	}

	private static void print(MiddleLinkedList head) {
		MiddleLinkedList current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	private static int getSize(MiddleLinkedList head) {
		int len = 0;
		if (head == null) {
			return len;
		}
		MiddleLinkedList current = head;
		while (current != null) {
			current = current.next;
			len++;
		}
		return len;
	}

	private static MiddleLinkedList deleteMiddle(MiddleLinkedList head) {
		if (head == null) {
			return null;
		}
		int middle = getSize(head) / 2;
		MiddleLinkedList current = head;
		for (int i = 0; i < middle - 1; i++) {
			current = current.next;
		}
		current.next = current.next.next;
		return head;
	}
}
