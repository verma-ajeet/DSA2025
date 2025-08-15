
class LLO {
	int data = 0;
	LLO next = null;

	public LLO(int data) {
		this.data = data;
	}

}

public class LLOperations {
	public static void main(String[] args) {
		LLO l = new LLO(10);
		l.next = new LLO(20);
		l.next.next = new LLO(30);
		l.next.next.next = new LLO(40);
		l.next.next.next.next = new LLO(50);
		print(l);
		LLO reverse = reverse(l);
		print(reverse);
		getSize(reverse);
		LLO deleteMiddle = deleteMiddle(reverse);
		print(deleteMiddle);

	}

	private static int getSize(LLO head) {
		LLO curr = head;
		int len=0;
		while (curr != null) {
			len++;
			curr=curr.next;
		}
		return len;
	}

	private static LLO deleteMiddle(LLO head) {
		LLO curr=head;
      int n=(getSize(head)/2)-1;
      int i =0;
      while(i<n) {
    	  curr=curr.next;
    	  i++;
      }
      curr.next=curr.next.next;
      return head;
	}

	private static LLO reverse(LLO head) {
		if (head == null) {
			return null;
		}
		LLO prev = null;
		LLO next = null;
		LLO curr = head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static void print(LLO head) {
		LLO curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}
