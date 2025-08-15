package LL;

public class SortLL {
	Node head;

	public SortLL() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		SortLL l = new SortLL();
//		l.add(10);
//		l.add(20);
//		l.add(50);
//		l.add(40);
//		l.add(5);
//		l.print();
//		l.sort();
		Node unsortedList = new Node(3, new Node(1, new Node(4, new Node(2, new Node(5)))));
		System.out.println("Unsorted Linked List:");
		l.printList(unsortedList);
		Node sortedList = l.sort(unsortedList);
		System.out.println("Sorted Linked List:");
		l.printList(sortedList);

	}

	private void printList(Node unsortedList) {
		Node curr = unsortedList;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.print("null");
		System.out.println();
	}

	private Node sort(Node head) {
		if (head == null || head.next == null) {
			return head; // Already sorted or empty list
		}
		Node middle = findMiddle();
		Node secondHalf = middle.next;
		middle.next = null;
		Node sortedFirstHalf = sort(head);
		Node sortedSecondHalf = sort(secondHalf);

		// Merge the sorted halves
		return merge(sortedFirstHalf, sortedSecondHalf);

	}

	private Node merge(Node sortedFirstHalf, Node sortedSecondHalf) {
		Node dummy = new Node();
		Node current = dummy;
		while (sortedFirstHalf != null && sortedSecondHalf != null) {
			if (sortedFirstHalf.data < sortedSecondHalf.data) {
				current.next = sortedFirstHalf;
				sortedFirstHalf = sortedFirstHalf.next;
			} else {
				current.next = sortedSecondHalf;
				sortedSecondHalf = sortedSecondHalf.next;
			}
			current = current.next;
		}
		if (sortedFirstHalf != null) {
			current.next = sortedFirstHalf;
		}

		if (sortedSecondHalf != null) {
			current.next = sortedSecondHalf;
		}
		return dummy.next;
	}

	private Node findMiddle() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private void printList() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.print("null");
		System.out.println();
	}

	private void add(int data) {
		Node newHead = new Node(data);
		if (head == null) {
			head = newHead;
		} else {
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = newHead;
		}
	}
}
