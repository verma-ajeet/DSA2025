package LL;

public class MiddleLinklist {
	Node head = null;
	int size = 0;

	public MiddleLinklist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MiddleLinklist l = new MiddleLinklist();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
		l.print();
		l.middle();
		l.print();
	}

	private void middle() {
		Node slow=head;
		Node fast=head;
		Node prev=null;
		while(fast!=null && fast.next!=null ) {
			slow=slow.next;
			fast=fast.next.next;
			System.out.println(slow.data);
		}
		System.out.println(slow.data);
	}

	private void print() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data+" -> ");
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
