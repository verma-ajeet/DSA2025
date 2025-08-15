
class Node012 {
	int data = 0;
	Node012 next = null;

	public Node012(int data) {
		super();
		this.data = data;
	}

}

public class LLSort123 {
	Node012 head = null;
	int size = 0;

	public LLSort123() {
		super();
		this.head = null;
	}

	public static void main(String[] args) {
		LLSort123 l = new LLSort123();
		l.add(0);
		l.add(1);
		l.add(0);
		l.add(2);
		l.add(0);
		l.add(1);
		l.add(2);
		l.add(1);
		l.add(1);
		l.print();
		System.out.println(l.size);
		l.sort();
		l.print();
	}

	private void sort() {
		   // Create dummy nodes for 0s, 1s, and 2s
		Node012 zeroDummy = new Node012(0);
		Node012 oneDummy = new Node012(0);
		Node012 twoDummy = new Node012(0);

	    // Create pointers to the tails of sublists
		Node012 zeroTail = zeroDummy;
		Node012 oneTail = oneDummy;
		Node012 twoTail = twoDummy;
		 // Pointer to traverse the original linked list
		Node012 current = head;
		// Traverse the original linked list
	    while (current != null) {
	        if (current.data == 0) {
	            zeroTail.next = current;
	            zeroTail = current;
	        } else if (current.data == 1) {
	            oneTail.next = current;
	            oneTail = current;
	        } else {
	            twoTail.next = current;
	            twoTail = current;
	        }
	        // Move to the next node in the original linked list
	        current = current.next;
	    }
	    // Concatenate the sublists to form the sorted linked list
	    zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
	    oneTail.next = twoDummy.next;
	    twoTail.next = null;
	}

	private void print() {
		Node012 curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.print("null");
		System.out.println();
	}

	private void add(int data) {
		Node012 newNode = new Node012(data);
		if (head == null) {
			head = newNode;
		} else {
			Node012 curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
		size++;
	}

}
