public class IntroLinkedList {

    class Node {
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    //add- first, last
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }
    
    //print list
    public void printList() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("NULL");
    }

    //delete frst
    public void deleteFirst() {
        if(head == null){
            System.out.println("The list is empty.");
        }

        head = head.next;
    }

    //delete last
    public void deleteLast(){
        if(head == null){
            System.out.println("The list is empty.");
        }

        if(head.next == null){
            head = null;
            return;
        }
        Node secLast = head;
        Node lastNode = head.next;

        while(lastNode.next != null){
            lastNode = lastNode.next;
            secLast = secLast.next;
        }

        secLast.next = null;
    }

    

    public static void main(String args[]){
        IntroLinkedList list = new IntroLinkedList();
        list.addFirst("a");
        list.addFirst("is");
        list.printList();
        list.addLast("list");
        list.addFirst("This");
        list.printList();
        list.deleteFirst();
        list.printList();
        list.deleteLast();
        list.printList();
    }
}
