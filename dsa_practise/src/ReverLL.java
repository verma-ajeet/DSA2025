class LinkListRev {
	int data;
	LinkListRev next;

	public LinkListRev(int data) {
		this.data = data;
	}
}

public class ReverLL {
	static int size = 0;

	public static void main(String[] args) {
		LinkListRev l = new LinkListRev(10);
		l.next = new LinkListRev(20);
		l.next.next = new LinkListRev(30);
		l.next.next.next = new LinkListRev(40);
		l.next.next.next.next = new LinkListRev(50);
		print(l);
		System.out.println("reverse ");
		LinkListRev reverse = reverse(l);
		print(reverse);
		LinkListRev ll=new LinkListRev(1);
		ll.next = new LinkListRev(2);
		ll.next.next = new LinkListRev(3);
		System.out.println("Recursive reverse");
		LinkListRev reverseRecursive = reverseRecursive(ll);
		print(reverseRecursive);
		System.out.println("right rotate");
		LinkListRev rotateLinkedListRight = RotateLinkedListRight(reverse, 2);
		print(rotateLinkedListRight);
		System.out.println("left rotate");
		LinkListRev rotateLinkedListLeft = RotateLinkedListLeft(rotateLinkedListRight, 2);
		print(rotateLinkedListLeft);
		System.out.println("delete middle");
		LinkListRev deleteMiddle = deleteMiddle(rotateLinkedListLeft);
		print(deleteMiddle);
	}

	private static LinkListRev reverseRecursive(LinkListRev head) {
		if (head == null || head.next == null) {
			return head;
		}
		LinkListRev rest = reverseRecursive(head.next);

		head.next.next = head;
		head.next = null;
		return rest;
	}

	private static LinkListRev RotateLinkedListLeft(LinkListRev head, int k) {
		if (head == null || k <= 0) {
			return head;
		}

		int length = getLength(head);
		k = k % length; // Adjust k if it's greater than the length of the list

		if (k == 0) {
			return head; // No rotation needed
		}

		LinkListRev current = head;
		LinkListRev newHead = null;
		LinkListRev newTail = null;
		for (int i = 0; i < k; i++) {
			newTail = current;
			current = current.next;
		}
		newHead = current;
		newTail.next = null;
		while (current.next != null) {
			current = current.next;
		}
		current.next = head;
		return newHead;
	}

//	 10        20      30      40    50
//	 oldhead        newtail           oldtail
	private static LinkListRev RotateLinkedListRight(LinkListRev head, int k) {
		if (head == null || k <= 0) {
			return head;
		}

		int length = getLength(head);
		k = k % length; // Adjust k if it's greater than the length of the list

		if (k == 0) {
			return head; // No rotation needed
		}

		LinkListRev current = head;
		LinkListRev newHead = null;
		LinkListRev newTail = null;

		// Traverse to the (length - k)th node
		for (int i = 0; i < length - k; i++) {
			newTail = current;
			current = current.next;
		}

		newHead = current;
		newTail.next = null; // Set the new tail's next to null

		// Traverse to the end of the original list
		while (current.next != null) {
			current = current.next;
		}

		// Connect the end of the original list to the original head
		current.next = head;

		return newHead;
	}

// 10     20    30 40 50
//	prev curr next
	private static LinkListRev reverse(LinkListRev l) {
		LinkListRev prev = null;
		LinkListRev curr = l;
		LinkListRev next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static int getLength(LinkListRev head) {
		int length = 0;
		LinkListRev current = head;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	private static void print(LinkListRev l) {
		LinkListRev current = l;
		size = 0;
		while (current != null) {
			System.out.print(" " + current.data);
			current = current.next;
			size++;

		}
		System.out.println();
	}
	
	private static LinkListRev deleteMiddle(LinkListRev head) {
		if (head==null||head.next==null){
			return null;
		}
		LinkListRev slow = head;
		LinkListRev fast = head;
		LinkListRev prev=null;
	    while ( fast!=null && fast.next!=null) {
	    	fast=fast.next.next;
	    	prev=slow;
			slow=slow.next;
		}
		prev.next=slow.next;
		return head;
	}
}
