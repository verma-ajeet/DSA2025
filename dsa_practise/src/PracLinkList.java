class PLL {
	int data;
	PLL next;

	public PLL(int data) {
		this.data = data;
	}
}

public class PracLinkList {
	public static void main(String[] args) {
		PLL l = new PLL(10);
		l.next = new PLL(20);
		l.next.next = new PLL(30);
		l.next.next.next = new PLL(40);
		l.next.next.next.next = new PLL(50);
		System.out.println("orginal linklist");
		print(l);
		getSize(l);
		System.out.println("reverse linklist");
		PLL reverse = reverse(l);
		print(reverse);
		System.out.println("rotate linklist");
		PLL rotate = rotate(reverse, 2);
		print(rotate);
	}

	private static PLL rotate(PLL head, int k) {
		PLL oldTail = head;
		while (oldTail.next != null) {
			oldTail = oldTail.next;
		}
		k=k%getSize(head);
		int len=getSize(head)-k;
		PLL newHead=null;
		PLL newTail=head;
		for(int i=0;i<len-1;i++) {
			newTail=newTail.next;
		}
		newHead=newTail.next;
		newTail.next=null;
		oldTail.next=head;
		return newHead;
	}

	private static PLL reverse(PLL head) {
		if (head == null || head.next == null) {
			return head;
		}
		PLL prev = null;
		PLL curr = head;
		PLL next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static int getSize(PLL head) {
		int size = 0;
		PLL curr = head;
		while (curr != null) {
			curr = curr.next;
			size++;
		}
		return size;
	}

	private static void print(PLL head) {
		PLL curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}
