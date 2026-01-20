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

    public void push_back(int data){
        Node newNode = new Node(data);

        if(head == null){
            tail = newNode;
            head = tail; 
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
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

    void pop_front() {
        if (head == null){
            System.out.println("DLL is empty.");
            return;
        }
        Node temp = head;
        head = head.next;

        if(head != null){
            head.prev = null;
        }
        temp.next = null;
    }


    public static void main(String args[]){
        IntroDoublyLinkedList dll = new IntroDoublyLinkedList();   
        // dll.push_front(1);
        // dll.push_front(2);
        // dll.push_front(3);

        dll.print();

        dll.push_back(1);
        dll.push_back(2);
        dll.push_back(3);

        dll.print();

        dll.pop_front();
        dll.print();
    }
}
