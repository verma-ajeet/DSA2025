package Linkedlist;

class RevLL {
	int data;
	RevLL next;

	public RevLL(int data) {
		this.data = data;
	}
}

public class ReverseLinkedlist {
	public static void main(String[] args) {
		RevLL head = new RevLL(1);
		head.next = new RevLL(2);
		head.next.next = new RevLL(3);
		head.next.next.next = new RevLL(4);
		head.next.next.next = new RevLL(5);
		print(head);
		head = reverse(head);
		System.out.println("reversed");
		print(head);
		System.out.println("rotate by k");
		head = rotate(head, 2);
		print(head);
	}

	private static RevLL rotate(RevLL head, int rotations) {
		RevLL oldTail = head;
		if (head == null) {
			return null;
		}
		int len = 0;
		while (oldTail.next != null) {
			oldTail = oldTail.next;
			len++;
		}
		rotations = rotations % 2;
		RevLL newTail = head;
		System.out.println("len " + len);
		for (int i = 1; i < len - rotations - 1; i++) {
			newTail = newTail.next;
		}
		RevLL newHead = newTail.next;
		newTail.next = null;
		oldTail.next = head;
		return newHead;
	}

// 2 1 5 3
	private static RevLL reverse(RevLL head) {
		if (head == null) {
			return null;
		}
		RevLL prev = null;
		RevLL current = head;
		RevLL next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	private static void print(RevLL head) {
		RevLL current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}
