package LinkedList.Doubly;

import java.util.Stack;

public class ReverseDoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node back;

        Node(int data) { this.data = data; this.next = null; this.back = null; }
        Node(int data, Node next, Node back) { this.data = data; this.next = next; this.back = back; }
    }

    private static Node convertArr2DLL(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void print(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // Reverse by swapping node pointers (in-place, O(1) extra memory)
    private static Node reverseDLL_Pointers(Node head) {
        if (head == null) return null;

        Node current = head;
        Node newHead = null;            // will become the new head (original tail)

        while (current != null) {
            // swap next and back
            Node tmp = current.next;
            current.next = current.back;
            current.back = tmp;

            // current now points to the previous node via 'next' and to the original next via 'back'
            newHead = current;         // last processed node will be the new head
            // move to the next node in the original forward direction (which is current.back after swap)
            current = current.back;
        }
        return newHead;
    }

    // Reverse by using a stack to reverse data only (keeps nodes in same order)
    private static Node reverseDLL_Stack(Node head) {
        if (head == null) return null;
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8, 4};

        // Demo 1: pointer-based reversal (in-place)
        Node head1 = convertArr2DLL(arr);
        System.out.println("Original (for pointer reversal):");
        print(head1);
        head1 = reverseDLL_Pointers(head1);
        System.out.println("After Reversing with Pointers:");
        print(head1);               // expected: 4 8 6 5 12

        System.out.println();

        // Demo 2: stack-based data reversal (operates on a fresh list)
        Node head2 = convertArr2DLL(arr);
        System.out.println("Original (for stack/data reversal):");
        print(head2);
        head2 = reverseDLL_Stack(head2);
        System.out.println("After Reversing with Stack (data reversed):");
        print(head2);               // expected: 4 8 6 5 12
    }
}

