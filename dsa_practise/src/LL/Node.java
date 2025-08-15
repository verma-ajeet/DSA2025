package LL;

public class Node {
	int data;
	Node next = null;

	public Node(int data) {
		super();
		this.data = data;
		this.next = null;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}
}
