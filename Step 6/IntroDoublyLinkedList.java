public class IntroDoublyLinkedList {
    
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;

    public IntroDoublyLinkedList() {
        head = null;
        tail = null;
    }

    public static void main(String args[]){
        IntroDoublyLinkedList dll = new IntroDoublyLinkedList();   
    }
}
