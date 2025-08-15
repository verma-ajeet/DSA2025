package LL;

public class CheckLLIsPalindrome {
	Node head = null;

	public CheckLLIsPalindrome() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		CheckLLIsPalindrome l = new CheckLLIsPalindrome();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(2);
		l.add(1);
		l.print();
		boolean checkPalindrome = l.checkPalindrome();
		System.out.println(checkPalindrome);
	}

//12321
	private boolean checkPalindrome() {
		if (head == null || head.next == null) {
			return true; // An empty list or a list with a single node is a palindrome
		}

		// Find the middle of the linked list
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node secondHalf = reverse(slow.next);
		Node firstHalf = head;
		while (secondHalf != null) {
			if (firstHalf.data != secondHalf.data) {
				return false;
			}
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}
		return true;
	}

	private Node reverse(Node head) {
		Node prev = null;
		Node next = null;
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
