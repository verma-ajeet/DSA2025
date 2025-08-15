package Linkedlist;

//This is a list
public class LL {
	Node head;
	int size;

	public LL() {
		this.size = 0;
	}

	class Node {
		String data;
		Node next;

		public Node(String data) {
			super();
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		LL l = new LL();
		l.addFirst("is");
		l.addLast("a");
		l.print();
		l.addLast("list");
		l.addLast("object");
		l.addFirst("This");
		l.print();
//		l.deletefirst();
//		l.deleteLast();
//		l.delete("a");
		l.print();
		System.out.println(l.getSize());
		System.out.println("reversed linked list");
		l.reverseLinked();
		l.print();
		System.out.println(l.checkCyclic());
//		l.head.next.next.next = l.head;
		System.out.println(l.checkCyclic());
		l.findMiddle();
//		l.rotateLinkedList(3);
	}
//
//	private void rotateLinkedList(int r) {
//		if(getSize()==0 & getSize()%r== )
//	}

	private void reverseLinked() {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	private boolean checkCyclic() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	private void findMiddle() {
		if(head==null) {
			return;
		}
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("middle = "+slow.data);
	}

	private void addFirst(String first) {
		Node newnNode = new Node(first);
		size++;
		if (head == null) {
			head = newnNode;
			return;
		}
		newnNode.next = head;
		head = newnNode;
		System.out.println(size);
	}

	private void addLast(String last) {
		Node newNode = new Node(last);
		size++;
		if (head == null) {
			head = newNode;
			return;
		}
		Node currNode = head;
		while (currNode.next != null) {
			currNode = currNode.next;
		}
		currNode.next = newNode;
	}

	public void print() {
		if (head == null) {
			System.out.println("list is emoty");
			return;
		}
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + " -> ");
			currNode = currNode.next;
		}
		System.out.println("NULL");
	}

	public void deletefirst() {
		if (head == null) {
			return;
		}
		head = head.next;
		size--;
	}

	public void deleteLast() {
		if (head == null) {
			return;
		}
		size--;
		if (head.next == null) {
			head = null;
			return;
		}
		Node currNode = head;
		while (currNode.next.next != null) {
			currNode = currNode.next;
		}
		currNode.next = null;
	}

	public int getSize() {
		return size;
	}
//	public void delete(String data) {
//		Node currNode=head;
//		while(currNode.data != data) {
//			currNode=currNode.next;
//		}
////		System.out.println(currNode.data);
//		currNode=currNode.next;
//	}
}
