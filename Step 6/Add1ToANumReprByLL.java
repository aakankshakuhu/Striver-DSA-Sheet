public class Add1ToANumReprByLL {

    private int size;

    Add1ToANumReprByLL() {
        this.size = 0;
    }

    public class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    Node head;

    public void addLast(int data){
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

    public int addOne(Node node){
        if(node == null)    return 1;

        int carry = addOne(node.next);
        int sum = node.data + carry;
        node.data = sum % 10;
        return sum / 10;
    }

    public Node addToLL(Node head){
        int carry = addOne(head);

        if(carry != 0){
            Node newHead = new Node(carry);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }
    

    public static void main(String args[]){
        Add1ToANumReprByLL list = new Add1ToANumReprByLL();
        // list.addLast(1);
        // list.addLast(3);
        // list.addLast(9);

        // list.printList();

        // list.head = list.addToLL(list.head);

        // list.printList();
        // System.out.println();

        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);
        list.printList();

        list.head = list.addToLL(list.head);

        list.printList();

    
       
    }
}
