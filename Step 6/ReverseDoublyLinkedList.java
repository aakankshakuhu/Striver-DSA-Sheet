import java.util.Stack;
public class ReverseDoublyLinkedList {
    
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

    public ReverseDoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void push_front(int data) {
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }


    public void print(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " <=> ");
            temp = temp.next;
        }
        System.out.println("NULL\n");
    }

    public Node reverseDLL(){
        if(head == null || head.next == null){
            return head;
        }

        Stack<Integer> st = new Stack<>();

        Node temp = head;

        while(temp != null){
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }

    public static void main(String args[]){
        ReverseDoublyLinkedList dll = new ReverseDoublyLinkedList();   
        dll.push_front(1);
        dll.push_front(2);
        dll.push_front(3);

        dll.print();

        System.out.println(dll.reverseDLL());

        dll.print();
    }
}


