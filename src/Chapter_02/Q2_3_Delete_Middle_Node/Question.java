package Q2_3_Delete_Middle_Node;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle(i.e., any node
 * but the first and last node, not necessarily the exact middle) of the singly linked list,
 * given only access to that node.
 */

public class Question {

    public static boolean deleteNode(LinkedListNode n) {

        if (n == null || n.next == null) return false; //Failure

        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteNode(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
    }
}
