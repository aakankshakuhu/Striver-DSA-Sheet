class Node {
    int data;
    Node next;


    Node(int data1) {
        data = data1;
        next = null;
    }
}

class Solution {
    public int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return countLoopLength(slow);
            }
        }
        return 0;
    }

    public int countLoopLength(Node meetingPoint) {
        Node temp = meetingPoint;
        int length = 1;

        // Move until we meet again
        while (temp.next != meetingPoint) {
            temp = temp.next;
            length++;
        }
        return length;
    }
}

public class LengthOfLoop {
    public static void main(String[] args) {
        // Creating a sample linked list with a loop
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Linking the nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Creating a loop from fifth to second
        fifth.next = second;

        Solution obj = new Solution();

        int loopLength = obj.lengthOfLoop(head);

        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }
}