package Linkedlist;

class Linklist {
	int data;
	Linklist next;

	public Linklist(int data) {
		this.data = data;
	}
}

public class MiddleElementLL {
	public static void main(String[] args) {
		Linklist head = new Linklist(1);
		head.next = new Linklist(2);
		head.next.next = new Linklist(3);
		head.next.next.next = new Linklist(4);
		head.next.next.next.next = new Linklist(5);
//		head.next.next.next.next = head.next;
		print(head);
		getMiddleElement(head);
		System.out.println("length is " + getLength(head));
		deleteMiddleElement(head);
		print(head);
		System.out.println("is cyclic " + isCyclic(head));
		System.out.println("delete first");
		head = deleteStart(head);
		print(head);
		System.out.println("delete last ");
		head = deleteLast(head);
		print(head);
	}

	public static void print(Linklist head) {
		Linklist current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static int getLength(Linklist head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			len++;
		}
		return len;
	}

	public static void getMiddleElement(Linklist head) {
		Linklist slow = head;
		Linklist fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("middle element is: " + slow.data);
	}

	public static Linklist deleteStart(Linklist head) {
		Linklist first = head;
		if (head == null) {
			System.out.println("list is empty");
			return null;
		}
		return head.next;
//		System.out.println(first.next.data);
	}

	public static void deleteMiddleElement(Linklist head) {
		if (getLength(head) / 2 != 0) {
			int q = getLength(head) / 2;
			System.out.println("q= " + q);
			for (int i = 1; i < q; i++) {
				head = head.next;
				System.out.println("h " + head.data);
			}
			head.next = head.next.next;
		}
	}

	public static Linklist deleteLast(Linklist head) {
      if(head==null || head.next==null) {
    	  return null;
      }
      Linklist prev=null;
      Linklist curr=head;
      while(curr.next!=null) {
    	  prev=curr;
    	  curr=curr.next;
    	  System.out.println(curr.data);
      }
      prev.next=null;
      return head;
	}

	public static boolean isCyclic(Linklist head) {
		Linklist slow = head;
		Linklist fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
