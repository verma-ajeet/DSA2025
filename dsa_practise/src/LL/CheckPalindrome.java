package LL;

public class CheckPalindrome {
	Node head = null;
	int size = 0;

	public CheckPalindrome() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		CheckPalindrome l = new CheckPalindrome();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(2);
		l.add(1);
		l.print();
		boolean checkPalindrome = l.checkPalindrome();
		System.out.println(checkPalindrome);
	}

//  12321
	private boolean checkPalindrome() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node secondPart = reverse(slow.next);
		Node curr = head;
		int i = 0;
		while (i < size / 2) {
			if (curr.data != secondPart.data) {
				return false;
			}
			i++;
		}
		return true;
	}

	private Node reverse(Node head) {
		Node prev = null, next = null;
		Node curr = head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
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
