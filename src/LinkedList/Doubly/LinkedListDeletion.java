package LinkedList.Doubly;


public class LinkedListDeletion {
    static class Node {
        int data;
        Node next;
        Node back;

        public Node(int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

        Node(int data1) {
            this.data = data1;
            this.next = null;
            this.back = null;
        }
    }

    private static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node prev = head;
        head = head.next;

        head.back = null;
        prev.next = null;

        return head;
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node newTail = tail.back;
        newTail.next = null;
        tail.back = null;

        return head;
    }

    private static Node removeKthElement(Node head, int k){
        if (head == null){
            return null;
       }
        int cnt = 0;
        Node kNode = head;
        while (kNode != null) {
            cnt++;
            if (cnt == k) break;
            kNode = kNode.next;
        }
        Node prev = kNode.back;
        Node front = kNode.next;

        if (prev == null && front == null) {
            return null;
        }
        else if (prev == null) {
            return deleteHead(head);
        }
        else if (front == null) {
            return deleteTail(head);
        }
        prev.next = front;
        front.back = prev;

        kNode.next = null;
        kNode.back = null;

        return head;
    }

    private static void deleteNode (Node temp) {
        Node prev = temp.back;
        Node front = temp.next;

        if (front == null) {
            prev.next = null;
            temp.back = null;
        }
        prev.next = front;
        front.back = prev;

        temp.next = temp.back = null;
    }

    private static Node convertArr2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void print(Node head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] arr = {12, 5, 8, 7};
        Node head = convertArr2DLL(arr);
        deleteNode(head.next.next);
        print(head);
    }
}
