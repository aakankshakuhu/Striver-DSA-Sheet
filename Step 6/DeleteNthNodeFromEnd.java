import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    Node(int data1) {
        data = data1;
        next = null;
    }
}

class Solution {

    public void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public Node deleteNthNodeFromEnd(Node head, int N) {
        Node dummy = new Node(0, head);

        Node slow = dummy;
        Node fast = dummy;

        for (int i = 0; i <= N; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}

public class DeleteNthNodeFromEnd{
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;

        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        head.next.next.next.next = new Node(arr.get(4));

        Solution sol = new Solution();

        head = sol.deleteNthNodeFromEnd(head, N);

        sol.printLL(head);
    }
}
