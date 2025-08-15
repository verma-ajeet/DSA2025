package Linkedlist;

class PracReveseLL {
	int data;
	PracReveseLL next;

	public PracReveseLL(int data) {
		this.data = data;
	}
}

public class PracReverseLinkedList {
	public static void main(String[] args) { // 1,2,3,4,5
		PracReveseLL head = new PracReveseLL(1);
		head.next = new PracReveseLL(2);
		head.next.next = new PracReveseLL(3);
		head.next.next.next = new PracReveseLL(4);
		head.next.next.next.next = new PracReveseLL(5);

		System.out.println("=========================");
		printList(head);
		PracReveseLL rotateHead= rotateRight(head, 2);
		printList(rotateHead);
	}

	public static void printList(PracReveseLL head) {
		PracReveseLL current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static PracReveseLL rotateRight(PracReveseLL head, int k) {
		if (head == null || k == 0 || head.next == null) {
			return head;
		}
		PracReveseLL tail = head;
		int len = 1;
		while (tail.next != null) {
			tail = tail.next;
			len++;
		}
		k = k % len;
		if (k == 0) {
			return head;
		}
		PracReveseLL newTail = head;
		for (int i = 0; i < len - k - 1; i++) {
			newTail = newTail.next;
		}
		PracReveseLL newHead = newTail.next;
		newTail.next=null;
		tail.next=head;
		return newHead;
	}
}





































