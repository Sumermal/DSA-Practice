package LinkedList.Singly;

public class LinkedListDeletion {

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
    private static int checkIfPresent(Node head, int val){
        Node temp = head;
        while (temp != null){
            if(temp.data == val) return 1;
            temp = temp.next;
        }
        return 0;
    }

    private static void print(Node head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
        System.out.println();
    }

    private static Node removeHead(Node head){
        if(head == null){
            return head;
        }
        Node temp = head;
        head = head.next;
        return head;
    }

    private static Node removeTail(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    private static Node removeK(Node head, int k){
        if (head == null) return head;
        if (k == 1){
            Node temp = head;
            head = head.next;
            return head;
        }
        int cnt = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null){
            cnt++;
            if (cnt == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }


    private static Node removeElement(Node head, int el){
        if (head == null) return head;
        if (head.data == el){
            Node temp = head;
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null){
            if (temp.data == el){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
       int[] arr ={2, 5, 6, 8};
       Node head = convertArr2LL(arr);
       head = removeElement(head,6);
        print(head);

    }
}
