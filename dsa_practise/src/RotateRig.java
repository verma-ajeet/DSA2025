class NodeRight {
	int data = 0;
	NodeRight next = null;

	public NodeRight(int data) {
		this.data = data;
	}

}

public class RotateRig {
	public static void main(String[] args) {
		NodeRight l = new NodeRight(10);
		l.next = new NodeRight(20);
		l.next.next = new NodeRight(30);
		l.next.next.next = new NodeRight(40);
		l.next.next.next.next = new NodeRight(50);
		print(l);
		int size = getSize(l);
		System.out.println(size);
		NodeRight rotateRight = RotateRight(l, 2);
		print(rotateRight);
	}

	private static int getSize(NodeRight head) {
		NodeRight curr = head;
		int len = 0;
		while (curr.next != null) {
			len++;
			curr = curr.next;
		}
		return len;
	}

	private static NodeRight RotateRight(NodeRight head, int key) {
		key = key % getSize(head);
		int n = getSize(head) - key;
		System.out.println("n= "+n);
		NodeRight newhead = null;
		NodeRight newTail = null;
		NodeRight curr = head;
		for (int i = 0; i < n; i++) {
			newTail = curr;
			curr = curr.next;
		}
		newhead = curr;
		newTail.next = null;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next =head;
		return newhead;
	}

	private static void print(NodeRight head) {
		NodeRight curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.print("null");
		System.out.println();
	}

}
