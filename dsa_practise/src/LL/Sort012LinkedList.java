package LL;

class Nodee {
	int data;
	Nodee next;

	public Nodee(int data) {
		this.data = data;
		this.next = null;
	}
}

public class Sort012LinkedList {
	Nodee head;

	public Sort012LinkedList() {
		this.head = null;
	}

	public static void main(String[] args) {
		Sort012LinkedList list = new Sort012LinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(0);
		list.add(2);
		list.add(1);

		System.out.println("Original Linked List:");
		list.print();

		list.sort012Dutch();

		System.out.println("\nLinked List after sorting 0s, 1s, and 2s:");
		list.print();

		Sort012LinkedList l = new Sort012LinkedList();
		l.add(0);
		l.add(1);
		l.add(2);
		l.add(1);
		l.add(0);
		System.out.println("brute");
		l.print();
		l.sortBrute();// tc= O (N) sc = O(1)
		l.print();
	}

// tc= O (N) sc = O(1)
	private void sortBrute() {
		Nodee curr = head;
		int count0 = 0, count1 = 0, count2 = 0;
		while (curr != null) {
			if (curr.data == 0) {
				count0++;
			} else if (curr.data == 1) {
				count1++;
			} else if (curr.data == 2) {
				count2++;
			}
			curr = curr.next;
		}
		curr = head;
		while (curr != null) {
			if (count0 > 0) {
				curr.data = 0;
				count0--;
			} else if (count1 > 0) {
				curr.data = 1;
				count1--;
			} else if (count2 > 0) {
				curr.data = 2;
				count2--;
			}
			curr = curr.next;
		}
	}

	private void add(int data) {
		Nodee newNode = new Nodee(data);
		if (head == null) {
			head = newNode;
		} else {
			Nodee curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
	}
	
//	 tc= O (N) sc = O(1)
//	 This algorithm is efficient and performs the sorting in a single pass through the linked list by maintaining
//	 three categories of nodes. It is optimal for this specific sorting problem.
	
	private void sort012Dutch() {
		// Create dummy nodes for 0, 1, and 2
		Nodee zeroDummy = new Nodee(0);
		Nodee oneDummy = new Nodee(0);
		Nodee twoDummy = new Nodee(0);
		// Create pointers for the tails of linked lists
		Nodee zeroTail = zeroDummy;
		Nodee oneTail = oneDummy;
		Nodee twoTail = twoDummy;
		// Traverse the original linked list
		Nodee curr = head;
		while (curr != null) {
			if (curr.data == 0) {
				zeroTail.next = curr;
				zeroTail = curr;
			} else if (curr.data == 1) {
				oneTail.next = curr;
				oneTail = curr;
			} else if (curr.data == 2) {
				twoTail.next = curr;
				twoTail = curr;
			}
			curr = curr.next;
		}
		// Concatenate the three linked lists
		zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
		oneTail.next = twoDummy.next;
		twoTail.next = null;
		// Update the head pointer
		head = zeroDummy.next;
	}

	private void print() {
		Nodee curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.print("null");
		System.out.println();
	}
}
