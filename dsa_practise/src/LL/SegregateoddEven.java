package LL;

import java.util.Arrays;

public class SegregateoddEven {
	Node head = null;
	int size = 0;

	public SegregateoddEven() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		SegregateoddEven l = new SegregateoddEven();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.print();
		System.out.println("=============================================");
		l.segregate();
		l.print();
		System.out.println("=============================================");
		l.segregateOptimal();
		l.print();
		System.out.println("=============================================");
		System.out.println("optimal");
		l.so();
		l.print();
		System.out.println("=============================================");
	}

	private void so() {
		if (head == null || head.next == null) {
			return; // No need to segregate if the list is empty or has only one node
		}

		Node oddHead = head;
		Node evenHead = head.next;

		Node oddCurrent = oddHead;
		Node evenCurrent = evenHead;

		while (evenCurrent != null && evenCurrent.next != null) {
			oddCurrent.next = evenCurrent.next;
			System.out.println(oddCurrent.next.data);
			oddCurrent = oddCurrent.next;

			evenCurrent.next = oddCurrent.next;
			evenCurrent = evenCurrent.next;
		}

		// Connect the odd list with the even list
		oddCurrent.next = evenHead;

	}

	private void segregateOptimal() {
		if (head == null || head.next == null) {
			return; // No need to segregate if the list is empty or has only one node
		}
		Node oddHead = new Node();
		Node evenHead = new Node();
		Node current = head;
		Node oddCurrent = oddHead;
		Node evenCurrent = evenHead;
		int index = 1;
		while (current != null) {
			if (index % 2 == 1) {
				oddCurrent.next = current;
				oddCurrent = oddCurrent.next;
			} else {
				evenCurrent.next = current;
				evenCurrent = evenCurrent.next;
			}
			current = current.next;
			index++;
		}
		oddCurrent.next = evenHead.next;
		evenCurrent.next = null;
//		return oddHead.next;
	}

	private void segregate() {
		Node fast = head;
		int[] arr = new int[size];
		int i = 0;
		while (fast != null && fast.next != null) {
			arr[i] = fast.data;
			i++;
			fast = fast.next.next;
		}
		if (size % 2 != 0) {
			arr[i] = fast.data;
			i++;
		}
		fast = head.next;
		while (fast != null && fast.next != null) {
			arr[i] = fast.data;
			i++;
			fast = fast.next.next;
		}
		if (size % 2 == 0) {
			arr[i] = fast.data;
		}
		System.out.println(Arrays.toString(arr));
		Node curr = head;
		for (i = 0; i < arr.length; i++) {
			curr.data = arr[i];
			curr = curr.next;
		}
	}

	private void print() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.print("null");
		System.out.println();
	}

	private void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
		size++;
	}
}
