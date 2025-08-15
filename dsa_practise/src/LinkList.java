class Nodeee {
	int data;
	Nodeee next;

	public Nodeee(int data) {
		super();
		this.data = data;
		this.next = null;
	}

}

public class LinkList {
	Nodeee head;
	int size = 0;

	public LinkList() {
		this.head = null;
	}

	public static void main(String[] args) {
		LinkList l = new LinkList();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.print();
		l.addLast(60);
		l.print();
		l.addFirst(0);
		int ele=l.search(2);
		System.out.println("element is "+ele);
		l.print();
		System.out.println("size " + l.size);
		l.deleteMiddle();
		l.print();
		System.out.println("reverse");
		l.reverse();
		l.print();
		System.out.println("rotate");
		l.rotateRight(2);
		l.print();
		l.printMiddle();
		boolean hasCycle = l.hasCycle();
		System.out.println(hasCycle);
		System.out.println("after deleting first element ");
		l.deleteFirst();
		l.print();
		l.deleteLast();
		System.out.println("after deleting last element ");
		l.print();
	}

	private int search(int n) {
		Nodeee curr=head;
		int i=0;
		while(curr!=null && i<=n) {
			i++;
			curr=curr.next;
		}
		return curr.data;
	}

	private void deleteLast() {
		  if (head == null || head.next == null) {
	            head = null; // Empty list or single-node list
	        } else {
	        	Nodeee current = head;
	            Nodeee prev = null;
	            while (current.next != null) {
	                prev = current;
	                current = current.next;
	            }
	            prev.next=null;
	        }
	}

	private void deleteFirst() {
		head=head.next;
		size--;
	}

	private boolean hasCycle() {
		Nodeee slow = head;
		Nodeee fast = head;
		while (fast != null && fast.next != null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				return true;
			}
		}
		return false;
	}

	private void printMiddle() {
		Nodeee slow = head;
		Nodeee fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow.data);
	}

//	private void rotateRight(int key) {
//		Nodeee curr = head;
//		System.out.println(size);
//		key = key % size;
//		System.out.println(size-key-1);
//		for (int i = 0; i < size-key-1; i++) {
//			curr = curr.next;
//		}
//		Nodeee newHead = curr.next;
//		curr.next = null;
//		curr = newHead;
//		while (curr.next != null) {
//			curr = curr.next;
//		}
//		curr.next=head;
//		head=newHead;
//	}

	private void rotateRight(int key) {
		key = key % size;
		int n = size - key;
		Nodeee curr = head;
		Nodeee newHead = null;
		Nodeee newTail = null;
		for (int i = 0; i < n; i++) {
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
		Nodeee prev = null;
		Nodeee next = null;
		Nodeee curr = head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	private void deleteMiddle() {
		Nodeee slow = head;
		Nodeee fast = head;
		Nodeee prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = slow.next;
		size--;
	}

	private void addFirst(int addFirst) {
		Nodeee newNode = new Nodeee(addFirst);
		Nodeee curr = head;
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
		}
		size++;
		head = newNode;
	}

	private void addLast(int data) {
		Nodeee newNode = new Nodeee(data);
		Nodeee curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		size++;
		curr.next = newNode;
	}

	private void print() {
		Nodeee curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.print("null");
		System.out.println();
	}

	private void add(int data) {
		size++;
		Nodeee l = new Nodeee(data);
		if (head == null) {
			head = l;
		} else {
			Nodeee curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = l;
		}

	}

}
