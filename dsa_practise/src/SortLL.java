class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class SortLL {
	// Function to insert a node at the beginning of the linked list
	public static Node push(Node head, int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
		return head;
	}

	// Function to print the linked list
	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	// Function to get the last node of the list
	public static Node getTail(Node cur) {
		while (cur != null && cur.next != null)
			cur = cur.next;
		return cur;
	}

	// Function to partition the list, taking the last element as the pivot
	public static Node partition(Node head, Node end, Node[] newHead, Node[] newEnd) {
		Node pivot = end;
		Node prev = null, cur = head, tail = pivot;

		while (cur != pivot) {
			if (cur.data < pivot.data) {
				if (newHead[0] == null)
					newHead[0] = cur;

				prev = cur;
				cur = cur.next;
			} else {
				if (prev != null)
					prev.next = cur.next;
				Node tmp = cur.next;
				cur.next = null;
				tail.next = cur;
				tail = cur;
				cur = tmp;
			}
		}

		if (newHead[0] == null)
			newHead[0] = pivot;

		newEnd[0] = tail;

		return pivot;
	}

	// Recursive function for quick sort
	public static Node quickSortRecur(Node head, Node end) {
		if (head == null || head == end)
			return head;

		Node[] newHead = new Node[1];
		Node[] newEnd = new Node[1];

		Node pivot = partition(head, end, newHead, newEnd);

		if (newHead[0] != pivot) {
			Node tmp = newHead[0];
			while (tmp.next != pivot)
				tmp = tmp.next;
			tmp.next = null;

			newHead[0] = quickSortRecur(newHead[0], tmp);
			tmp = getTail(newHead[0]);
			tmp.next = pivot;
		}

		pivot.next = quickSortRecur(pivot.next, newEnd[0]);

		return newHead[0];
	}

	// Wrapper function for quick sort
	public static Node quickSort(Node head) {
		head = quickSortRecur(head, getTail(head));
		return head;
	}

	public static void main(String[] args) {
		Node a = null;
		a = push(a, 5);
		a = push(a, 20);
		a = push(a, 4);
		a = push(a, 3);
		a = push(a, 30);

		System.out.println("Linked List before sorting:");
		printList(a);

		a = quickSort(a);

		System.out.println("Linked List after sorting:");
		printList(a);
	}
}
