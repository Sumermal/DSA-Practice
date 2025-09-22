package LinkedList.Singly;

public class LinkedListInsertion {

    private static class Node {
        int data;
        Node next;

        Node(int data1) {
            this.data = data1;
            this.next = null;
        }

        Node(int data1, Node next1) {
            this.data = data1;
            this.next = next1;
        }
    }

    private static Node convertArr2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
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

    private static Node insertHead(Node head, int val){
        return new Node(val,head);
    }

    private static Node insertTail(Node head, int val){
        if (head == null){
            return new Node(val);
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        return head;
    }

    private static Node insertPosition(Node head, int el, int k){
        if (head == null){
            if (k == 1){
                return new Node(el);
            }
            else {
                return head;
            }
        }
        if (k == 1) {
            return new Node(el, head);
        }
        int cnt = 0;
        Node temp = head;
        while (temp != null){
            cnt++;
            if (cnt == (k-1)) {
                Node x = new Node(el, temp.next);
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node insertBeforeValue(Node head, int el, int val){
        if (head == null){
            return null;
        }
        if (head.data == val) {
            return new Node(el, head);
        }
        Node temp = head;
        boolean found = false;
        while (temp.next != null){
            if (temp.next.data == val) {
                Node x = new Node(el, temp.next);
                temp.next = x;
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (found == false){
            System.out.println("Not found!!");
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr ={2, 5, 6, 8};
        Node head = convertArr2LL(arr);
        head = insertBeforeValue(head,100, 6);
        print(head);

    }
}