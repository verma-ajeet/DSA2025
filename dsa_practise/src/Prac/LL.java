package Prac;


public class LL {
	Node head = null;
	int size = 0;

	public LL() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		LL l = new LL();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(50);
		l.print();
		l.addAt(40, 4);
		l.print();
		l.reverse();
		l.print();
		l.reverseRecursive();
		l.print();
		System.out.println("after rotation");
		l.rotateRight(2);
		l.print();
		System.out.println("after segreagation");
		l.segregateOddEvenNodes();
		l.print();
		System.out.println("after segregation");
		l.segregateOddEven();
		l.print();
	}

	private void segregateOddEven() {
		// TODO Auto-generated method stub
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

	private void segregateOddEvenNodes() {
		Node oddDummy = new Node(0);
		Node evenDummy = new Node(0);
		Node oddCurr = oddDummy;
		Node evenCurr = evenDummy;
		Node curr = head;
		for (int i = 0; i < size; i++) {
			if (i % 2 == 0) {
				evenCurr.next = curr;
				evenCurr = evenCurr.next;
			} else {
				oddCurr.next = curr;
				oddCurr = oddCurr.next;
			}

			curr = curr.next;
		}
		oddCurr.next = evenDummy.next;
		evenCurr.next = null;
		head = oddDummy.next;
	}

	private void rotateRight(int key) {
		key = key % size;
		Node newHead = null, newTail = null, curr = head;
		for (int i = 0; i < size - key; i++) {
			newTail = curr;
			curr = curr.next;
		}
		newHead = curr;
		newTail.next = null;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = head;
		head = newHead;
	}

	private void reverseRecursive() {
		head = reverseRecursively(head, null);
	}

	private Node reverseRecursively(Node current, Node prev) {
		if (current == null) {
			// Base case: reached the end of the list
			return prev;
		}
		// Save the next node before reversing the link
		Node nextNode = current.next;

		// Reverse the link
		current.next = prev;

		// Recursively reverse the rest of the list
		return reverseRecursively(nextNode, current);
	}

	private void reverse() {
		Node prev = null, next = null, curr = head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	private void addAt(int data, int target) {
		Node newNode = new Node(data);
		Node curr = head, attachingNode = null;
		int i = 1;
		while (i < target && curr != null) {
			attachingNode = curr;
			curr = curr.next;
			i++;
		}
		System.out.println(curr.data);
		attachingNode.next = newNode;
		newNode.next = curr;
		size++;
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

	private void print() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.print("null");
		System.out.println();
	}
}
