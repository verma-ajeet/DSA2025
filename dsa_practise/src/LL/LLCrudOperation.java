package LL;

public class LLCrudOperation {
	Node head = null;
	int size = 0;

	public LLCrudOperation() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		LLCrudOperation l = new LLCrudOperation();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(50);
		l.add(60);
		l.print();
		l.addHead(0);
		l.print();
		l.addAtN(40, 5);
		l.print();
		l.deleteAtN(5);
		l.print();
		l.deleteFirst();
		l.print();
		System.out.println("After deleting last element");
		l.deleteLast();
		l.print();
		l.addHead(0);
		l.print();
		l.addAtN(40, 5);
		l.add(60);
		l.print();
		l.deleteNfromLast(2);
	}

	private void deleteNfromLast(int i) {
		
	}

	private void deleteLast() {
		if (head == null && head.next == null) {
			return;
		}
		Node curr=head;
		while(curr.next.next!=null) {
			curr=curr.next;
		}
		curr.next=null;
	}

	private void deleteFirst() {
		if (head == null && head.next == null) {
			return;
		}
		head=head.next;
	}

	private void deleteAtN(int pos) {
		if (head == null & head.next == null) {
			return;
		}
		Node curr = head;
		for (int i = 1; i < pos - 1; i++) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
	}

	private void addAtN(int data, int pos) {
		Node newNode = new Node(data);
		Node curr = head;
		for (int i = 1; i < pos; i++) {
			if (i == pos - 1) {
				break;
			}
			curr = curr.next;
		}
		newNode.next = curr.next;
		curr.next = newNode;
	}

	private void addHead(int data) {
		Node newNode = new Node(data);
		if (head == null && head.next == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
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
