package LL;

public class S012 {
	Node head = null;
	int size = 0;

	public S012() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		S012 s = new S012();
		s.add(0);
		s.add(1);
		s.add(2);
		s.add(0);
		s.add(1);
		s.print();
		s.sort();
		s.print();
		S012 list = new S012();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.print();
		list.reverse();
		list.print();
		System.out.println("even odd nodes");
		list.evenOddNode();
		list.print();
		System.out.println("segregate even odd data");
		list.evenOddData();
		list.print();
		S012 l = new S012();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.print();
		System.out.println("after left");
		l.rotateLeft(2);
		l.print();
		System.out.println("after right");
		l.rotateRight(2);
		l.print();

	}

	private void rotateLeft(int key) {
		key = key % size;
		Node newTail = null;
		Node newHead = null;
		Node curr = head;
		for (int i = 0; i < key; i++) {
			newTail = curr;
			curr = curr.next;
		}
		newHead = curr;
		newTail.next = null;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next=head;
		head = newHead;
	}
	
	private void rotateRight(int key) {
		key = key % size;
		Node newTail = null;
		Node newHead = null;
		Node curr = head;
		for (int i = 0; i < size-key; i++) {
			newTail = curr;
			curr = curr.next;
		}
		newHead = curr;
		newTail.next = null;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next=head;
		head = newHead;
	}

	private void evenOddData() {
		Node evenDummy = new Node(0);
		Node oddDummy = new Node(0);
		Node evenCurr = evenDummy;
		Node oddCurr = oddDummy;
		Node curr = head;
		while (curr != null) {
			if (curr.data % 2 == 0) {
//				 This line links the next reference of the last node in the even list (evenCurr) 
//				to the current node (curr), effectively adding curr to the even list.
				evenCurr.next = curr;
//				This line updates the evenCurr pointer to point to the newly added node. 
//				It moves the evenCurr pointer to the end of the even list.

				evenCurr = evenCurr.next;
			} else {
				oddCurr.next = curr;
				oddCurr = oddCurr.next;
			}
			curr = curr.next;
		}
		evenCurr.next = oddDummy.next;
		oddCurr.next = null;
		head = evenDummy.next;
	}

	private void evenOddNode() {
		Node oddDummy = head;
		Node evenDummy = head.next;
		Node oddTail = oddDummy;
		Node evenTail = evenDummy;
		while (evenTail != null && evenTail.next != null) {
			oddTail.next = evenTail.next;
			oddTail = oddTail.next;
			evenTail.next = oddTail.next;
			evenTail = evenTail.next;
		}
		oddTail.next = evenDummy;
		head = oddDummy;
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

	private void sort() {
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
