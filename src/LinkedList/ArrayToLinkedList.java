package LinkedList;

// Program: Convert Array to Linked List (Reusable Method)

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ArrayToLinkedList {

    // Method to convert array into linked list
    private static Node convertArr2LL(int[] arr) {
        // Step 1: Create head node from first element of array
        Node head = new Node(arr[0]);

        // 'mover' will keep track of the last node of linked list
        Node mover = head;

        // Step 2: Loop through remaining elements of array
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]); // create new node
            mover.next = temp;            // link last node to new node
            mover = temp;                 // update mover to new last node
        }

        // Step 3: Return head (starting point of Linked List)
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};

        // Convert array to linked list
        Node head = convertArr2LL(arr);

        // Print first element of LL (head)
        System.out.println("Head Node Data: " + head.data);

        // Print the full linked list
        System.out.print("Linked List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
