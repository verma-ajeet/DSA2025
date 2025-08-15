package LL;

public class LLPrac {
	Node head = null;
	int size = 0;

	public LLPrac() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		LLPrac l = new LLPrac();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.print();
		System.out.println("============reverse============");
		l.reverse();
		l.print();
		System.out.println("============rotate============");
		l.rotateRight(2);
		l.print();
		System.out.println("=============segregate even and odd index");
		l.seg();
		l.print();
		LLPrac list = new LLPrac();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(0);
		list.add(1);
		System.out.println("============sort 012============");
		list.sort012();
		list.print();
	}

	private void seg() {
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
		oddCurrent.next=evenNode;
	}

	private void sort012() {
		if (head == null && head.next == null) {
			return;
		}
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
		if (head == null && head.next == null) {
			return;
		}
		key = key % size;
		Node newHead = null;
		Node newTail = null;
		Node curr = head;
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
		if (head == null && head.next == null) {
			return;
		}
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
		System.out.print("null\n");
	}
}
