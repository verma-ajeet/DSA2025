class LLReverse {
	int data;
	LLReverse next;

	public LLReverse(int data) {
		this.data = data;
	}

}

public class LLReversePrac {
	public static void main(String[] args) {
		LLReverse l = new LLReverse(10);
		l.next = new LLReverse(20);
		l.next.next = new LLReverse(30);
		l.next.next.next = new LLReverse(40);
		l.next.next.next.next = new LLReverse(50);
		print(l);
		int len = getSize(l);
		LLReverse reverse = reverse(l);
		print(reverse);
		LLReverse rotate = rotateright(reverse, 2, len);
		print(rotate);
	}
// 20,10,50,40,30
	private static LLReverse rotateright(LLReverse head, int k, int len) {
		k = k % len;
		LLReverse newTail = null;
		LLReverse newHead = null;
		LLReverse current = head;
		for (int i = 0; i < len-k; i++) {
			newTail = current;
			current = current.next;
		}
		newHead = current;
		newTail.next = null;
		while (current.next != null) {
			current = current.next;
		}
		current.next = head;
		return newHead;
	}	

	private static LLReverse reverse(LLReverse head) {
		LLReverse prev = null;
		LLReverse next = null;
		LLReverse curr = head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static void print(LLReverse head) {
		LLReverse curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	private static int getSize(LLReverse head) {
		LLReverse curr = head;
		int len = 0;
		while (curr != null) {
			len++;
			curr = curr.next;
		}
		return len;
	}
}
