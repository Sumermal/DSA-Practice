package LinkedList.Singly;

public class ArrayToLinkedList {

    // Inner Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Convert array to linked list
    public static Node convertArr2LL(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};

        // Convert array to linked list
        Node head = convertArr2LL(arr);

        // Print linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
