class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

class MyLinkedList {
    Node head;

    MyLinkedList() {
        head = null;
    }

    void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode; 
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" -> NULL");
    }
}

class MySolution {
    void sortZeroOneTwo(MyLinkedList ll) {
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);

        Node zeroTail = zeroDummy;
        Node oneTail = oneDummy;
        Node twoTail = twoDummy;

        Node curr = ll.head;

        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
        }

        zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null;

        ll.head = zeroDummy.next;
    }
}

public class SortLinkedListOf012 {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        MySolution sol = new MySolution();

        ll.insert(1);
        ll.insert(2);
        ll.insert(0);
        ll.insert(1);
        ll.insert(2);
        ll.insert(0);

        System.out.println("Original List:");
        ll.print();

        // Sorting the list
        sol.sortZeroOneTwo(ll);

        System.out.println("Sorted List:");
        ll.print();
    }
}