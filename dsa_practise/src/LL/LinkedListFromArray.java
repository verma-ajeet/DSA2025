package LL;
//class Node {
//    int data;
//    Node next;
//
//    public Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}

public class LinkedListFromArray {
    Node head;

    public LinkedListFromArray(int[] array) {
        head = createLinkedList(array);
    }

    private Node createLinkedList(int[] array) {
        if (array == null || array.length == 0) {
            return null; // Return null for an empty array
        }

        Node head = new Node(array[0]);
        Node current = head;

        for (int i = 1; i < array.length; i++) {
            Node newNode = new Node(array[i]);
            current.next = newNode;
            current = newNode;
        }

        return head;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        LinkedListFromArray linkedList = new LinkedListFromArray(array);

        System.out.println("Linked List created from Array:");
        linkedList.print();
    }
}
