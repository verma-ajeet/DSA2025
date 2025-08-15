package LL;

public class LLCO {
	Node head = null;
	int size = 0;

	public LLCO() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		LLCO l = new LLCO();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.print();
		l.reverse();
		l.print();
		System.out.println("rotate");
		l.rotateRight(2);
		l.print();
		System.out.println("way 1");
		l.evenoddNode();
		l.print();
		System.out.println("way 2");
		l.evenoddNode1();
		l.print();
		System.out.println("even odd node");
		l.evenoddNode2();
		l.print();
		LLCO list = new LLCO();
		list.add(0);
		list.add(1);
		list.add(0);
		list.add(2);
		list.add(1);
		list.add(0);
		list.print();
		list.sort012();
		list.print();
	}

	private void evenoddNode1() {
		if (head == null || head.next == null) {
			return;
		}

		Node oddDummy = new Node(0);
		Node evenDummy = new Node(0);
		Node oddCurrent = oddDummy;
		Node evenCurrent = evenDummy;

		Node current = head;
		int index = 1;

		while (current != null) {
			if (index % 2 == 0) {
				evenCurrent.next = current;
				evenCurrent = evenCurrent.next;
			} else {
				oddCurrent.next = current;
				oddCurrent = oddCurrent.next;
			}

			index++;
			current = current.next;
		}

		evenCurrent.next = null; // Set the end of even list to null
		oddCurrent.next = evenDummy.next; // Connect odd list to even list
		head = oddDummy.next; // Update the head to the new head of the odd list
	}

	private void evenoddNode() {
		Node oddNode = head;
		Node evenNode = head.next;
		Node oddCurrent = oddNode;
		Node evenCurrent = evenNode;
		while (evenCurrent != null && evenCurrent.next != null) {
			oddCurrent.next = evenCurrent.next;
			oddCurrent = oddCurrent.next;
			evenCurrent.next = oddCurrent.next;
			evenCurrent = evenCurrent.next;
		}
		oddCurrent.next = evenNode;
	}

	private void evenoddNode2() {
		Node evenHead = new Node(0);
		Node oddHead = new Node(0);

		Node current = head;
		Node even = evenHead;
		Node odd = oddHead;
		while (current != null) {
			if (current.data % 2 == 0) {
				even.next = current;
				even = even.next;
			} else {
				odd.next = current;
				odd = odd.next;
			}
			current = current.next;
		}
		even.next = oddHead.next; // Connect even list to odd list
		odd.next = null;
		head = evenHead.next;
	}

	private void sort012() {
		Node zeroDummy = new Node(0);
		Node oneDummy = new Node(0);
		Node twoDummy = new Node(0);
		Node zeroTail = zeroDummy;
		Node oneTail = oneDummy;
		Node twoTail = twoDummy;
		Node curr = head;
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
		zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
		oneTail.next = twoDummy.next;
		twoTail.next = null;
	}

	private void rotateRight(int key) {
		if (head == null && head.next != null) {
			return;
		}
		key = key % size;
		Node newTail = null, newHead = null, curr = head;
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

	private void reverse() {
		Node prev = null;
		Node next = null;
		Node curr = head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	private void print() {
		if (head == null && head.next == null) {
			return;
		}
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
