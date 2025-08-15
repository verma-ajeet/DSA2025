class Nodee {
	int data;
	Nodee next;

	public Nodee(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {
	private Nodee head;

	public LinkedList() {
		this.head = null;
	}

	public static void main(String[] args) {
		// Create a linked list
		LinkedList linkedList = new LinkedList();

		// Add nodes to the linked list
		linkedList.addNode(1);
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.addNode(4);

		// Print the linked list
		System.out.println("Original Linked List:");
		linkedList.printList();

		// Add a new node to the end of the linked list
		linkedList.addNode(5);
		linkedList.printList();
		linkedList.reverse();
		System.out.println("Reversed Linked List:");
		linkedList.printList();
		linkedList.rotate(2);
		System.out.println("Rotated Linked List:");
		linkedList.printList();

		// Delete the middle node
		linkedList.deleteMiddle();
		System.out.println("Linked List after deleting the middle node:");
		linkedList.printList();
	}

	private void printList() {
		Nodee current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	private void addNode(int data) {
		Nodee newNode = new Nodee(data);

		if (head == null) {
			// If the list is empty, the new node becomes the head
			head = newNode;
		} else {
			// Traverse to the end of the list and add the new node
			Nodee current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void reverse() {
		Nodee prev = null;
		Nodee current = head;
		Nodee next;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		// Set the new head to the last node (prev)
		head = prev;
	}

	public void rotate(int k) {
		if (head == null || k <= 0) {
			return;
		}

		// Find the length of the linked list
		int length = 0;
		Nodee current = head;
		while (current != null) {
			length++;
			current = current.next;
		}

		// Adjust the rotation amount to avoid unnecessary rotations
		k = k % length;

		if (k == 0) {
			return; // No need to rotate
		}

		// Find the new head after rotation
		int stepsToNewHead = length - k - 1;
		current = head;
		for (int i = 0; i < stepsToNewHead; i++) {
			current = current.next;
		}

		// Break the list at the new head and update the head
		Nodee newHead = current.next;
		current.next = null;
		current = newHead;
		while (current.next != null) {
			current = current.next;
		}
		current.next = head;
		head = newHead;
	}

	public void deleteMiddle() {
		if (head == null || head.next == null) {
			return; // Cannot delete middle for an empty or single-node list
		}

		Nodee slow = head;
		Nodee fast = head;
		Nodee prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		// Delete the middle node (slow)
		prev.next = slow.next;
	}
}
