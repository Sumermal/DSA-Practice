package LinkedList.Singly;


public class TraversalInLinkedList {

    private static Node convertArr2LL(int[] arr) {

        Node head = new Node(arr[0]);
        Node mover = head;

        // Step 2: Loop through remaining elements of array
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]); // create new node
            mover.next = temp;            // link last node to new node
            mover = temp;                 // update mover to new last node
        }

        return head;
    }

    private static void traverse(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};

        // Convert array to linked list
        Node head = convertArr2LL(arr);

        // Print only head data
        System.out.println("Head Node: " + head.data);

        // Traverse and print entire linked list
        System.out.print("Full Linked List: ");
        traverse(head);
    }
}

