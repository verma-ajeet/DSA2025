package StringPrac;

public class LL {
	Node head = null;
	int size = 0;

	public LL() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		LL l = new LL();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.print();
		l.addFirst(0);
		l.print();
		l.deleteFirst();
		l.print();
		l.deleteMiddle();
		l.print();
		l.addAt(30, 3);
		l.print();
		l.reverse();
		l.print();
		l.rotateRight(2);
		l.print();
		l.rotateLeft(2);
		l.print();
		l.reverse();
		l.print();
		System.out.println("after segregation");
		l.segregateEvenOddNodes();
		l.print();
		l.segregateEvenOddNumber();
		l.print();
		LL list = new LL();
		list.add(0);
		list.add(2);
		list.add(0);
		list.add(1);
		list.add(0);
		list.print();
		list.sort012();
		list.print();
		LL l1 = new LL();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		LL l2 = new LL();
		l2.add(1);
		l2.add(9);
		l2.add(3);
		LL op = new LL();
		System.out.println("==============");
		System.out.println("after adding ");
		l1.print();
		l2.print();
		op.addTwo(l1, l2);
		op.print();
		System.out.println("==============");
		boolean checkCyclic = l.checkCyclic();
		System.out.println(checkCyclic);
		LL l3 = new LL();
		l3.add(1);
		l3.add(2);
		l3.add(3);
//		l3.add(2);
		l3.add(1);
		System.out.println("is palindrome "+l3.checkPallindrome());
		LL l4 = new LL();
		l4.add(1);
		l4.add(2);
		l4.add(3);
		l4.add(2);
		l4.add(1);
		System.out.println("is palindrome "+l4.checkPallindrome());
	}

	private boolean checkPallindrome() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node sec=null;
		if(size%2==0) {
			sec=reverseSecondPart(slow);
		}else {
			sec=reverseSecondPart(slow.next);
		}
		Node curr=head;
		while(sec!=null ) {
			if(sec.data!=curr.data) {
				return false;
			}
			sec=sec.next;
			curr=curr.next;
		}
		return true;
	}

	private Node reverseSecondPart(Node head) {
		Node prev=null,next=null,curr=head;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}

	private boolean checkCyclic() {
		Node slow = head;
		Node fast = head.next;
//		head.next.next=head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	private void addTwo(LL l1, LL l2) {
		Node num1=l1.head;
		Node num2=l2.head;
		Node dummy = new Node(0);
		Node result=dummy;
		int carry=0;
		while(num1!=null || num2!=null) {
			int sum=carry;
			if(num1!=null) {
				sum+=num1.data;
				num1=num1.next;
			}
			if(num2!=null) {
				sum+=num2.data;
				num2=num2.next;
			}
			carry=sum/10;
			sum=sum%10;
			result.next=new Node(sum);
			result=result.next;
		}
		head=dummy.next;
	}

	private void sort012() {
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
				zeroTail = zeroTail.next;
			} else if (curr.data == 1) {
				oneTail.next = curr;
				oneTail = oneTail.next;
			} else if (curr.data == 2) {
				twoTail.next = curr;
				twoTail = twoTail.next;
			}
			curr = curr.next;
		}
		zeroTail.next = (oneTail.next != null) ? oneDummy.next : twoDummy.next;
		oneTail.next = twoDummy.next;
		twoTail.next = null;
		head = zeroDummy.next;
	}

	private void segregateEvenOddNumber() {
		Node oddDummy = new Node(0);
		Node evenDummy = new Node(0);
		Node oddTail = oddDummy;
		Node evenTail = evenDummy;
		Node curr = head;
		while (curr != null) {
			int n = curr.data;
			int q = 0;
			while (n != 0) {
				q = n % 10;
				int r = n / 10;
				n = r;
			}
			if (q % 2 == 0) {
				evenTail.next = curr;
				evenTail = evenTail.next;
			} else {
				oddTail.next = curr;
				oddTail = oddTail.next;
			}
			curr = curr.next;
		}
		oddTail.next = evenDummy.next;
		evenTail.next = null;
		head = oddDummy.next;
	}

//	10 -> 20 -> 30 -> 40 -> 50
//	0    1        2   3     4
	private void segregateEvenOddNodes() {
		Node evenDummy = new Node(0);
		Node oddDummy = new Node(0);
		Node evenCurr = evenDummy;
		Node oddCurr = oddDummy;
		Node curr = head;
		int i = 1;
		while (curr != null) {
			if (i % 2 == 0) {
				evenCurr.next = curr;
				evenCurr = evenCurr.next;
			} else {
				oddCurr.next = curr;
				oddCurr = oddCurr.next;
			}
			i++;
			curr = curr.next;
		}
		oddCurr.next = evenDummy.next;
		evenCurr.next = null;
		head = oddDummy.next;
	}

	private void rotateRight(int key) {
		key = key % size;
		Node newHead = null;
		Node newTail = null;
		Node curr = head;
		for (int i = 0; i < size - key; i++) {
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

	private void rotateLeft(int key) {
		Node newHead = null;
		Node newTail = null;
		Node curr = head;
		for (int i = 0; i < key; i++) {
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
		Node prev = null;
		Node next = null;
		Node curr = head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	private void addAt(int data, int index) {
		Node curr = head;
		Node newNode = new Node(data);
		Node prev = null;
		for (int i = 1; i < index; i++) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = newNode;
		newNode.next = curr;
		size++;
	}

	private void deleteMiddle() {
		Node slow = head;
		Node fast = head;
		Node prev = null;
		while (fast.next != null && fast.next.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = slow.next;
		size--;
	}

	private void deleteFirst() {
		head = head.next;
		size--;
	}

	private void addFirst(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		}
		newNode.next = head;
		head = newNode;
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
