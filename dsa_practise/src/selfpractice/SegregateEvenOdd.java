package selfpractice;

public class SegregateEvenOdd {
	Node head = null;
	int size = 0;

	public SegregateEvenOdd() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		SegregateEvenOdd l = new SegregateEvenOdd();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.print();
		l.segregateEvenOddIndex();
		l.print();
		SegregateEvenOdd list = new SegregateEvenOdd();
		list.add(1);
		list.add(0);
		list.add(2);
		list.add(0);
		list.add(1);
		System.out.println("sort");
		list.sort012();
		list.print();
		System.out.println("Before sorting:");
		l.print();
		System.out.println("After sorting:");
		l.sort();
		l.print();
	}

	private void sort() {
		head = mergeSort(head);
	}

	private Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node middle = findMiddle(head);
		Node nextToMiddle = middle.next;
		middle.next = null;
		
		Node left = mergeSort(head);
		Node right = mergeSort(nextToMiddle);

		return merge(left, right);
	}

	private Node merge(Node left, Node right) {
		Node result = null;

		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}

		if (left.data <= right.data) {
			result = left;
			result.next = merge(left.next, right);
		} else {
			result = right;
			result.next = merge(left, right.next);
		}

		return result;
	}

	private Node findMiddle(Node head) {
		if (head == null) {
			return head;
		}

		Node slow = head;
		Node fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
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
		head = zeroDummy;
	}

	private void segregateEvenOddIndex() {
		if (head == null && head.next == null) {
			return;
		}
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
	}
}
