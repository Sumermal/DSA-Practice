package LinkedList.Singly;


public class LengthOfLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }
    }

    // Function to calculate length
    private static int getLength(Node head) {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {
        // Creating a linked list: 10 -> 20 -> 30 -> 40 -> null
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Length of Linked List: " + getLength(head));
    }
}

