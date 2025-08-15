package Prac;

class ReLL {
	int data;
	ReLL next;

	public ReLL(int data) {
		super();
		this.data = data;
	}
}

public class RevLL {
	private ReLL head;
	int len;

	public static void main(String[] args) {
		RevLL list = new RevLL();
		list.addFirst(1);
		list.addFirst(10);
		list.print();
		list.addLast(20);
		list.print();
		System.out.println(list.len);
		list.addAtIndex(30, 2);
		System.out.print("after add 30 at index 2 = ");
		list.print();
		list.addAtIndex(40, 9);
		list.print();

		list.deleteFirst();
		list.print();
		list.deleteLast();
		list.print();
		for (int i = 0; i <= 2; i++) {
			list.addLast(20 * i);
		}
		list.print();
		list.deleteAtIndex(4);
		list.print();
		list.reverse();
		list.print();
	}

	private void print() {
		len = 0;
		ReLL curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
			len++;
		}
		System.out.println();
	}

	private void addFirst(int data) {
		ReLL newNode = new ReLL(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	private int returnLast() {
		if (head == null) {
			return 0;
		}
		ReLL curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		System.out.println("last " + curr.data);
		return curr.data;
	}

	private void addLast(int data) {
		ReLL newNode = new ReLL(data);
		if (head == null) {
			head = newNode;
			return;
		}
		ReLL current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

	private void addAtIndex(int data, int index) {
		ReLL newNode = new ReLL(data);
		if (head == null) {
			head = newNode;
			return;
		} else if (index <= 0) {
			addFirst(data);
			return;
		} else if (index > len) {
			addLast(data);
			return;
		}
		ReLL curr = head;
		for (int i = 0; i < index - 1; i++) {
			curr = curr.next;
			System.out.println("curr = " + curr.data);
		}
		newNode.next = curr.next;
		curr.next = newNode;
	}

	private void deleteFirst() {
		if (head == null) {
			return;
		}
		head = head.next;
	}

	private void deleteLast() {
		ReLL curr = head;
		if (head == null) {
			return;
		}
		while (curr.next.next != null) {
			curr = curr.next;
		}
		curr.next = null;
	}

	private void deleteAtIndex(int index) {
		ReLL curr = head;
		for (int i = 0; i < index - 2; i++) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
	}

	private void reverse() {
		ReLL prev = null;
		ReLL curr = head;
		ReLL next = null;
		if (head == null) {
			return;
		}
		while (curr != null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
	}
}
