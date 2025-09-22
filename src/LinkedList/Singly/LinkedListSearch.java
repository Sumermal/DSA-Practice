package LinkedList.Singly;

public class LinkedListSearch {

    // Node class remains the same as before
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static boolean search(Node head, int value) {
        // Start from the head of the list
        Node current = head;

        // Traverse the list until the end
        while (current != null) {
            // Check if the current node's data matches the value
            if (current.data == value) {
                return true; // Value found
            }
            // Move to the next node
            current = current.next;
        }

        return false; // Value not found after traversing the entire list
    }

    public static void main(String[] args) {
        // Create a sample linked list: 10 -> 20 -> 30 -> 40 -> null
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        // Search for a value that exists
        int valueToFind = 30;
        if (search(head, valueToFind)) {
            System.out.println("The value " + valueToFind + " was found in the list.");
        } else {
            System.out.println("The value " + valueToFind + " was not found in the list.");
        }

    }
}
