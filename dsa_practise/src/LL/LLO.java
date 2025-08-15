package LL;

public class LLO {
	Node head=null;
	int size=0;
	
	public LLO() {
		super();
	}

	public static void main(String[] args) {
		LLO l=new LLO();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.print();
		l.addFirst(0);
		l.print();
		l.deleteMiddle();
		l.print();
	}

	private void deleteMiddle() {
		Node slow=head;
		Node fast=head;
		Node prev=null;
		while(fast!=null && fast.next!=null) {
			prev=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		prev.next=slow.next;
	}

	private void addFirst(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
		}else {
			newNode.next=head;
			head=newNode;
		}
	}

	private void print() {
		Node curr=head;
		while(curr!=null) {
			System.out.print(curr.data+" -> ");
			curr=curr.next;
		}
		System.out.print("null");
		System.out.println();
	}

	private void add(int data) {
		Node newNode =new Node(data);
		if(head==null) {
			head=newNode;
		}else {
			Node curr=head;
			while(curr.next!=null) {
				curr=curr.next;
			}
			curr.next=newNode;
		}
		size++;
	}
}
