package LinkedList.Doubly;

public class ArrayToLinkedList {
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
        print(head);
    }
}
