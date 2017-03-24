package Q2_8_Loop_Detection;

import CtCILibrary.LinkedListNode;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning
 * of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
 * so as to make a loop in the linked list.
 */

public class Question {

    public static LinkedListNode FindBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // Error check - there is no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

		/* Move slow to Head. Keep fast at Meeting Point. Each are k steps
		   from the Loop Start. If they move at the same pace, they must
		   meet at Loop Start. */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both now point to the start of the loop.
        return fast;
    }

    public static void main(String[] args) {
        int list_length = 10;
        int k = 4;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }

        // Creating loop
        //  1 ->  2 ->  3 ->  4 ->  5 ->  6 -> 7 -> 8 -> 9 -> 10
        //                                ^                    |
        //                                |                    |
        //                                 <-------------------
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode loop = FindBeginning(nodes[0]);
        if (loop == null) {
            System.out.println("No Loop.");
        } else {
            System.out.println(loop.data);
        }
    }

}
