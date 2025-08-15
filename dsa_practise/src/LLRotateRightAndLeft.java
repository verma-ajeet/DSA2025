class PL {
	int data = 0;
	PL next = null;

	public PL(int data) {
		this.data = data;
	}
}

public class LLRotateRightAndLeft {
	public static void main(String[] args) {
		PL l = new PL(10);
		l.next = new PL(20);
		l.next.next = new PL(30);
		l.next.next.next = new PL(40);
		l.next.next.next.next = new PL(50);
		print(l);
		PL reverse = reverse(l);
		print(reverse);
		PL rotateright = rotateright(reverse,2);
		print(rotateright);
		PL rotateleft = rotateleft(rotateright,2);
		print(rotateleft);
	}

	private static PL rotateright(PL head, int k) {
		if(head==null) {
			return null;
		}
		int len=getSize(head);
		k=k%len;
		if(k==len) {
			return head;
		}
		PL newHead=null;
		PL newTail=null;
		PL curr=head;
		for(int i=0;i<len-k;i++) {
			newTail=curr;
			curr=curr.next;
		}
		newHead=curr;
		newTail.next=null;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next=head;
		return newHead;
	}

	private static PL rotateleft(PL head, int k) {
		if(head==null) {
			return null;
		}
		int len=getSize(head);
		k=k%len;
		if(k==len) {
			return head;
		}
		PL newHead=null;
		PL newTail=null;
		PL curr=head;
		for(int i=0;i<k;i++) {
			newTail=curr;
			curr=curr.next;
		}
		newHead=curr;
		newTail.next=null;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next=head;
		return newHead;
	}
	
	private static PL reverse(PL head) {
		if (head == null) {
			return head;
		}
		PL prev=null;
		PL next=null;
		PL curr=head;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}
	private static int getSize(PL head) {
		int len=0;
		PL curr = head;
		while (curr != null) {
			len++;
			curr = curr.next;
		}
		return len;
	}
	private static void print(PL head) {
		PL curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}
