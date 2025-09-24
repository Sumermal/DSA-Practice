package LinkedList.Doubly;

public class LinkedListInsertion {
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

    private static Node insertBeforeHead (Node head, int val) {
        Node newHead = new Node(val, head, null);
        head.back = newHead;

        return newHead;
    }

    private static Node insertBeforeTail (Node head, int val) {
        if (head.next == null) {
            return insertBeforeHead(head, val);
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.back;
        Node newNode = new Node(val, tail, prev);
        prev.next = newNode;
        tail.back = newNode;

        return head;
    }

    private static Node insertBeforeKthElement (Node head, int k, int val) {
        if (k == 1) {
            return insertBeforeHead(head, val);
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) break;
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(val, temp, prev);
        prev.next = newNode;
        temp.back = newNode;

        return head;
    }

    private static void insertBeforeNode(Node node, int val) {
        Node prev = node.back;
        Node newNode = new Node(val, node, prev);
        prev.next = newNode;
        node.back = newNode;
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
        insertBeforeNode(head.next, 44);
        print(head);
    }
}
